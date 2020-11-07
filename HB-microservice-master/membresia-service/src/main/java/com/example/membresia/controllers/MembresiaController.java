package com.example.membresia.controllers;

import com.example.membresia.entities.Membresia;
import com.example.membresia.entities.PagoMembresia;
import com.example.membresia.services.MembresiaService;
import com.example.membresia.services.PagoMembresiaService;
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
@RequestMapping("/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaService membresiaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Membresia>> fetchAll() {
        try {
            List<Membresia> membresias = membresiaService.findAll();
            return new ResponseEntity<List<Membresia>>(membresias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Membresia> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Membresia> optionalMembresia = membresiaService.findById(id);
            if(optionalMembresia.isPresent()) {
                return new ResponseEntity<Membresia>(optionalMembresia.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
