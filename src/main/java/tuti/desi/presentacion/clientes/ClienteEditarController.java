package tuti.desi.presentacion.clientes;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Cliente;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.ciudades.CiudadService;
import tuti.desi.servicios.clientes.ClienteService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reservas")
public class ClienteEditarController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/crear-cliente")
    public String preparaForm(Model modelo) throws Exception {
        ClienteForm form = new ClienteForm();
        modelo.addAttribute("formBean", form);
        return "reservas/crearCliente";
    }

    @GetMapping("/{dni}")
    public String preparaForm(Model modelo, @PathVariable("dni") Long dni) throws Exception {
        Cliente entity = clienteService.getClienteByDni(dni);
        ClienteForm form = new ClienteForm(entity);
        modelo.addAttribute("formBean", form);
        return "reservas/reservarVuelo";
    }

    @RequestMapping(path = "/delete/{dni}", method = RequestMethod.GET)
    public String deleteClienteById(Model model, @PathVariable("dni") Long dni) {
        clienteService.deleteClienteByDni(dni);
        return "redirect:/";
    }


    @PostMapping
    public String submit(
            @ModelAttribute("formBean") @Valid ClienteForm formBean,
            BindingResult result,
            ModelMap modelo,
            @RequestParam String action
    ) throws Exception {
        if (action.equals("Aceptar")) {
            if (result.hasErrors()) {
                modelo.addAttribute("formBean", formBean);
                return "crearCliente";
            } else {
                Cliente p = formBean.toPojo();
                try {
                    clienteService.save(p);

                    return "redirect:/clientesBuscar";
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
                    return "crearCliente";//Como existe un error me quedo en la misma pantalla
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