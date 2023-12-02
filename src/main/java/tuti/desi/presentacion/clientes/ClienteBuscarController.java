package tuti.desi.presentacion.clientes;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Cliente;
import tuti.desi.servicios.ciudades.CiudadService;
import tuti.desi.servicios.clientes.ClienteService;

import java.util.List;

@Controller
@RequestMapping("/clienteBuscar")
public class ClienteBuscarController {
    @Autowired
    private ClienteService service;
    @Autowired
    private CiudadService serviceCiudad;

    @RequestMapping(method= RequestMethod.GET)
    public String preparaForm(Model modelo) {
        ClienteBuscarForm form =  new ClienteBuscarForm();
        form.setIdCiudadSeleccionada(1L); //Esto es por ejemplo, si quisiera setear un valor por defecto en el filtro de ciudad
//    	 form.setCiudades(serviceCiudad.getAll());    //  en lugar de esto hacemos @ModelAttribute("allCiudades")
        modelo.addAttribute("formBean",form);
        return "clienteBuscar";
    }


    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.serviceCiudad.getAll();
    }

    @RequestMapping( method=RequestMethod.POST)
    public String submit(
            @ModelAttribute("formBean")  @Valid ClienteBuscarForm formBean,
            BindingResult result,
            ModelMap modelo,
            @RequestParam String action
    ) {
        if (action.equals("Buscar")) {
            try {
                List<Cliente> clientes = service.filter(formBean);
                modelo.addAttribute("resultados", clientes);
            } catch (Exception e) {
                ObjectError error = new ObjectError("globalError", e.getMessage());
                result.addError(error);
            }
            modelo.addAttribute("formBean",formBean);
            return "clienteBuscar";
        }


        if(action.equals("Cancelar"))
        {
            modelo.clear();
            return "redirect:/";
        }

        if(action.equals("Registrar"))
        {
            modelo.clear();
            return "redirect:/clienteEditar";
        }

        return "redirect:/";


    }


}
