package tuti.desi.presentacion;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Tasas;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.ciudades.CiudadForm;
import tuti.desi.servicios.TasasService;



@Controller
@RequestMapping("/tasasVer")
public class TasasController {

    @Autowired
    private TasasService tasasService;

    @RequestMapping(method= RequestMethod.GET)
    public String preparaForm(Model modelo) {
        Tasas entity = tasasService.obtenerTasasExistente();
        TasasForm tasas  = new TasasForm(entity);
        modelo.addAttribute("tasas", tasas);

        return "tasasVer";
    }



    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("tasas") @Valid Tasas tasas, BindingResult result,
                         ModelMap modelo, @RequestParam String action) {
        if (action.equals("Editar Tasas")) {
            if (result.hasErrors()) {
                return "editarTasas";
            } else {
                try {
                    // Guarda las tasas editadas en la base de datos
                    tasasService.save(tasas);
                    return "redirect:/";
                } catch (Excepcion e) {
                    // Maneja excepciones según tus necesidades
                    modelo.addAttribute("error", e.getMessage());
                    return "editarTasas";
                }
            }
        }

        if (action.equals("Cancelar")) {
            return "redirect:/index";
        }

        return "redirect:/";
    }


}


	



