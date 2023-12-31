package tuti.desi.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tuti.desi.entidades.Vuelo;
import tuti.desi.servicios.VueloService;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloServicio) {
        this.vueloService = vueloServicio;
    }

    @GetMapping
    public ResponseEntity<List<Vuelo>> obtenerTodosLosVuelos() {
        List<Vuelo> vuelos = vueloService.obtenerTodosLosVuelos();
        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerVueloPorId(@PathVariable Long id) {
        Vuelo vuelo = vueloService.obtenerVueloPorId(id);
        return new ResponseEntity<>(vuelo, HttpStatus.OK);
    }

    @PostMapping
    public String crearVueloPost(@ModelAttribute("vueloForm") VueloForm vueloForm) {
        vueloService.crearVuelo(vueloForm);
        return "redirect:/vueloABM";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizarVuelo(@PathVariable Long id, @RequestBody Vuelo vuelo) {
        Vuelo vueloActualizado = vueloService.actualizarVuelo(id, vuelo);
        return new ResponseEntity<>(vueloActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVuelo(@PathVariable Long id) {
    	vueloService.eliminarVuelo(id);
        return new ResponseEntity<>("Vuelo eliminado correctamente", HttpStatus.OK);
    }
}