package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import tuti.desi.entidades.Vuelo;

public interface IVueloRepo extends JpaRepository<Vuelo, Long> {
    Vuelo findByNumeroVuelo(String numeroVuelo);
}