package tuti.desi.servicios;

import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Vuelo;
import tuti.desi.presentacion.VueloForm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface VueloServiceI {
    List<Vuelo> obtenerTodosLosVuelos();
    Vuelo obtenerVueloPorId(Long id);
    void crearVuelo(VueloForm vueloForm);
    Vuelo actualizarVuelo(Long id, Vuelo vuelo);
    void eliminarVuelo(Long id);
	Vuelo obtenerVueloPorNumeroVuelo(String numeroVuelo);
	List<Vuelo> obtenerVuelosPorFecha(LocalDateTime localDateTime);
    List<Asiento> obtenerAsientosDisponibles(Long idVuelo);
    List<Asiento> obtenerAsientosReservadosPorVuelo(Long idVuelo);
}