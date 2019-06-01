package com.school.circuits.repository;

import com.school.circuits.entities.Person;
import com.school.circuits.util.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByIdcircuito(Integer idCircuito);

    Optional<Person> findByIdplantel(Integer idPlantel);

    List<Person> findAllByIdplantel(Integer idPlantel);

    Optional<Person> findByCedula(String cedula);

    @Query(nativeQuery = true, value = SQL.SUPERVISORES)
    List<Person> findAllSupervisores();

    @Query(nativeQuery = true, value = SQL.SUPERVISORES2)
    List<Person> findAllSupervisores2();

}
