package com.school.circuits.repository;

import com.school.circuits.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

  List<Plan> findByEstado(String estado);

  List<Plan> findByIdcircuito(Integer idcircuito);
}
