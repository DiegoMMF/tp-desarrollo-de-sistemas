package tuti.desi.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tuti.desi.entidades.Avion;
import tuti.desi.servicios.IAvionService;
import java.util.List;

@RestController
@RequestMapping("/api/aviones")
public class AvionController {

    private final IAvionService avionService;

    @Autowired
    public AvionController(IAvionService avionService) {
        this.avionService = avionService;
    }

    @GetMapping
    public List<Avion> obtenerTodosLosAviones() {
        return avionService.obtenerTodosLosAviones();
    }

    @GetMapping("/{id}")
    public Avion obtenerAvionPorId(@PathVariable Long id) {
        return avionService.obtenerAvionPorId(id);
    }

    @GetMapping("/por-compania/{compania}")
    public List<Avion> obtenerAvionesPorCompania(@PathVariable String compania) {
        return avionService.obtenerAvionesPorCompania(compania);
    }

    @PostMapping
    public ResponseEntity<Avion> agregarAvion(@RequestBody Avion avion) {
        Avion nuevoAvion = avionService.agregarAvion(avion);
        return new ResponseEntity<>(nuevoAvion, HttpStatus.CREATED);
    }
}
