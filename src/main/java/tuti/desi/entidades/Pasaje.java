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
public class Pasaje {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(nullable = false)
	    @Size(min = 0,max = 100, message = "Valor expresado en %, no debe ser mayor a 100")
	    @DecimalMin(value = "0.00", inclusive = false)
	    private int IVA;
	    @Column(nullable = false)
	    @DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.")
	    private int tasaAeroportuariaNacional;
	    @Column(nullable = false)
	    @DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.")
	    private int tasaAeroportuariaInternacional;
	    @Column(nullable = false)
	    @DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.")
	    private int cotizacionDolar;
		
	    //Constructor vacio
	    public Pasaje() {
		
		}

	    //Constructor con Atributos
		public Pasaje(Long id,
				@Size(min = 0, max = 100, message = "Valor expresado en %, no debe ser mayor a 100") @DecimalMin(value = "0.00", inclusive = false) int iVA,
				@DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.") int tasaAeroportuariaNacional,
				@DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.") int tasaAeroportuariaInternacional,
				@DecimalMin(value = "0.00", inclusive = false, message = "El valor debe ser positivo.") int cotizacionDolar) {
			super();
			this.id = id;
			IVA = iVA;
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

		public int getIVA() {
			return IVA;
		}

		public void setIVA(int iVA) {
			IVA = iVA;
		}

		public int getTasaAeroportuariaNacional() {
			return tasaAeroportuariaNacional;
		}

		public void setTasaAeroportuariaNacional(int tasaAeroportuariaNacional) {
			this.tasaAeroportuariaNacional = tasaAeroportuariaNacional;
		}

		public int getTasaAeroportuariaInternacional() {
			return tasaAeroportuariaInternacional;
		}

		public void setTasaAeroportuariaInternacional(int tasaAeroportuariaInternacional) {
			this.tasaAeroportuariaInternacional = tasaAeroportuariaInternacional;
		}

		public int getCotizacionDolar() {
			return cotizacionDolar;
		}

		public void setCotizacionDolar(int cotizacionDolar) {
			this.cotizacionDolar = cotizacionDolar;
		}
	    
	    
	    

}
