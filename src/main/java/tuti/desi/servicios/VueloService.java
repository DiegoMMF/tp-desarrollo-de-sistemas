package tuti.desi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Vuelo;
import tuti.desi.presentacion.VueloForm;
import tuti.desi.accesoDatos.IVueloRepo;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VueloService implements VueloServiceI {

    private final IVueloRepo vueloRepo;
    private final AvionService avionService;
    private final CiudadService ciudadService;

    @Autowired
    public VueloService(IVueloRepo vueloRepositorio, AvionService avionService, CiudadService ciudadService) {
        this.vueloRepo = vueloRepositorio;
        this.avionService = avionService;
        this.ciudadService = ciudadService;
    }

    @Override
    public List<Vuelo> obtenerVuelosPorFecha(LocalDateTime localDateTime) {
        return vueloRepo.findByFechaHoraPartida(localDateTime);
    }

    @Override
    public List<Vuelo> obtenerTodosLosVuelos() {
        return vueloRepo.findAll();
    }

    @Override
    public Vuelo obtenerVueloPorId(Long id) {
        Optional<Vuelo> optionalVuelo = vueloRepo.findById(id);
        return optionalVuelo.orElse(null);
    }

    @Override
    public Vuelo obtenerVueloPorNumeroVuelo(String numeroVuelo) {
        Optional<Vuelo> optionalVuelo = vueloRepo.findByNumeroVuelo(numeroVuelo);
        return optionalVuelo.orElse(null);
    }

    @Override
    public Vuelo crearVuelo(VueloForm vueloForm) {
        if (obtenerVueloPorNumeroVuelo(vueloForm.getNumeroVuelo()) != null) {
            throw new DataIntegrityViolationException(
                    "Ya existe un vuelo con el numero de vuelo: " + vueloForm.getNumeroVuelo());
        } else {
            List<Vuelo> vuelos = this.obtenerTodosLosVuelos();
            Boolean b = false;
            int i = 0;
            while (i < vuelos.size() && !b) {
                if (vuelos.get(i).getFechaHoraPartida().getDayOfYear() == vueloForm.getFechaHoraPartida().getDayOfYear()
                        &&
                        vuelos.get(i).getFechaHoraPartida().getYear() == vueloForm.getFechaHoraPartida().getYear()) {
                    b = true;
                    break;
                }
                i++;
            }
            if (b) {
                System.out.println("IllegalArgumentException");
                throw new IllegalArgumentException("No puede haber dos vuelos para el mismo dia, para un mismo avion!");
            } else {
                if (vueloForm.getId_avion() == null || vueloForm.getId_destino() == null
                        || vueloForm.getId_origen() == null) {
                    throw new IllegalArgumentException(
                            "Los campos id_avion, id_destino y id_origen no pueden ser nulos.");
                }
                Vuelo vuelo = new Vuelo();
                vuelo.setAvion(avionService.obtenerAvionPorId(vueloForm.getId_avion()));
                vuelo.setDestino(ciudadService.getById(vueloForm.getId_destino()));
                vuelo.setEstado(vueloForm.getEstado());
                vuelo.setFechaHoraPartida(vueloForm.getFechaHoraPartida());
                vuelo.setNumeroVuelo(vueloForm.getNumeroVuelo());
                vuelo.setOrigen(ciudadService.getById(vueloForm.getId_origen()));
                vuelo.setPrecioPasaje(vueloForm.getPrecioPasaje());
                vuelo.setTipoVuelo(vueloForm.getTipoVuelo());

                System.out.println("Guardando nuevo vuelo: " + vuelo);
                return vueloRepo.save(vuelo);
            }
        }
    }

    @Override
    public Vuelo actualizarVuelo(Long id, Vuelo vuelo) {
        if (vueloRepo.existsById(id)) {
            vuelo.setId(id);
            return vueloRepo.save(vuelo);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarVuelo(Long id) {
        vueloRepo.deleteById(id);
    }
}