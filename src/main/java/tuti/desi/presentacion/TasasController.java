package tuti.desi.presentacion;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tuti.desi.entidades.Tasas;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.TasasService;

@Controller
@RequestMapping("/tasasVer")
public class TasasController {

    @Autowired
    private TasasService tasasService;

    @GetMapping
    public String preparaForm(Model modelo) {
        Tasas entity = tasasService.obtenerTasasExistente();
        if (entity == null) {
            entity = new Tasas();
        }
        TasasForm tasas = new TasasForm(entity);
        modelo.addAttribute("tasas", tasas);
        return "tasasVer";
    }

    @PostMapping
    public String submit(
            @ModelAttribute("tasas") @Valid Tasas tasas,
            BindingResult result,
            ModelMap modelo,
            @RequestParam String action
    ) throws Excepcion {
        if (action.equals("Editar")) {
            if (result.hasErrors()) {
                return "tasasVer";
            }
            System.out.println("----------------------------------------");
            System.out.println("tasas.getId() = " + tasas.getId());
            System.out.println("tasas.getIva() = " + tasas.getIva());
            System.out.println("tasas.getTasaAeroportuariaInternacional() = " + tasas.getTasaAeroportuariaInternacional());
            System.out.println("tasas.getTasaAeroportuariaNacional() = " + tasas.getTasaAeroportuariaNacional());
            System.out.println("tasas.getCotizacionDolar() = " + tasas.getCotizacionDolar());
            System.out.println("----------------------------------------");
            /*tasasService.save(tasas);
            return "redirect:/tasasEditar";*/
        }
        if (action.equals("Cancelar")) {
            return "redirect:/index";
        }
        return "redirect:/";
    }
}


	



