package tuti.desi.accesoDatos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Tasas;
import tuti.desi.entidades.Vuelo;


@Repository
public interface ITasasRepo extends JpaRepository<Tasas, Long> {
	 Optional<Tasas> findByidTasas(Long idTasas);
}

