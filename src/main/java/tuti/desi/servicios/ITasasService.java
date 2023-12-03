package tuti.desi.servicios;
import tuti.desi.entidades.Tasas;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.TasasForm;

public interface ITasasService {
   void editarTasas(Long idTasas, TasasForm tasasForm);
   public Tasas crearTasas(TasasForm tasasForm);
   public Long obtenerTasas(Long idTasas);

    void save(Tasas t) throws Excepcion;

    Tasas obtenerTasasExistente();
    }


