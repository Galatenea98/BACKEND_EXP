package pe.edu.upc.cliente.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.cliente.entities.Cliente;
import pe.edu.upc.cliente.repositories.ClienteRepository;
import pe.edu.upc.cliente.services.ClienteService;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    @Override
    public Cliente save(Cliente entity)   {
        return clienteRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll()   {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Cliente> findById(Long aLong)   {
        return clienteRepository.findById( aLong);
    }

    @Transactional
    @Override
    public Cliente update(Cliente entity)   {
        return clienteRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong)   {
        clienteRepository.deleteById(aLong);
    }

    @Override
    public Optional<Cliente> findByNumeroDocumento(String numeroDocumento)   {
        return clienteRepository.findByNumeroDocumento(numeroDocumento);
    }
}
