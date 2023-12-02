package tuti.desi.presentacion.reservas;

public class ReservaForm {
    private Long dni;

    public Long getDni() {
        if (dni != null && dni > 0)
            return dni;
        else
            return null;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }
}
