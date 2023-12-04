package tuti.desi.servicios;

import tuti.desi.entidades.Tasas;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.TasasForm;

public interface ITasasService {
    void editarTasas(Long id, Tasas tasas);

    public Tasas crearTasas(TasasForm tasasForm);

    public Long obtenerTasas(Long id);

    void save(Tasas t) throws Excepcion;

    Tasas obtenerTasasExistente();
}


