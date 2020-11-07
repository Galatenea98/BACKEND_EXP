package com.example.reserva.controllers;

import com.example.reserva.entities.PagoReserva;
import com.example.reserva.services.PagoReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagoReservas")
public class PagoReservaController {

    @Autowired
    private PagoReservaService pagoReservaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PagoReserva>> fetchAll() {
        try {
            List<PagoReserva> pagoReservas = pagoReservaService.findAll();
            return new ResponseEntity<List<PagoReserva>>(pagoReservas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagoReserva> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<PagoReserva> optionalPagoReserva = pagoReservaService.findById(id);
            if(optionalPagoReserva.isPresent()) {
                return new ResponseEntity<PagoReserva>(optionalPagoReserva.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}