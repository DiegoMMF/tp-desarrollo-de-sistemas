package tuti.desi.servicios;
import java.util.Optional;
import tuti.desi.entidades.Tasas;
import tuti.desi.presentacion.TasasForm;
import tuti.desi.entidades.Tasas;

public interface ITasasService {
   void editarTasas(Long idTasas, TasasForm tasasForm);
   public Tasas crearTasas(TasasForm tasasForm);
   public Tasas obtenerTasas(Long idTasas); 
    
}
