package com.school.circuits.repository;

import com.school.circuits.entities.SchoolsNeeds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolsNeedsRepository extends JpaRepository<SchoolsNeeds, Integer> {
  Optional<SchoolsNeeds> findByIdplantel(Integer idSchool);
}
