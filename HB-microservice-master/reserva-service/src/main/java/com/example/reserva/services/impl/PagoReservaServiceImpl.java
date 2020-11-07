package com.example.reserva.services.impl;


import com.example.reserva.entities.PagoReserva;
import com.example.reserva.repositories.PagoReservaRepository;
import com.example.reserva.services.PagoReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PagoReservaServiceImpl implements PagoReservaService {

    @Autowired
    private PagoReservaRepository pagoReservaRepository;

    @Transactional
    @Override
    public PagoReserva save(PagoReserva entity)  {
        return pagoReservaRepository.save(entity);
    }

    @Transactional
    @Override
    public List<PagoReserva> findAll()   {
        return pagoReservaRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<PagoReserva> findById(Long aLong)   {
        return pagoReservaRepository.findById(aLong);
    }

    @Transactional
    @Override
    public PagoReserva update(PagoReserva entity)   {
        return pagoReservaRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong)   {
        pagoReservaRepository.deleteById(aLong);
    }
}
