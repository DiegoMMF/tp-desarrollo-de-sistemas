package tuti.desi.servicios.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IClienteRepo;
import tuti.desi.entidades.Cliente;
import tuti.desi.presentacion.clientes.ClienteSearchForm;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    IClienteRepo repoCliente;

    @Override
    public List<Cliente> findAll() {
        return repoCliente.findAll();
    }

    public List<Cliente> filter(ClienteSearchForm filter) throws Exception {
        if ( filter.getDni() == null )
            throw new Exception("Es necesario ingresar un dni");
        else
            return repoCliente.findByDni(filter.getDni());
    }

    @Override
    public List<Cliente> findByDni(Long dni) {
        return null;
    }

    @Override
    public void save(Cliente cliente) throws Exception {

    }

    public Cliente getClienteByDni(Long dni) throws Exception {
        Optional<Cliente> cliente = repoCliente.findById(dni);
        if (cliente.isPresent()) {
            return cliente.get();
        } else {
            throw new Exception("No se encontró el cliente");
        }
    }

    @Override
    public void deleteClienteByDni(Long dni) {
        repoCliente.deleteById(dni);
    }
}
