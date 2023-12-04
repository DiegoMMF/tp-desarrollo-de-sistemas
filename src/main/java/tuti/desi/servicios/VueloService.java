package tuti.desi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IVueloRepo;
import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Vuelo;
import tuti.desi.presentacion.VueloForm;
import tuti.desi.servicios.ciudades.CiudadService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public void crearVuelo(VueloForm vueloForm) {
        if (obtenerVueloPorNumeroVuelo(vueloForm.getNumeroVuelo()) != null) {
            throw new DataIntegrityViolationException("Ya existe un vuelo con el numero de vuelo: " + vueloForm.getNumeroVuelo());
        } else {
            List<Vuelo> vuelos = this.obtenerTodosLosVuelos();
            boolean b = false;
            int i = 0;
            while (i < vuelos.size()) {
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
                if (vueloForm.getId_avion() == null || vueloForm.getId_destino() == null || vueloForm.getId_origen() == null) {
                    throw new IllegalArgumentException("Los campos id_avion, id_destino y id_origen no pueden ser nulos.");
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

                for (int x = 0; x < vuelo.getAvion().getCantFilas(); x++) {
                    for (int j = 0; j < vuelo.getAvion().getAsientosPorFila(); j++) {
                        Asiento asiento = new Asiento();
                        asiento.setVuelo(vuelo);
                        asiento.setFila(x);
                        asiento.setColumna(j);
                        asiento.setCliente(null);
                        vuelo.addAsiento(asiento);
                    }
                }
                vuelo.setCantidadDeAsientos(vuelo.getAvion().getCantFilas() * vuelo.getAvion().getAsientosPorFila());

                System.out.println("Guardando nuevo vuelo: " + vuelo);
                vueloRepo.save(vuelo);
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

    public List<Asiento> obtenerAsientosDisponibles(Long vueloId) {
        Vuelo vuelo = vueloRepo.findById(vueloId).orElse(null);

        if (vuelo != null) {
            return vuelo.getAsientos().stream()
                    .filter(asiento -> asiento.getCliente() == null)
                    .collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public List<Asiento> obtenerAsientosReservadosPorVuelo(Long vueloId) {
        Vuelo vuelo = vueloRepo.findById(vueloId).orElse(null);

        if (vuelo != null) {
            return vuelo.getAsientos().stream()
                    .filter(asiento -> asiento.getCliente() != null)
                    .collect(Collectors.toList());
        }

        return null;
    }
}