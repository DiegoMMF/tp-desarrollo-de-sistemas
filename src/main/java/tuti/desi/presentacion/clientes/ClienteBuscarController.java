package tuti.desi.presentacion.clientes;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import tuti.desi.entidades.Cliente;
import tuti.desi.servicios.clientes.ClienteService;

import java.util.List;

@Controller
@RequestMapping("/ingresar-dni")
public class ClienteBuscarController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public String preparaForm(Model modelo) {
        ClienteBuscarForm form =  new ClienteBuscarForm();
        // Esto es por ejemplo, si quisiera poner un valor por defecto en el filtro de ciudad
        // form.setIdCiudadSeleccionada(1L);
        // form.setCiudades(serviceCiudad.getAll());
        // en lugar de la línea anterior, hacemos @ModelAttribute("allCiudades")
        modelo.addAttribute("formBean", form);
        return "reservas/ingresarDNI";
    }

    @PostMapping
    public String submit(
            @ModelAttribute("formBean") @Valid ClienteBuscarForm formBean,
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
            modelo.addAttribute("formBean", formBean);
            return "reservas/ingresarDNI";
        }
        if (action.equals("Cancelar")) {
            modelo.clear();
            return "redirect:/";
        }
        if(action.equals("Registrar")) {
            modelo.clear();
            return "redirect:/clienteEditar";
        }
        return "redirect:/";
    }
}
