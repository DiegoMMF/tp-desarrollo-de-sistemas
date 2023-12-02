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

    private String email;

    private String pasaporte;

    private String domicilio;

    /**
     * Propiedad utilizada por la capa de presentación para saber si es una entidad ya persistida (y la estoy
     * actualizando), o si es nueva. Ya que si el ID es ingresado por el usuario, no puede ser usado como criterio
     * para saber si fue persistida o no.
     */
    @Transient
    private Boolean editando=false;

    // Getters y setters
    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido=apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento=fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte=pasaporte;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando=editando;
    }

    // Otros métodos
    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", email='" + email + '\'' +
                ", pasaporte='" + pasaporte + '\'' +
                ", direccion='" + domicilio + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return dni.equals(cliente.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    public Cliente() {
    }

    public Cliente(Long dni, String nombre, String apellido, Date fechaNacimiento, String email, String pasaporte, String domicilio, Ciudad ciudad) {
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.fechaNacimiento=fechaNacimiento;
        this.email=email;
        this.pasaporte=pasaporte;
        this.domicilio = domicilio;
    }

    public Cliente(Long dni, String nombre, String apellido, Date fechaNacimiento, String email, String pasaporte, String domicilio, Ciudad ciudad, Boolean editando) {
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.fechaNacimiento=fechaNacimiento;
        this.email=email;
        this.pasaporte=pasaporte;
        this.domicilio = domicilio;
        this.editando=editando;
    }
}