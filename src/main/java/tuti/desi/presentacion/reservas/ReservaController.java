package tuti.desi.presentacion.reservas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import tuti.desi.entidades.Vuelo;
import tuti.desi.servicios.VueloService;
import tuti.desi.servicios.clientes.ClienteService;

import java.util.List;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ClienteService serviceCliente;

    @Autowired
    private VueloService serviceVuelo;

    @GetMapping("")
    public String preparaForm(Model modelo) {
        ReservaForm form = new ReservaForm();
        modelo.addAttribute("formBean", form);
        return "reserva";
    }

    @ModelAttribute("allVuelos")
    public List<Vuelo> getAllVuelos() {
        return this.serviceVuelo.obtenerTodosLosVuelos();
    }

    @PostMapping("")
    public String submit(
            @ModelAttribute("formBean") ReservaForm formBean,
            BindingResult result,
            ModelMap modelo,
            @RequestParam String action
    ) {
        if (action.equals("Buscar")) {
            try {
                List<Vuelo> vuelos = serviceVuelo.obtenerTodosLosVuelos();
                modelo.addAttribute("resultados", vuelos);
            } catch (Exception e) {
                result.addError(new ObjectError("globalError", e.getMessage()));
            }
            modelo.addAttribute("formBean", formBean);
            return "reserva";
        }
        if (action.equals("Reservar")) {
            try {
                /*serviceCliente.reservarVuelo(formBean.getDni(), formBean.getIdVuelo());*/
                modelo.addAttribute("resultados", serviceVuelo.obtenerTodosLosVuelos());
            } catch (Exception e) {
                result.addError(new ObjectError("globalError", e.getMessage()));
            }
            modelo.addAttribute("formBean", formBean);
            return "reserva";
        }
        return action;
    }
}
