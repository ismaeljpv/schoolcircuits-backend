package com.school.circuits.repository;

import com.school.circuits.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

  List<Department> findByIdplan(Integer idplan);
}
