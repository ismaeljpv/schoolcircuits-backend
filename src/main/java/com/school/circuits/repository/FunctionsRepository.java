package com.school.circuits.repository;


import com.school.circuits.entities.Functions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FunctionsRepository extends JpaRepository<Functions, Integer> {

  Optional<Functions> findByIdpersona(Integer idpersona);

  Optional<Functions> findByEnlace(String enlace);

}
