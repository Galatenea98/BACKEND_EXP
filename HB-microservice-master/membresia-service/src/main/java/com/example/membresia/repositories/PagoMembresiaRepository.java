package com.example.membresia.repositories;

import com.example.membresia.entities.PagoMembresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoMembresiaRepository extends JpaRepository<PagoMembresia,Long> {
}
