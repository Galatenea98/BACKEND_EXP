package com.example.membresia.controllers;

import com.example.membresia.entities.PagoMembresia;
import com.example.membresia.entities.Tarjeta;
import com.example.membresia.services.PagoMembresiaService;
import com.example.membresia.services.TarjetaService;
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
@RequestMapping("/tarjetas")
public class TarjetaController{

    @Autowired
    private TarjetaService tarjetaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tarjeta>> fetchAll() {
        try {
            List<Tarjeta> tarjetas = tarjetaService.findAll();
            return new ResponseEntity<List<Tarjeta>>(tarjetas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tarjeta> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Tarjeta> optionalTarjeta  = tarjetaService.findById(id);
            if(optionalTarjeta.isPresent()) {
                return new ResponseEntity<Tarjeta>(optionalTarjeta.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}