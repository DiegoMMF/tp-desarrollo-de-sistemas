package tuti.desi.presentacion.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tuti.desi.servicios.clientes.ClienteService;

import java.util.Optional;

@Controller
@RequestMapping("/clientesBuscar")
public class ClienteEditController {

    @Autowired
    private ClienteService servicioCliente;

    @GetMapping
    public String preparaForm(Model modelo) {
        ClienteSearchForm form = new ClienteSearchForm();
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

    /* @RequestMapping( path = { "", "/{id}" }, method= RequestMethod.GET )
    public String preparaForm(
            Model modelo,
            @PathVariable("id") Optional<Long> dni
    ) throws Exception {
        if (dni.isPresent()) {
            Cliente entity = service.getClienteById(dni.get());
            ClienteEditForm form = new ClienteEditForm(entity);
            modelo.addAttribute("formBean", form);
        } else {
            modelo.addAttribute("formBean",new ClienteEditForm());
        }
        return "personasEditar";
    }*/
}
