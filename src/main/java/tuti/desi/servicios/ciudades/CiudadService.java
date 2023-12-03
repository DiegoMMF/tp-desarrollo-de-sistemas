package tuti.desi.servicios.ciudades;


import java.util.List;

import tuti.desi.entidades.Ciudad;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.ciudades.CiudadesBuscarForm;

public interface CiudadService {
	List<Ciudad> getAll();
	Ciudad getById(Long idCiudad) ;
	List<Ciudad> filter(CiudadesBuscarForm filter) throws Excepcion;
	void deleteByid(Long id);
	void save(Ciudad c) throws Excepcion;
}