package tuti.desi.presentacion.clientes;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Cliente;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.VueloService;
import tuti.desi.servicios.clientes.ClienteService;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ClienteEditarController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VueloService vueloService;

    @GetMapping("/crear-cliente")
    public String preparaForm(Model modelo) throws Exception {
        ClienteForm form = new ClienteForm();
        modelo.addAttribute("formBean", form);
        return "reservas/crearCliente";
    }

    /*@GetMapping("/{dni}")
    public String preparaForm(Model modelo, @PathVariable("dni") Long dni) throws Exception {
        ClienteForm form = new ClienteForm(clienteService.getClienteByDni(dni));
        modelo.addAttribute("formBean", form);
        return "reservas/reservarVuelo";
    }*/

    @GetMapping("/{dni}")
    public String preparaForm(
            Model modelo,
            @PathVariable("dni") Long dni,
            @RequestParam(name = "vuelo", required = false) Long idVuelo
    ) throws Exception {
        ClienteForm form = new ClienteForm(clienteService.getClienteByDni(dni));
        modelo.addAttribute("formBean", form);
        if (idVuelo != null) {
            List<Asiento> asientosDisponibles = vueloService.obtenerAsientosDisponibles(idVuelo);
            modelo.addAttribute("idVuelo", idVuelo);
            modelo.addAttribute("asientosDisponibles", asientosDisponibles);
        }
        return "reservas/reservarVuelo";
    }

    @PostMapping("/{dni}/{idVuelo}")
    public String submit(
            @ModelAttribute("formBean") @Valid ClienteForm formBean,
            BindingResult result,
            ModelMap model,
            @PathVariable("dni") Long dni,
            @PathVariable("idVuelo") Long idVuelo,
            @RequestParam("asiento") Integer asiento,
            @RequestParam String action
    ) {
        if (action.equals("Reservar")) {
            System.out.println("--------------------------------------------------");
            System.out.println("Reservando asiento " + asiento);
            System.out.println("Del vuelo " + idVuelo);
            System.out.println("Para el cliente " + dni);
            System.out.println("--------------------------------------------------");
        }
        return "redirect:/";
    }



    @ModelAttribute("allVuelos")
    public List<Vuelo> getAllVuelos() {
        return this.vueloService.obtenerTodosLosVuelos();
    }

    @ModelAttribute("allAsientos")
    public List<Asiento> getAllAsientos(@RequestParam(name = "idVuelo", required = false) Long idVuelo) {
        if (idVuelo != null) {
            return this.vueloService.obtenerAsientosDisponibles(idVuelo);
        } else {
            // Si idVuelo es nulo, devuelve una lista vacía o maneja de acuerdo a tus necesidades
            return Collections.emptyList();
        }
    }


    @RequestMapping(path = "/delete/{dni}", method = RequestMethod.GET)
    public String deleteClienteById(Model model, @PathVariable("dni") Long dni) {
        clienteService.deleteClienteByDni(dni);
        return "redirect:/";
    }

    @PostMapping("/crear-cliente")
    public String submit(
            @ModelAttribute("formBean") @Valid ClienteForm formBean,
            BindingResult result,
            ModelMap modelo,
            @RequestParam String action
    ) throws Exception {
        if (action.equals("Aceptar")) {
            if (result.hasErrors()) {
                modelo.addAttribute("formBean", formBean);
                return "reservas/crearCliente";
            } else {
                Cliente p = formBean.toPojo();
                try {
                    clienteService.save(p);
                    return "redirect:/";
                } catch (Excepcion e) {
                    // Si la excepcion refiere a un atributo del objeto, se muestra junto al componente (ej. dni)
                    if (e.getAtributo() == null) {
                        ObjectError error = new ObjectError("globalError", e.getMessage());
                        result.addError(error);
                    } else {
                        FieldError error1 = new FieldError("formBean", e.getAtributo(), e.getMessage());
                        result.addError(error1);
                    }
                    modelo.addAttribute("formBean", formBean);
                    // Como existe un error me quedo en la misma pantalla
                    return "reservas/crearCliente";
                }
            }
        }
        if (action.equals("Cancelar")) {
            modelo.clear();
            return "redirect:/clientesBuscar";
        }
        return "redirect:/";
    }
}