package tuti.desi.entidades;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "numero_vuelo")
    private String numeroVuelo;

    @Column(name = "cantidad_de_asientos", nullable = false, unique = true)
    private Integer cantidadDeAsientos;

    @ManyToOne
    @JoinColumn(name = "origen_id", nullable = false)
    private Ciudad origen;

    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false)
    private Ciudad destino;

    @Column(name = "tipo_vuelo", nullable = false)
    private TipoVuelo tipoVuelo;

    @Column(nullable = false, precision = 10, scale = 2, name = "precio_pasaje")
    private BigDecimal precioPasaje;

    @Column(nullable = false, name = "fecha_hora_partida")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechaHoraPartida;

    @ManyToOne
    @JoinColumn(name = "avion_id", nullable = false)
    private Avion avion;

    @Column(nullable = false)
    private String estado = "Normal";

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asiento> asientos = new ArrayList<>();

    public Vuelo() {
    }

    public Vuelo(String numeroVuelo, Ciudad origen, Ciudad destino, TipoVuelo tipoVuelo, BigDecimal precioPasaje, LocalDateTime fechaHoraPartida, Avion avion) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.tipoVuelo = tipoVuelo;
        this.precioPasaje = precioPasaje;
        this.fechaHoraPartida = fechaHoraPartida;
        this.avion = avion;
        this.asientos = new ArrayList<>();
    }

    // Getters
    public Long getId() {
        return id;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public TipoVuelo getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(TipoVuelo tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public BigDecimal getPrecioPasaje() {
        return precioPasaje;
    }

    public void setPrecioPasaje(BigDecimal precioPasaje) {
        this.precioPasaje = precioPasaje;
    }

    public LocalDateTime getFechaHoraPartida() {
        return fechaHoraPartida;
    }

    public void setFechaHoraPartida(LocalDateTime fechaHoraPartida) {
        this.fechaHoraPartida = fechaHoraPartida;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Asiento> getAsientos() {
        return this.asientos;
    }

    public Integer getCantidadDeAsientos() {
        return this.cantidadDeAsientos;
    }

    public void setCantidadDeAsientos(Integer cant) {
        this.cantidadDeAsientos = cant;
    }

    /*public Integer getCantidadDeAsientosLibres() {
        Integer res = 0;
        if (this.asientos != null) {
            for (Asiento asiento : this.asientos) {
                if (asiento.getCliente() == null) {
                    res++;
                }
            }
        }
        return res;
    }*/

    public long getCantidadDeAsientosLibres() {
        return this.asientos.stream().filter(asiento -> asiento.getCliente() == null).count();
    }


    /*public void addAsiento(Asiento a) {
        this.asientos.add(a);
    }*/
    public void addAsiento(Asiento a) {
        if (this.asientos == null) {
            this.asientos = new ArrayList<>();
        }
        this.asientos.add(a);
    }


    public enum TipoVuelo {
        NACIONAL,
        INTERNACIONAL
    }
}