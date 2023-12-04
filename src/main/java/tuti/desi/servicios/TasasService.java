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
	public void editarTasas(Long id, TasasForm tasasForm) {
		Optional<Tasas> tasasOptional = tasasRepo.findById(id);

		if (tasasOptional.isPresent()) {
			Tasas tasasExistente = tasasOptional.get();

			if (tasasForm.getIva() != null) {
				tasasExistente.setIva(tasasForm.getIva());
			}

			if (tasasForm.getTasaAeroportuariaInternacional() != null) {
				tasasExistente.setTasaAeroportuariaInternacional(tasasForm.getTasaAeroportuariaInternacional());
			}

			if (tasasForm.getTasaAeroportuariaNacional() != null) {
				tasasExistente.setTasaAeroportuariaNacional(tasasForm.getTasaAeroportuariaNacional());
			}

			if (tasasForm.getCotizacionDolar() != null) {
				tasasExistente.setCotizacionDolar(tasasForm.getCotizacionDolar());
			}

			tasasRepo.save(tasasExistente);
		} else {
			
			throw new NoSuchElementException("No eciste Tasas con ID: " + id);
		}
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

	@Override
	public Tasas obtenerTasasExistente() {
		return tasasRepo.findFirstByOrderById();
		}
	}



