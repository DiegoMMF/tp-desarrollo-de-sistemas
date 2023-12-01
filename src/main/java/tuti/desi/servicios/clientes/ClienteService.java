package tuti.desi.servicios.clientes;

import tuti.desi.entidades.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    List<Cliente> findByDni(Long dni);

    /**
     * Si el cliente existe lo editará, si no la creará en BD
     * @param cliente cliente a guardar
     * @throws Exception ante un error
     */
    void save(Cliente cliente) throws Exception;

    /**
     * Permite obtener un cliente determinado
     * @param dni identificador del cliente buscado
     * @return cliente encontrado o null si no encontró el cliente
     * @throws Exception ante un error
     */
    Cliente getClienteByDni(Long dni) throws Exception;

    void deleteClienteByDni(Long dni);


}
