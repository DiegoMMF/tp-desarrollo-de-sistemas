package tuti.desi.presentacion;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import tuti.desi.entidades.Tasas;

public class TasasForm {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTasas;
    @Column(nullable = false)
    @Size(min = 0,max = 100, message = "Valor expresado en %, no debe ser mayor a 100")
    @DecimalMin(value = "0.00", inclusive = false)
    private Double iva;
    @Column(nullable = false)
    @DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.")
    private Double tasaAeroportuariaNacional;
    @Column(nullable = false)
    @DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.")
    private Double tasaAeroportuariaInternacional;
    @Column(nullable = false)
    @DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.")
    private Double cotizacionDolar;

    public TasasForm(Tasas t) {
        super();
        this.idTasas= t.getId();
        this.iva = t.getIVA();
        this.tasaAeroportuariaNacional = t.getTasaAeroportuariaNacional();
        this.tasaAeroportuariaInternacional = t.getTasaAeroportuariaInternacional();
        this.cotizacionDolar = t.getCotizacionDolar();
    }

    public TasasForm() {
    }
//  getters y setters

    public Long getIdTasas() {
        return idTasas;
    }
    public void setIdTasas(Long idTasas) {
        this.idTasas = idTasas;
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

    public void setTasaAeroportuariaNacional(Double tasaAeportuariaNacional) {
        this.tasaAeroportuariaNacional = tasaAeroportuariaNacional;
    }

    public Double getTasaAeroportuariaInternacional() {
        return tasaAeroportuariaInternacional;
    }

    public void setTasaAeroInternacional(Double tasaAeroportuariaInternacional) {
        this.tasaAeroportuariaInternacional = tasaAeroportuariaInternacional;
    }

    public Double getCotizacionDolar() {
        return cotizacionDolar;
    }

    public void setCotizacionDolar(Double cotizacionDolar) {
        this.cotizacionDolar = cotizacionDolar;
    }
    public Tasas toPojo()
    {
        Tasas t = new Tasas();
        t.setId(this.idTasas);
        t.setIVA(this.iva);
        t.setTasaAeroportuariaInternacional(this.tasaAeroportuariaInternacional);
        t.setTasaAeroportuariaNacional(this.tasaAeroportuariaNacional);
        t.setCotizacionDolar(this.cotizacionDolar);
        return t;
    }
}

