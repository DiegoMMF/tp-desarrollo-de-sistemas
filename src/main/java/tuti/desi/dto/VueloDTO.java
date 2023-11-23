package tuti.desi.dto;

import java.time.LocalDateTime;

public class VueloDTO {
    private String numeroVuelo;
    private Long origenId;
    private Long destinoId;
    private String tipoVuelo;
    private Double precioPasaje;
    private LocalDateTime fechaHoraPartida;
    private Long avionId;
    
    public VueloDTO() {
        // Constructor vacío necesario para algunas operaciones
    }

    public VueloDTO(String numeroVuelo, Long origenId, Long destinoId, String tipoVuelo,
                    Double precioPasaje, LocalDateTime fechaHoraPartida, Long avionId) {
        this.numeroVuelo = numeroVuelo;
        this.origenId = origenId;
        this.destinoId = destinoId;
        this.tipoVuelo = tipoVuelo;
        this.precioPasaje = precioPasaje;
        this.fechaHoraPartida = fechaHoraPartida;
        this.avionId = avionId;
    }

    // Getters
    public String getNumeroVuelo() { return numeroVuelo; }
    public Long getOrigenId() { return origenId; }
    public Long getDestinoId() { return destinoId; }
    public String getTipoVuelo() { return tipoVuelo; }
    public Double getPrecioPasaje() { return precioPasaje; }
    public LocalDateTime getFechaHoraPartida() { return fechaHoraPartida; }
    public Long getAvionId() { return avionId; }
    
    //Setters
    public void setNumeroVuelo(String numeroVuelo) { this.numeroVuelo = numeroVuelo; }
    public void setOrigenId(Long origenId) { this.origenId = origenId; }
    public void setDestinoId(Long destinoId) { this.destinoId = destinoId; }
    public void setTipoVuelo(String tipoVuelo) { this.tipoVuelo = tipoVuelo; }
    public void setPrecioPasaje(Double precioPasaje) { this.precioPasaje = precioPasaje; }
    public void setFechaHoraPartida(LocalDateTime fechaHoraPartida) { this.fechaHoraPartida = fechaHoraPartida; }
    public void setAvionId(Long avionId) { this.avionId = avionId; }
}