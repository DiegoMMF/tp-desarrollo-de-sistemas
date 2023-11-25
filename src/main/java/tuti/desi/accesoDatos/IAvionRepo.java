package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import tuti.desi.entidades.Avion;

@Repository
public interface IAvionRepo extends JpaRepository<Avion, Long> {
    List<Avion> findByCompania(String compania);
}
