package tuti.desi.entidades;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Validated
public class Tasas {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idTasas;
	    @Column(nullable = false)
	    @Size(min = 0,max = 100, message = "Valor expresado en %, no debe ser mayor a 100")
	    @DecimalMin(value = "0.00", inclusive = false)
	    private Double IVA;
	    @Column(nullable = false)
	    @DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.")
	    private Double tasaAeroportuariaNacional;
	    @Column(nullable = false)
	    @DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.")
	    private Double tasaAeroportuariaInternacional;
	    @Column(nullable = false)
	    @DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.")
	    private Double cotizacionDolar;
		
	    //Constructor vacio
	    public Tasas() {
		
		}

	    //Constructor con Atributos
		public Tasas(Long id,
				@Size(min = 0, max = 100, message = "Valor expresado en %, no debe ser mayor a 100") @DecimalMin(value = "0.00", inclusive = false) Double iVA,
				@DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.") Double tasaAeroportuariaNacional,
				@DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.") Double tasaAeroportuariaInternacional,
				@DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.") Double cotizacionDolar) {
			super();
			this.idTasas = id;
			this.IVA = iVA;
			this.tasaAeroportuariaNacional = tasaAeroportuariaNacional;
			this.tasaAeroportuariaInternacional = tasaAeroportuariaInternacional;
			this.cotizacionDolar = cotizacionDolar;
		}

		// Getters y setters
		
		public Long getId() {
			return idTasas;
		}

		public void setId(Long id) {
			this.idTasas = id;
		}

		public Double getIVA() {
			return IVA;
		}

		public void setIVA(Double iVA) {
			IVA = iVA;
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
