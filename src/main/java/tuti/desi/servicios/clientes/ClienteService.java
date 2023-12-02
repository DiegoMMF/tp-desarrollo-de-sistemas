package tuti.desi.servicios.clientes;

import tuti.desi.entidades.Cliente;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.clientes.ClienteBuscarForm;

import java.util.List;

public interface ClienteService {

    List<Cliente> getAll();

    List<Cliente> filter(ClienteBuscarForm filter) throws Excepcion;

    /**
     * Si la cliente existe la actualizará, si no la creará en BD
     * @param cliente cliente a guardar
     */
    void save(Cliente cliente) throws Excepcion;

    /**
     * Permite obtener un cliente determinado
     * @param idCliente identificador del cliente buscado
     * @return cliente o null dependiendo de si fue encontrado o no
     * @throws Exception ante un error
     */
    Cliente getClienteById(Long idCliente) throws Exception;

    void deleteClienteById(Long id);
}