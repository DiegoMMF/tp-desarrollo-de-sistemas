package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tuti.desi.entidades.Cliente;

import java.util.List;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNombreOrDni(String nombre, Long dni);

    @Query("SELECT p FROM Cliente p WHERE p.nombre like ?1 or p.dni=?2 or p.ciudad.id=?3")
    List<Cliente> findByNombreOrIdCiudad(String nombre, Long dni, Long idProvinciaSeleccionada);
}
