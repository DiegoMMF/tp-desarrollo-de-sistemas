package tuti.desi.presentacion.clientes;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import tuti.desi.servicios.asientos.AsientoService;
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

    @Autowired
    private AsientoService asientoService;

    @GetMapping("/crear-cliente")
    public String preparaForm(Model modelo) throws Exception {
        ClienteForm form = new ClienteForm();
        modelo.addAttribute("formBean", form);
        return "reservas/crearCliente";
    }

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

            boolean alreadyReserved = false;
            List<Asiento> asientosReservados = vueloService.obtenerAsientosReservadosPorVuelo(idVuelo);
            for (Asiento asientoReservado : asientosReservados) {
                if (asientoReservado.getCliente().getDni().equals(dni)) {
                    alreadyReserved = true;
                    break;
                }
            }
            modelo.addAttribute("precio", vueloService.obtenerVueloPorId(idVuelo).getPrecioPasaje());
            modelo.addAttribute("clienteYaHaReservado", alreadyReserved);
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
            @RequestParam("asiento") Long asiento,
            @RequestParam String action
    ) throws Exception {
        if (action.equals("Reservar")) {
            if (result.hasErrors()) {
                model.addAttribute("formBean", formBean);
                return "reservas/reservarVuelo";
            }
            Asiento asientoReservado = asientoService.obtenerAsientoPorId(asiento);
            asientoReservado.setCliente(clienteService.getClienteByDni(dni));
            try {
                Boolean success = asientoService.update(asientoReservado);
                if (!success) {
                    model.addAttribute("error", "No se pudo reservar el asiento.");
                    return "reservas/reservarVuelo";
                }
            } catch (DataIntegrityViolationException e) {
                model.addAttribute("error", "Error al reservar el asiento: " + e.getMessage());
                return "reservas/reservarVuelo";
            }
        }
        return "/success";
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
                    return "/success";
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
            return "redirect:/";
        }
        return "redirect:/";
    }
}