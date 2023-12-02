package tuti.desi.servicios.clientes;

import tuti.desi.entidades.Cliente;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.clientes.ClienteBuscarForm;

import java.util.List;

public interface ClienteService {

    List<Cliente> getAll();

    List<Cliente> filter(ClienteBuscarForm clienteBuscarForm) throws Excepcion;

    void save(Cliente cliente) throws Excepcion;

    Cliente getClienteByDni(Long dni) throws Exception;

    void deleteClienteByDni(Long dni);
}