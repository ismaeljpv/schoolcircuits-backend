package com.school.circuits.repository;

import com.school.circuits.entities.Actions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionsRepository extends JpaRepository<Actions, Integer> {

  List<Actions> findByIddptoPlan(Integer iddp);
}
