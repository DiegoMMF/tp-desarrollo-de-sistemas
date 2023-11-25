package tuti.desi.servicios;

import java.util.List;
import tuti.desi.entidades.Avion;

public interface IAvionService {
    List<Avion> obtenerTodosLosAviones();
    Avion obtenerAvionPorId(Long id);
    List<Avion> obtenerAvionesPorCompania(String compania);
    Avion agregarAvion(Avion avion);
    
}
