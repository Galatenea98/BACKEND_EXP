package com.example.membresia.services.impl;

import com.example.membresia.entities.TipoMembresia;
import com.example.membresia.repositories.TipoMembresiaRepository;
import com.example.membresia.services.TipoMembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoMembresiaServiceImpl implements TipoMembresiaService {

    @Autowired
    private TipoMembresiaRepository tipoMembresiaRepository;

    @Transactional
    @Override
    public TipoMembresia save(TipoMembresia entity)   {
        return tipoMembresiaRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TipoMembresia> findAll()   {
        return tipoMembresiaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoMembresia> findById(Long aLong)   {
        return tipoMembresiaRepository.findById(aLong);
    }

    @Transactional
    @Override
    public TipoMembresia update(TipoMembresia entity)   {
        return tipoMembresiaRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong)   {
        tipoMembresiaRepository.deleteById(aLong);
    }
}
