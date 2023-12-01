package tuti.desi.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Vuelo;
import tuti.desi.servicios.AvionService;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.VueloService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/vueloABM")
public class VueloABMController {

	@Autowired
    private VueloService vueloService;
	@Autowired
    private AvionService avionService;
	@Autowired
    private CiudadService ciudadService;

    @GetMapping
    public String mostrarFormulario(Model model) {
        List<Avion> listaAviones = avionService.obtenerTodosLosAviones();
        List<Ciudad> listaCiudades = ciudadService.getAll();

        model.addAttribute("vueloForm", new VueloForm());
        model.addAttribute("listaAviones", listaAviones);
        model.addAttribute("listaCiudades", listaCiudades);

        // Obtener la lista de vuelos (puedes ajustar esto según cómo obtengas la lista)
        List<Vuelo> listaVuelos = vueloService.obtenerTodosLosVuelos();
        model.addAttribute("vuelos", listaVuelos);

        return "vueloABM";
    }

    @PostMapping()
    public String crearVuelo(Model model, @ModelAttribute("vueloForm") @Valid VueloForm vueloForm, BindingResult result) {
        try {
        	vueloService.crearVuelo(vueloForm);
        	return "vueloCreado";
        }catch(Exception err){
        	model.addAttribute("errorMsg", err.getMessage());
        	return "error";
        }
    }

}

