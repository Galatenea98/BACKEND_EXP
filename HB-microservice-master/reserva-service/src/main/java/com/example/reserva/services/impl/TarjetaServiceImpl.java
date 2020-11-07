package com.example.reserva.services.impl;

import com.example.reserva.entities.Tarjeta;
import com.example.reserva.repositories.TarjetaRepository;
import com.example.reserva.services.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class TarjetaServiceImpl implements TarjetaService {
    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Transactional
    @Override
    public Tarjeta save(Tarjeta entity)   {
        return tarjetaRepository.save(entity);
    }

    @Transactional
    @Override
    public List<Tarjeta> findAll()   {
        return tarjetaRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Tarjeta> findById(Long aLong)   {
        return tarjetaRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Tarjeta update(Tarjeta entity)   {
        return tarjetaRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong)   {
        tarjetaRepository.deleteById(aLong);
    }
}
