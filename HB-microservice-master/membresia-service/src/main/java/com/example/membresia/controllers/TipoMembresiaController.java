package com.example.membresia.controllers;

import com.example.membresia.entities.Membresia;
import com.example.membresia.entities.TipoMembresia;
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
@RequestMapping("/tipoMembresias")
public class TipoMembresiaController {

    @Autowired
    private TipoMembresiaService tipoMembresiaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoMembresia>> fetchAll() {
        try {
            List<TipoMembresia> tipoMembresias = tipoMembresiaService.findAll();
            return new ResponseEntity<List<TipoMembresia>>(tipoMembresias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoMembresia> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<TipoMembresia> optionalTipoMembresia = tipoMembresiaService.findById(id);
            if(optionalTipoMembresia.isPresent()) {
                return new ResponseEntity<TipoMembresia>(optionalTipoMembresia.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
