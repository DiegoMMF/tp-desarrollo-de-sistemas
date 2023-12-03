package tuti.desi.servicios.asientos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IAsientoRepo;
import tuti.desi.entidades.Asiento;

@Service
public class AsientoServiceImpl implements AsientoService {

    @Autowired
    IAsientoRepo asientoRepository;

    @Override
    public Asiento obtenerAsientoPorId(Long id) {
        return asientoRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean update(Asiento asientoReservado) {
        Asiento asiento = asientoRepository.findById(asientoReservado.getId()).orElse(null);
        if (asiento != null) {
            asientoRepository.save(asiento);
            return true;
        }
        return false;
    }
}
