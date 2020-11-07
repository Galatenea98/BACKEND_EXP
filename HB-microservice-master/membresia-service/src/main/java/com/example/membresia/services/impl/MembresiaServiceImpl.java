package com.example.membresia.services.impl;

import com.example.membresia.entities.Membresia;
import com.example.membresia.repositories.MembresiaRepository;
import com.example.membresia.services.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MembresiaServiceImpl implements MembresiaService {
    @Autowired
    private MembresiaRepository membresiaRepository;

    @Transactional
    @Override
    public Membresia save(Membresia entity)   {
        return membresiaRepository.save(entity);
    }

    @Transactional
    @Override
    public List<Membresia> findAll()   {
        return membresiaRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Membresia> findById(Long aLong)   {
        return membresiaRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Membresia update(Membresia entity)   {
        return membresiaRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong)   {
        membresiaRepository.deleteById(aLong);
    }
}
