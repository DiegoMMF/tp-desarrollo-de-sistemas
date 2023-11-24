package tuti.desi.entidades;

import jakarta.persistence.*;

@Entity
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String compania;
    @Column(nullable = false)
    private int cantFilas;
    @Column(nullable = false)
    private int asientosPorFila;

    public Avion() {}
    public Avion(String modelo, int cantFilas, int asientosPorFila) {
        this.modelo = modelo;
        this.cantFilas = cantFilas;
        this.asientosPorFila = asientosPorFila;
    }

    // Getters
    public Long getId() { return id; }
    public String getModelo() { return modelo; }
    public int getCantFilas() { return cantFilas; }
    public int getAsientosPorFila() { return asientosPorFila; }

    // Setters
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setCantFilas(int cantFilas) { this.cantFilas = cantFilas; }
    public void setAsientosPorFila(int asientosPorFila) { this.asientosPorFila = asientosPorFila; }

}