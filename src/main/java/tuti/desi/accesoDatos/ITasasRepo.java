package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuti.desi.entidades.Tasas;

import java.util.Optional;


@Repository
public interface ITasasRepo extends JpaRepository<Tasas, Long> {
    Optional<Tasas> findById(Long id);

    Tasas findFirstByOrderById();
}



