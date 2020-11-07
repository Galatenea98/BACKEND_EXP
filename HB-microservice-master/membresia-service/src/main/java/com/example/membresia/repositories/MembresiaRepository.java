package com.example.membresia.repositories;

import com.example.membresia.entities.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia,Long> {
}
