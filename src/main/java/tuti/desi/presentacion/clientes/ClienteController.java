package tuti.desi.presentacion.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tuti.desi.servicios.clientes.ClienteService;

import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService servicioCliente;

    @GetMapping
    public String preparaForm(Model modelo) {
        modelo.addAttribute("clientes", servicioCliente.findAll());
        return "clientes";
    }

    @GetMapping("/{dni}")
    public String preparaForm(
            Model modelo,
            @PathVariable("id") Optional<Long> dni
    ) throws Exception {
        if (dni.isPresent()) {
            modelo.addAttribute("cliente", servicioCliente.getClienteByDni(dni.get()));
        } else {
            modelo.addAttribute("cliente", null);
        }
        return "clientes";
    }

    @RequestMapping( path = { "", "/{id}" }, method= RequestMethod.GET )
    public String preparaForm(
            Model modelo,
            @PathVariable("id") Optional<Long> dni
    ) throws Exception {
        if (dni.isPresent()) {
            Persona entity = service.getPersonaById(dni.get());
            PersonaForm form = new PersonaForm(entity);
            modelo.addAttribute("formBean", form);
        } else {
            modelo.addAttribute("formBean",new PersonaForm());
        }
        return "personasEditar";
    }
}
