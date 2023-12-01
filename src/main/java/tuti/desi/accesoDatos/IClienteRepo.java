package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import tuti.desi.entidades.Cliente;

import java.util.List;

public interface IClienteRepo extends JpaRepository<Cliente, Long> {
    List<Cliente> findByDni(Long dni);
}
