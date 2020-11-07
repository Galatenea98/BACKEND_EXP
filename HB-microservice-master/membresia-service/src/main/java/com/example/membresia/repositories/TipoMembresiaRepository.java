package com.example.membresia.repositories;

import com.example.membresia.entities.TipoMembresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMembresiaRepository extends JpaRepository<TipoMembresia,Long> {

}
