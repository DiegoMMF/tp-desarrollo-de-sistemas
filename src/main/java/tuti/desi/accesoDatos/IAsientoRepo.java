package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuti.desi.entidades.Asiento;

@Repository
public interface IAsientoRepo extends JpaRepository<Asiento, Long> {
}
