package tuti.desi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.entidades.Vuelo;
import tuti.desi.accesoDatos.IVueloRepo;

import java.util.List;
import java.util.Optional;

@Service
public class VueloService implements VueloServiceI {

    private final IVueloRepo vueloRepo;

    @Autowired
    public VueloService(IVueloRepo vueloRepositorio) {
        this.vueloRepo = vueloRepositorio;
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
    public Vuelo crearVuelo(Vuelo vuelo) {
        return vueloRepo.save(vuelo);
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