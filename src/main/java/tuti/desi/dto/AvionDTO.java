package tuti.desi.dto;

public class AvionDTO {
    private Long id;
    private String modelo;
    private String compania;
    private int capacidad;

    // Constructors
    public AvionDTO() {}
    public AvionDTO(Long id, String modelo, String compania, int capacidad) {
        this.id = id;
        this.modelo = modelo;
        this.compania = compania;
        this.capacidad = capacidad;
    }

    // Getters
    public Long getId() { return id; }
    public String getModelo() { return modelo; }
    public String getCompania() { return compania; }
    public int getCapacidad() { return capacidad; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setCompania(String compania) { this.compania = compania; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
}
