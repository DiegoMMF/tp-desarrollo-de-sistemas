package tuti.desi.presentacion;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import tuti.desi.entidades.Vuelo;
import tuti.desi.servicios.VueloService;

@Controller
@RequestMapping("/vuelosBuscar")
public class VuelosBuscarController {
    @Autowired
    private VueloService servicioVuelo;

    @GetMapping
    public String vuelosBuscar(ModelMap modelo) {
        modelo.addAttribute("formBean", new VueloForm());
        return "vuelosBuscar";
    }

    @ModelAttribute("allVuelos")
    public List<Vuelo> getAllVuelos() {
        return this.servicioVuelo.obtenerTodosLosVuelos();
    }

    @PostMapping
    public String buscarPorFechaHora(@ModelAttribute("formBean") @Valid VueloForm formBean, BindingResult result, ModelMap modelo, @RequestParam String action) {
        if (action.equals("Buscar")) {
            try {
                if (!result.hasErrors()) {
                	LocalDateTime fechaHoraPartida = formBean.getFechaHoraPartida();
                    List<Vuelo> listadoVuelos = servicioVuelo.obtenerVuelosPorFecha(fechaHoraPartida);
                    modelo.addAttribute("listadoVuelos", listadoVuelos);
                    modelo.addAttribute("formBean", formBean);
                }
            } catch (Exception e) {
                throw e;
            }
            return "vuelosBuscar";
        }

        if (action.equals("Cancelar")) {
            modelo.clear();
            return "redirect:/";
        }

        if (action.equals("Registrar")) {
            modelo.clear();
            return "redirect:/vueloABM";
        }

        return "redirect:/";
    }
}
