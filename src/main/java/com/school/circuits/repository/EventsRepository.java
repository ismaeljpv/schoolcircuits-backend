package com.school.circuits.repository;

import com.school.circuits.entities.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Events, Integer> {

}
