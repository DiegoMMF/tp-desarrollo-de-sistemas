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
	public void editarTasas(Long idTasas, TasasForm tasasForm) {
		Optional<Tasas> tasasOptional = tasasRepo.findById(idTasas);

		if (tasasOptional.isPresent()) {
			Tasas tasasExistente = tasasOptional.get();

			if (tasasForm.getIva() != null) {
				tasasExistente.setIVA(tasasForm.getIva());
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
			
			throw new NoSuchElementException("No eciste Tasas con ID: " + idTasas);
		}
	}

	@Override
	public Tasas crearTasas(TasasForm tasasForm) {
		Tasas nuevasTasas = new Tasas();
		nuevasTasas.setIVA(tasasForm.getIva());
		nuevasTasas.setTasaAeroportuariaInternacional(tasasForm.getTasaAeroportuariaInternacional());
		nuevasTasas.setTasaAeroportuariaNacional(tasasForm.getTasaAeroportuariaNacional());
		nuevasTasas.setCotizacionDolar(tasasForm.getCotizacionDolar());

	
		return tasasRepo.save(nuevasTasas);
	}

	public Long obtenerTasas(Long idTasas) {
		Optional<Tasas> optionalTasas = tasasRepo.findById(idTasas);
		return optionalTasas.orElse(null).getId();

	}
	@Override
	public void save(Tasas t) throws Excepcion {
		if(t.getId()==1 )
			tasasRepo.save(t);

	}

	@Override
	public Tasas obtenerTasasExistente() {
		return tasasRepo.findFirstByOrderById();
		}
	}



