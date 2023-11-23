package tuti.desi.entidades;

import jakarta.persistence.*;

@Entity
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String modelo;

    @Column(nullable = false)
    private int cantFilas;

    @Column(nullable = false)
    private int asientosPorFila;

    // Otros campos necesarios para tu entidad Avion

    public Avion() {
    }

    public Avion(String modelo, int cantFilas, int asientosPorFila) {
        this.modelo = modelo;
        this.cantFilas = cantFilas;
        this.asientosPorFila = asientosPorFila;
        // Incluye otros campos si es necesario
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantFilas() {
        return cantFilas;
    }

    public void setCantFilas(int cantFilas) {
        this.cantFilas = cantFilas;
    }

    public int getAsientosPorFila() {
        return asientosPorFila;
    }

    public void setAsientosPorFila(int asientosPorFila) {
        this.asientosPorFila = asientosPorFila;
    }

}