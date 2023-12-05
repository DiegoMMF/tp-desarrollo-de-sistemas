package tuti.desi.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class Tasas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tasas")
    private Long id;

    private Double iva;

    @Column(name = "tasa_aeroportuaria_nacional")
    private Double tasaAeroportuariaNacional;

    @Column(name = "tasa_aeroportuaria_internacional")
    private Double tasaAeroportuariaInternacional;

    @Column(name = "cotizacion_dolar")
    private Double cotizacionDolar;

    //Constructor vacio
    public Tasas() {

    }

    //Constructor con Atributos
    public Tasas(
            Long id,
            @Size(min = 0, max = 100, message = "Valor expresado en %, no debe ser mayor a 100") @DecimalMin(value = "0.00", inclusive = false) Double iva,
            @DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.") Double tasaAeroportuariaNacional,
            @DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.") Double tasaAeroportuariaInternacional,
            @DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.") Double cotizacionDolar
    ) {
        super();
        this.id = id;
        this.iva = iva;
        this.tasaAeroportuariaNacional = tasaAeroportuariaNacional;
        this.tasaAeroportuariaInternacional = tasaAeroportuariaInternacional;
        this.cotizacionDolar = cotizacionDolar;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTasaAeroportuariaNacional() {
        return tasaAeroportuariaNacional;
    }

    public void setTasaAeroportuariaNacional(Double tasaAeroportuariaNacional) {
        this.tasaAeroportuariaNacional = tasaAeroportuariaNacional;
    }

    public Double getTasaAeroportuariaInternacional() {
        return tasaAeroportuariaInternacional;
    }

    public void setTasaAeroportuariaInternacional(Double tasaAeroportuariaInternacional) {
        this.tasaAeroportuariaInternacional = tasaAeroportuariaInternacional;
    }

    public Double getCotizacionDolar() {
        return cotizacionDolar;
    }

    public void setCotizacionDolar(Double cotizacionDolar) {
        this.cotizacionDolar = cotizacionDolar;
    }


}
