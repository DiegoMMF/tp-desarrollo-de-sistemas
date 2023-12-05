package tuti.desi.servicios;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.ITasasRepo;
import tuti.desi.entidades.Tasas;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.TasasForm;

@Service
public class TasasService implements ITasasService {
	@Autowired
	private ITasasRepo tasasRepo;

	@Override
	public void editarTasas(Long id, Tasas tasas) {
		Optional<Tasas> optionalTasas = tasasRepo.findById(id);
		Tasas tasasExistente = optionalTasas.orElseThrow(() -> new NoSuchElementException("Tasas no encontradas"));
		tasasExistente.setIva(tasas.getIva());
		tasasExistente.setTasaAeroportuariaInternacional(tasas.getTasaAeroportuariaInternacional());
		tasasExistente.setTasaAeroportuariaNacional(tasas.getTasaAeroportuariaNacional());
		tasasExistente.setCotizacionDolar(tasas.getCotizacionDolar());
		tasasRepo.save(tasasExistente);
	}

	@Override
	public Tasas crearTasas(TasasForm tasasForm) {
		Tasas nuevasTasas = new Tasas();
		nuevasTasas.setIva(tasasForm.getIva());
		nuevasTasas.setTasaAeroportuariaInternacional(tasasForm.getTasaAeroportuariaInternacional());
		nuevasTasas.setTasaAeroportuariaNacional(tasasForm.getTasaAeroportuariaNacional());
		nuevasTasas.setCotizacionDolar(tasasForm.getCotizacionDolar());

		return tasasRepo.save(nuevasTasas);
	}


	public Long obtenerTasas(Long id) {
		Optional<Tasas> optionalTasas = tasasRepo.findById(id);
		return optionalTasas.orElse(null).getId();

	}

	@Override
	public void save(Tasas t) throws Excepcion {
		if (t == null) {
			throw new Excepcion("No se puede guardar un objeto nulo");
		}
		tasasRepo.save(t);
	}

//	@Override
//	public Tasas obtenerTasasExistente() {
//		Tasas tasas
//		return tasasRepo.findFirstByOrderById();
//		}
@Override
public Tasas obtenerTasasExistente() {
	Tasas tasas = tasasRepo.findFirstByOrderById();
	if (tasas == null) {
		tasas = new Tasas();
		tasas.setId(1L);
		tasas.setIva(0.0);
		tasas.setTasaAeroportuariaInternacional(0.0);
		tasas.setTasaAeroportuariaNacional(0.0);
		tasas.setCotizacionDolar(0.0);
		tasasRepo.save(tasas);
	}
	return tasas;
}
}




