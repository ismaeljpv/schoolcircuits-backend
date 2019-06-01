package com.school.circuits.repository;

import com.school.circuits.entities.Matric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatricRepository extends JpaRepository<Matric, Integer> {
  List<Matric> findByIdplantel(Integer iddp);
}
