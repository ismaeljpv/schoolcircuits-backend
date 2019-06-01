package com.school.circuits.repository;

import com.school.circuits.entities.Schools;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SchoolsRepository extends JpaRepository<Schools, Integer> {
  List<Schools> findAllByIdcircuito(Integer idCircuito);

  Optional<Schools> findByRif(String rif);
}
