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
@RequestMapping("/clienteEditar")
public class ClienteEditarController {
    @Autowired
    private ClienteService service;
    @Autowired
    private CiudadService serviceCiudad;

    @RequestMapping(path = {"", "/{id}"},method= RequestMethod.GET)
    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> dni) throws Exception {
        if (dni.isPresent()) {
            Cliente entity = service.getClienteById(dni.get());
            ClienteForm form = new ClienteForm(entity);
            modelo.addAttribute("formBean", form);
        } else {
            modelo.addAttribute("formBean",new ClienteForm());
        }
        return "clienteEditar";
    }

    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.serviceCiudad.getAll();
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deleteClienteById(Model model, @PathVariable("id") Long id)
    {
        service.deleteClienteById(id);
        return "redirect:/clientesBuscar";
    }


    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid ClienteForm formBean, BindingResult result, ModelMap modelo, @RequestParam String action) throws Exception  {

        if(action.equals("Aceptar")) {
            /*
            Para poner errores custom asociados a
            FieldError error2 = new FieldError("formBean","dni","este es otro error.");
            result.addError(error2);
            ObjectError error = new ObjectError("globalError", "Aplicación en modo demo, no puede continuar");
            result.addError(error);
            */

            if(result.hasErrors()) {
                modelo.addAttribute("formBean",formBean);
                return "clienteEditar";
            } else {
                Cliente p=formBean.toPojo();
                p.setCiudad(serviceCiudad.getById(formBean.getIdCiudad()));
                try {
                    service.save(p);

                    return "redirect:/clientesBuscar";
                } catch (Excepcion e) {
                    // Si la excepcion refiere a un atributo del objeto, se muestra junto al componente (ej. dni)
                    if(e.getAtributo()==null) {
                        ObjectError error = new ObjectError("globalError", e.getMessage());
                        result.addError(error);
                    } else {
                        FieldError error1 = new FieldError("formBean",e.getAtributo(),e.getMessage());
                        result.addError(error1);
                    }
                    modelo.addAttribute("formBean",formBean);
                    return "clienteEditar";//Como existe un error me quedo en la misma pantalla
                }
            }
        }
        if(action.equals("Cancelar")) {
            modelo.clear();
            return "redirect:/clientesBuscar";
        }
        return "redirect:/";
    }
}