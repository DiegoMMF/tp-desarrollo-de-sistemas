package tuti.desi.servicios.asientos;

import tuti.desi.entidades.Asiento;

import java.util.List;

public interface AsientoService {
    Asiento obtenerAsientoPorId(Long id);
    Boolean update(Asiento asientoReservado);
}
