package com.example.membresia.controllers;

import com.example.membresia.entities.PagoMembresia;
import com.example.membresia.entities.TipoMembresia;
import com.example.membresia.services.PagoMembresiaService;
import com.example.membresia.services.TipoMembresiaService;
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
@RequestMapping("/pagoMembresias")
public class PagoMembresiaController{

    @Autowired
    private PagoMembresiaService pagoMembresiaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PagoMembresia>> fetchAll() {
        try {
            List<PagoMembresia> pagoMembresias = pagoMembresiaService.findAll();
            return new ResponseEntity<List<PagoMembresia>>(pagoMembresias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagoMembresia> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<PagoMembresia> optionalPagoMembresia = pagoMembresiaService.findById(id);
            if(optionalPagoMembresia.isPresent()) {
                return new ResponseEntity<PagoMembresia>(optionalPagoMembresia.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}