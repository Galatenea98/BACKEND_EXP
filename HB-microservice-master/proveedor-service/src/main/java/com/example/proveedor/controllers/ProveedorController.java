package com.example.proveedor.controllers;

import com.example.proveedor.entities.Proveedor;
import com.example.proveedor.services.ProveedorService;
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
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Proveedor>> fetchAll() {
        try {
            List<Proveedor> clientes = proveedorService.findAll();
            return new ResponseEntity<List<Proveedor>>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proveedor> fetchById(@PathVariable("id") Long id) {
        try {
            Optional<Proveedor> optionalCliente = proveedorService.findById(id);
            if(optionalCliente.isPresent()) {
                return new ResponseEntity<Proveedor>(optionalCliente.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(path = "/documento/{numeroDocumento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proveedor> fetchByDocumento(@PathVariable("numeroDocumento") String numeroDocumento) {
        try {
            Optional<Proveedor> optionalCliente = proveedorService.findByNumeroDocumento(numeroDocumento);
            if(optionalCliente.isPresent()) {
                return ResponseEntity.ok(optionalCliente.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch( Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
