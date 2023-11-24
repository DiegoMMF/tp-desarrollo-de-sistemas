package tuti.desi.servicios;

import tuti.desi.entidades.Vuelo;
import tuti.desi.presentacion.VueloForm;

import java.util.List;

public interface VueloServiceI {
    List<Vuelo> obtenerTodosLosVuelos();
    Vuelo obtenerVueloPorId(Long id);
    Vuelo crearVuelo(VueloForm vueloForm);
    Vuelo actualizarVuelo(Long id, Vuelo vuelo);
    void eliminarVuelo(Long id);
	Vuelo obtenerVueloPorNumeroVuelo(String numeroVuelo);
}