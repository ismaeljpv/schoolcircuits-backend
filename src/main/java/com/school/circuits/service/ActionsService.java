package com.school.circuits.service;

import com.school.circuits.entities.Actions;
import com.school.circuits.entities.Events;
import com.school.circuits.exception.EntityNotFound;
import com.school.circuits.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ActionsService {

  @Autowired
  private ActionsRepository actionsRepository;

  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private CircuitsRepository circuitsRepository;

  @Autowired
  private SchoolsRepository schoolsRepository;

  @Autowired
  private EventsRepository eventsRepository;

  public List<Actions> findActions(Integer idDptoPlan){
    return actionsRepository.findByIddptoPlan(idDptoPlan);
  }

  public Optional<Actions> getAction(Integer idAction){
    return actionsRepository.findById(idAction);
  }

  public Actions addAction(Actions action){
    return actionsRepository.save(action);
  }

  public Actions updateAction(Actions act, Integer idaction){
    Optional<Actions> accion = actionsRepository.findById(idaction);
    if (!accion.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " +  idaction);
    return actionsRepository.save(act);
  }

  public void deleteAction(Integer idaction){
    Optional<Actions> accion = actionsRepository.findById(idaction);
    if (!accion.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " +  idaction);
    actionsRepository.deleteById(idaction);
  }

  public HashMap<String, Object> estadisticas(){

    Integer cantSchools = Math.toIntExact(schoolsRepository.count());
    Integer cantUsers = Math.toIntExact(usersRepository.count());
    Integer cantCircuits = Math.toIntExact(circuitsRepository.count());

    List<Events> eventos = eventsRepository.findAll();


    HashMap<String, Object> map = new HashMap<>();
    map.put("Schools", cantSchools);
    map.put("Users", cantUsers);
    map.put("Circuits", cantCircuits);
    map.put("Events", eventos);

    return map;
  }

}
