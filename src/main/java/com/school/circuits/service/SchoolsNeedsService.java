package com.school.circuits.service;

import com.school.circuits.entities.Schools;
import com.school.circuits.entities.SchoolsNeeds;
import com.school.circuits.exception.EntityNotFound;
import com.school.circuits.repository.CircuitsRepository;
import com.school.circuits.repository.SchoolsNeedsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolsNeedsService {


  @Autowired
  private SchoolsNeedsRepository snRepository;

  public SchoolsNeeds finsSchoolNeeds(Integer idSchool){
    Optional<SchoolsNeeds> sn = snRepository.findByIdplantel(idSchool);
    if(!sn.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " + idSchool);
    return sn.get();
  }

  public SchoolsNeeds addNeeds(SchoolsNeeds sn){
    return snRepository.save(sn);
  }

  public SchoolsNeeds updateNeeds(SchoolsNeeds sn, Integer idNeeds){
    Optional<SchoolsNeeds> sneeds = snRepository.findById(idNeeds);
    if(!sneeds.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " + idNeeds);
    return snRepository.save(sn);
  }

  public void deleteNeeds(Integer idNeeds){
    Optional<SchoolsNeeds> sn = snRepository.findById(idNeeds);
    if(!sn.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " + idNeeds);
    snRepository.deleteById(idNeeds);
  }

}
