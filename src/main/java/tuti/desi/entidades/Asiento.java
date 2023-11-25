package tuti.desi.entidades;

import jakarta.persistence.*;

@Entity
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int fila;
    @Column(nullable = false)
    private int columna;
    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "vuelo_id", nullable = false)
    private Vuelo vuelo;

    public Asiento() {}

    public Asiento(int fila, int columna, boolean ocupado, Vuelo vuelo) {
        this.fila = fila;
        this.columna = columna;
        this.cliente = null;
        this.vuelo = vuelo;
    }

    // Getters
    public Long getId() { return id; }
    public Vuelo getVuelo() { return vuelo; }
    public int getFila() { return this.fila; }
    public int getColumna() { return this.columna; }
    public Cliente getCliente() { return this.cliente; }
    
    //Setters
    public void setId(Long id) { this.id = id; }
    public void setVuelo(Vuelo vuelo) { this.vuelo = vuelo; }
    public void setFila(int fila) { this.fila = fila; }
    public void setColumna(int columna) { this.columna = columna; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}
