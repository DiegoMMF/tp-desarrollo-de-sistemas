package tuti.desi.servicios;

import tuti.desi.entidades.Vuelo;

import java.util.List;

public interface VueloServiceI {
    List<Vuelo> obtenerTodosLosVuelos();
    Vuelo obtenerVueloPorId(Long id);
    Vuelo crearVuelo(Vuelo vuelo);
    Vuelo actualizarVuelo(Long id, Vuelo vuelo);
    void eliminarVuelo(Long id);
}