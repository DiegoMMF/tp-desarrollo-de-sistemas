package tuti.desi.presentacion;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tuti.desi.entidades.Vuelo;
import tuti.desi.servicios.VueloService;

@Controller
@RequestMapping("/vuelosBuscar")
public class VuelosBuscarController {
    @Autowired
    private VueloService servicioVuelo;

    // @RequestMapping(method = RequestMethod.GET)
    // public String preparaForm(Model modelo) {
    // VueloForm form = new VueloForm();
    // modelo.addAttribute("formBean", form);
    // return "vuelosBuscar";
    // }

    // @GetMapping("/vuelosBuscar")
    @RequestMapping(method = RequestMethod.GET)
    public String vuelosBuscar(Model modelo) {
        modelo.addAttribute("formBean", new VueloForm());

        return "vuelosBuscar";
    }

    // @GetMapping("/vuelosListar")
    @RequestMapping(method = RequestMethod.GET)
    public String buscarPorFechaHora(@RequestParam LocalDateTime fechaHoraPartida, Model modelo, @ModelAttribute("vuelo") Vuelo vuelo) {
        modelo.addAttribute("listadoVuelos", servicioVuelo.obtenerTodosLosVuelos());

        return "vuelosBuscar";
    }

}