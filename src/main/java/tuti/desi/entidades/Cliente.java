package tuti.desi.entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Cliente {
    @Id
    private Long dni;

    private String nombre;

    private String apellido;

    private Date fechaNacimiento;

    /**
     * Propiedad utilizada por la capa de presentación para saber si es una entidad ya persistida (y la estoy
     * actualizando), o si es nueva. Ya que si el ID es ingresado por el usuario, no puede ser usado como criterio
     * para saber si fue persistida o no.
     */
    @Transient
    private Boolean editando=false;

    @ManyToOne
    private Ciudad ciudad;

    // Getters y setters
    public Long getDni() {
        return dni;
    }
    public void setDni(Long dni) {
        this.dni = dni;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Ciudad getCiudad() {
        return ciudad;
    }
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Boolean getEditando() {
        return editando;
    }
    public void setEditando(Boolean editando) {
        this.editando = editando;
    }
}