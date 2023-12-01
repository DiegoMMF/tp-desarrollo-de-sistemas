package tuti.desi.entidades;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import tuti.desi.entidades.Avion;

@Entity
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String numeroVuelo;

    @Column(nullable = false, unique = true)
    private Integer cantidadDeAsientos;

    @ManyToOne
    @JoinColumn(name = "origen_id", nullable = false)
    private Ciudad origen;

    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false)
    private Ciudad destino;

    @Column(nullable = false)
    private TipoVuelo tipoVuelo;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioPasaje;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechaHoraPartida;

    @ManyToOne
    @JoinColumn(name = "avion_id", nullable = false)
    private Avion avion;

    @Column(nullable = false)
    private String estado = "Normal";

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asiento> asientos;

    public enum TipoVuelo{
    	NACIONAL,
    	INTERNACIONAL
    }    
    
    public Vuelo() { }
    
    public Vuelo(String numeroVuelo, Ciudad origen, Ciudad destino, TipoVuelo tipoVuelo, BigDecimal precioPasaje, LocalDateTime fechaHoraPartida, Avion avion) {
	   this.numeroVuelo = numeroVuelo;
	   this.origen = origen;
	   this.destino = destino;
	   this.tipoVuelo = tipoVuelo;
	   this.precioPasaje = precioPasaje;
	   this.fechaHoraPartida = fechaHoraPartida;
	   this.avion = avion;
	}
    
    // Getters
    public Long getId() { return id; }
    public String getNumeroVuelo() { return numeroVuelo; }
    public Ciudad getOrigen() { return origen; }
    public Ciudad getDestino() { return destino; }
    public TipoVuelo getTipoVuelo() { return tipoVuelo; }
    public BigDecimal getPrecioPasaje() { return precioPasaje; }
    public LocalDateTime getFechaHoraPartida() { return fechaHoraPartida; }
    public Avion getAvion() { return avion; }
    public String getEstado() { return estado; }
    public List<Asiento> getAsientos() { return this.asientos; }
    public Integer getCantidadDeAsientos() { return this.cantidadDeAsientos; }
    public Integer getCantidadDeAsientosLibres(){
        Integer res=0;
        for(int i=0; i<this.cantidadDeAsientos; i++){
            if(this.asientos.get(i).getCliente()==null) res++;
        }
        return res;
    }
    
    //Setters
    public void setId(Long id) { this.id = id; }
    public void setNumeroVuelo(String numeroVuelo) { this.numeroVuelo = numeroVuelo; }
    public void setOrigen(Ciudad origen) { this.origen = origen; }
    public void setDestino(Ciudad destino) { this.destino = destino; }
    public void setTipoVuelo(TipoVuelo tipoVuelo) { this.tipoVuelo = tipoVuelo; }
    public void setPrecioPasaje(BigDecimal precioPasaje) { this.precioPasaje = precioPasaje; }
    public void setFechaHoraPartida(LocalDateTime fechaHoraPartida) { this.fechaHoraPartida = fechaHoraPartida; }
    public void setAvion(Avion avion) { this.avion = avion; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setCantidadDeAsientos(Integer cant) { this.cantidadDeAsientos = cant; }
    
    
    public void addAsiento(Asiento a) { this.asientos.add(a); }
}