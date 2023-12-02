package tuti.desi.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;


import tuti.desi.entidades.Tasas;
import tuti.desi.servicios.TasasService;

@Controller
@RequestMapping("/tasasSet")
public class TasasController {
    @Autowired
    private TasasService tasasService;

    @GetMapping
    public String preparaForm(Model modelo) {
        TasasForm form = new TasasForm();
        modelo.addAttribute("formBean", form);
        return "tasas";
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<Tasas> editarTasas(@PathVariable Long id, @RequestBody TasasForm tasasForm) {
        tasasService.editarTasas(id, tasasForm);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/crear")
    public ResponseEntity<Tasas> crearTasas(@RequestBody TasasForm tasasForm) {
        Tasas tasaCreada = tasasService.crearTasas(tasasForm);
        return new ResponseEntity<>(tasaCreada, HttpStatus.CREATED);
    }

   
}

	



