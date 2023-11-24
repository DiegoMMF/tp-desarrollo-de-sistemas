package tuti.desi.accesoDatos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tuti.desi.entidades.Vuelo;

public interface IVueloRepo extends JpaRepository<Vuelo, Long> {
	 Optional<Vuelo> findByNumeroVuelo(String numeroVuelo);
}