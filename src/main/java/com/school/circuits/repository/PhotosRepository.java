package com.school.circuits.repository;

import com.school.circuits.entities.Photos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotosRepository extends JpaRepository<Photos, Integer> {

  List<Photos> findByIdplan(Integer idplan);
}
