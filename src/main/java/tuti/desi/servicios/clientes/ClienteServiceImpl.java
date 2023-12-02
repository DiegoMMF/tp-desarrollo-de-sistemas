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
    IClienteRepo repo;

    @Override
    public List<Cliente> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Cliente> filter(ClienteBuscarForm filter) throws Excepcion {
        if (filter.getNombre() == null && filter.getDni() == null && filter.getIdCiudadSeleccionada() == null)
            throw new Excepcion("Es necesario al menos un filtro");
        else
            return repo.findByNombreOrIdCiudad(filter.getNombre(),filter.getDni(),filter.getIdCiudadSeleccionada());



    }

    @Override
    public void save(Cliente cliente) throws Excepcion {

        GregorianCalendar gc =new GregorianCalendar();
        gc.set(Calendar.YEAR, 2000);
        gc.set(Calendar.DATE, 1);
        gc.set(Calendar.MONTH, 1);

        if(cliente.getDni()<35000000 && cliente.getFechaNacimiento().after(gc.getTime()))
            throw new Excepcion("El dni no corresponde a la fecha de nacimiento indicada");  //error global mostrado arriba
        else if(!cliente.getEditando() && repo.existsById(cliente.getDni()))
            throw new Excepcion("El dni ya se encuentra asociado a otra cliente", "dni");  //error asociado al campo dni
        else
            repo.save(cliente);

    }

    @Override
    public Cliente getClienteById(Long idCliente) throws Exception {

        Optional<Cliente> p = repo.findById(idCliente);

        if(p!=null) {
            return p.get();
        } else {
            throw new Exception("No existe el cliente con el id="+idCliente);
        }
    }

    @Override
    public void deleteClienteById(Long id) {
        repo.deleteById(id);

    }


}
