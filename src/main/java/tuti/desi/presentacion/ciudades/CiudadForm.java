package tuti.desi.presentacion.ciudades;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.validation.constraints.Size;
import tuti.desi.entidades.Ciudad;

/**
 * Objeto necesario para insertar o eliminar un ciente.
 * Nótese que en lugar de referenciar al objeto Ciudad, reemplaza ese atributo por el idCiudad,
 * lo cual resulta más sencillo de representar en JSON.
 */
public class CiudadForm {

	private Long id;

	@Size(min=2, max=30)
	private String nombre;
	private Long idProvincia;

	// Getters y setters
	public CiudadForm() {
		super();
	}
	public CiudadForm(Ciudad c) {
		super();
		this.id=c.getId();
		this.nombre=c.getNombre();
		this.idProvincia=c.getProvincia().getId();

	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}
	public Ciudad toPojo()
	{
		Ciudad c = new Ciudad();
		c.setId(this.id);
		c.setNombre(this.getNombre());
		return c;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
