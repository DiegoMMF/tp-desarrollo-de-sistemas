package tuti.desi.presentacion;

import org.antlr.v4.runtime.misc.NotNull;

public class TasasForm {
	@NotNull
    private Double iva;
	@NotNull
    private Double tasaAeroportuariaNacional;
	@NotNull
    private Double tasaAeroportuariaInternacional;
	@NotNull
    private Double cotizacionDolar;

    //  getters y setters 

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
}

