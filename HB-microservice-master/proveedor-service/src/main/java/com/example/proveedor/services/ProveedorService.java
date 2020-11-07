package com.example.proveedor.services;

import com.example.proveedor.entities.Proveedor;

import java.util.Optional;

public interface ProveedorService extends CrudService<Proveedor, Long> {
    Optional<Proveedor> findByNumeroDocumento(String numeroDocumento) throws Exception;
}
