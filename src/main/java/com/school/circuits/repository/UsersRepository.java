package com.school.circuits.repository;

import com.school.circuits.entities.Users;
import com.school.circuits.util.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByNombreusuario(String username);

    Optional<Users> findByIdpersona(Integer idpersona);

}
