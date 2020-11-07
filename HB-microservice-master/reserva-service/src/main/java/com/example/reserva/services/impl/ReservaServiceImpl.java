package com.example.reserva.services.impl;

import com.example.reserva.entities.Reserva;
import com.example.reserva.repositories.ReservaRepository;
import com.example.reserva.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Transactional
    @Override
    public Reserva save(Reserva entity)   {
        return reservaRepository.save(entity);
    }

    @Transactional
    @Override
    public List<Reserva> findAll()   {
        return reservaRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Reserva> findById(Long aLong)   {
        return reservaRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Reserva update(Reserva entity)   {
        return reservaRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong)   {
        reservaRepository.deleteById(aLong);
    }
}
