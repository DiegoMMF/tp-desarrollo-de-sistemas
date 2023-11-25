package tuti.desi.presentacion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import tuti.desi.entidades.Vuelo.TipoVuelo;

public class VueloForm {
	private Long id_avion;
	private Long id_destino;
	private Long id_origen;
	private TipoVuelo tipoVuelo;
	private BigDecimal precioPasaje;
	private LocalDateTime fechaHoraPartida;
	private String estado;
	private String numeroVuelo;
	// Constructors
	
	public VueloForm() {}
	public VueloForm(Long id_avion, Long id_destino, Long id_origen, TipoVuelo tipoVuelo, BigDecimal precioPasaje, LocalDateTime fechaHoraPartida, String estado, String numeroVuelo) {
		this.id_avion = id_avion;
		this.id_destino = id_destino;
		this.id_origen = id_origen;
		this.tipoVuelo = tipoVuelo;
		this.precioPasaje = precioPasaje;
		this.fechaHoraPartida = fechaHoraPartida;
		this.estado = estado;
		this.numeroVuelo = numeroVuelo;

	}
	
	//Getters
	public Long getId_avion() { return this.id_avion; }
	public Long getId_destino() { return this.id_destino; }
	public Long getId_origen() { return this.id_origen; }
	public TipoVuelo getTipoVuelo() { return this.tipoVuelo; }
	public BigDecimal getPrecioPasaje() { return this.precioPasaje; }
	public LocalDateTime getFechaHoraPartida() { return this.fechaHoraPartida; }
	public String getEstado() { return this.estado; }
	public String getNumeroVuelo() { return this.numeroVuelo; }
	
	// Setters
	public void setId_avion(Long id_avion) { this.id_avion = id_avion; }
	public void setId_destino(Long id_destino) { this.id_destino = id_destino; }
	public void setId_origen(Long id_origen) { this.id_origen = id_origen; }
	public void setTipoVuelo(TipoVuelo tipoVuelo) { this.tipoVuelo = tipoVuelo; }
	public void setPrecioPasaje(BigDecimal precioPasaje) { this.precioPasaje = precioPasaje; }
	public void setFechaHoraPartida(LocalDateTime fechaHoraPartida) { this.fechaHoraPartida = fechaHoraPartida; }
	public void setEstado(String estado) { this.estado = estado; }
	public void setNumeroVuelo(String numeroVuelo) { this.numeroVuelo = numeroVuelo; }
}
