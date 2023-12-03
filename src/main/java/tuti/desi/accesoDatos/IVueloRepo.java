package tuti.desi.accesoDatos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tuti.desi.entidades.Asiento;
import tuti.desi.entidades.Vuelo;

public interface IVueloRepo extends JpaRepository<Vuelo, Long> {
	Optional<Vuelo> findByNumeroVuelo(String numeroVuelo);
	List<Vuelo> findByFechaHoraPartida(LocalDateTime localDateTime);
}