package tuti.desi.servicios.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IClienteRepo;
import tuti.desi.entidades.Cliente;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl {

    @Autowired
    IClienteRepo repoCliente;

    public List<Cliente> getClientes() {
        return repoCliente.findAll();
    }

    public Cliente getClienteByDni(Long dni) throws Exception {
        Optional<Cliente> cliente = repoCliente.findById(dni);

        if (cliente.isPresent()) {
            return cliente.get();
        } else {
            throw new Exception("No se encontró el cliente");
        }
    }
}
