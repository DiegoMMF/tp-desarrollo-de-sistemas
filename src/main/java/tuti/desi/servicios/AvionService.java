package tuti.desi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IAvionRepo;
import tuti.desi.entidades.Avion;
import java.util.List;

@Service
public class AvionService implements IAvionService {

    private final IAvionRepo avionRepo;

    @Autowired
    public AvionService(IAvionRepo avionRepo) {
        this.avionRepo = avionRepo;
    }

    public List<Avion> obtenerTodosLosAviones() {
        return avionRepo.findAll();
    }

    public Avion obtenerAvionPorId(Long id) {
        return avionRepo.findById(id).orElse(null);
    }

    public List<Avion> obtenerAvionesPorCompania(String compania) {
        return avionRepo.findByCompania(compania);
    }

    public Avion agregarAvion(Avion avion) {
        return avionRepo.save(avion);
    }
}
