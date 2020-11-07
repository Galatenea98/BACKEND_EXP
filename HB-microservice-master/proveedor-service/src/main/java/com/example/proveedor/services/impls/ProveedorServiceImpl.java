package com.example.proveedor.services.impls;

import com.example.proveedor.entities.Proveedor;
import com.example.proveedor.repositories.ProveedorRepository;
import com.example.proveedor.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Transactional
    @Override
    public Proveedor save(Proveedor entity)   {
        return proveedorRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Proveedor> findAll()   {
        return proveedorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Proveedor> findById(Long aLong)   {
        return proveedorRepository.findById( aLong);
    }

    @Transactional
    @Override
    public Proveedor update(Proveedor entity)   {
        return proveedorRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong)   {
        proveedorRepository.deleteById(aLong);
    }

    @Override
    public Optional<Proveedor> findByNumeroDocumento(String numeroDocumento)   {
        return proveedorRepository.findByNumeroDocumento(numeroDocumento);
    }
}
