package tuti.desi.presentacion.clientes;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Cliente;
import tuti.desi.entidades.Vuelo;

import java.util.Date;

public class ClienteForm {

    @Min(value = 7000000, message = "el dni debe ser mayor a 7000000")
    private Long dni;

    @Size(min = 2, max = 30, message = "el valor debe estar entre 2 y 30")
    private String apellido;

    @Size(min = 2, max = 30)
    private String nombre;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;

    private String email;

    private String pasaporte;

    private String domicilio;

    public ClienteForm() {
        super();
    }

    public ClienteForm(Cliente p) {
        super();
        this.nombre = p.getNombre();
        this.apellido = p.getApellido();
        this.dni = p.getDni();
        this.fechaNacimiento = p.getFechaNacimiento();
        this.email = p.getEmail();
        this.pasaporte = p.getPasaporte();
        this.domicilio = p.getDomicilio();
    }

    public Long getDni() {
        return dni;
    }
    public void setDni(Long dni) {
        this.dni = dni;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasaporte() {
        return pasaporte;
    }
    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Cliente toPojo() {
        Cliente p = new Cliente();
        p.setDni(this.getDni());
        p.setApellido(this.getApellido());
        p.setNombre(this.getNombre());
        p.setDni(this.getDni());
        p.setFechaNacimiento(this.getFechaNacimiento());
        p.setEmail(this.getEmail());
        p.setPasaporte(this.getPasaporte());
        p.setDomicilio(this.getDomicilio());
        return p;
    }

    @Override
    public String toString() {
        return "ClienteForm{" +
                "dni=" + dni +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", email='" + email + '\'' +
                ", pasaporte='" + pasaporte + '\'' +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }
}
