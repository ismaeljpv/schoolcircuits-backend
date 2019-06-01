package com.school.circuits.repository;

import com.school.circuits.entities.Circuits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CircuitsRepository extends JpaRepository<Circuits, Integer> {

  Optional<Circuits> findByCodigoCircuital(String codigo);
}
