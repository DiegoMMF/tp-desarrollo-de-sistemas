package tuti.desi.servicios.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IClienteRepo;
import tuti.desi.entidades.Cliente;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.clientes.ClienteBuscarForm;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    IClienteRepo clienteRepository;

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> filter(ClienteBuscarForm clienteBuscarForm) throws Excepcion {
        if (clienteBuscarForm.getDni() == null)
            throw new Excepcion("Es necesario ingresar un DNI para realizar la búsqueda");
        return clienteRepository.findByDni(clienteBuscarForm.getDni());
    }

    @Override
    public void save(Cliente cliente) throws Excepcion {
        if (clienteRepository.existsById(cliente.getDni()))
            throw new Excepcion("El dni ya se encuentra asociado a otro cliente", "dni");
        else
            clienteRepository.save(cliente);
    }

    @Override
    public Cliente getClienteByDni(Long idCliente) throws Exception {
        Optional<Cliente> p = clienteRepository.findById(idCliente);
        if (p.isPresent()) {
            return p.get();
        } else {
            throw new Exception("No existe el cliente con el id=" + idCliente);
        }
    }

    @Override
    public void deleteClienteByDni(Long id) {
        clienteRepository.deleteById(id);
    }
}