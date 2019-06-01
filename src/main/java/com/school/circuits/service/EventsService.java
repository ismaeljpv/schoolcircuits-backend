package com.school.circuits.service;


import com.school.circuits.entities.Circuits;
import com.school.circuits.entities.Events;
import com.school.circuits.exception.EntityNotFound;
import com.school.circuits.repository.CircuitsRepository;
import com.school.circuits.repository.EventsRepository;
import com.school.circuits.repository.FunctionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class EventsService {

  @Autowired
  private EventsRepository eventsRepository;

  @Autowired
  private CircuitsRepository circuitsRepository;

  public List<Events> findAllEvents(){
    return eventsRepository.findAll();
  }

  public ArrayList findEvents(){
    List<Events> eventos = eventsRepository.findAll();
    ArrayList results = new ArrayList();


    for(int i=0; i < eventos.size(); i++){
      Events evento = eventos.get(i);
      int idCircuito = evento.getIdcircuito();
      Circuits circuito = circuitsRepository.findById(idCircuito).get();
      HashMap<String, Object> childMap = new HashMap<>();
      childMap.put("Event", evento);
      childMap.put("Circuit", circuito);

      results.add(i, childMap);
    }
    return results;
  }

  public Events findEvent(Integer idevent){
    Optional<Events> evento = eventsRepository.findById(idevent);
    if(!evento.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " + idevent);
    Events event = evento.get();
    return event;
  }

  public Events addEvent(Events event){
    return eventsRepository.save(event);
  }

  public Events updateEvent(Events event, Integer idevent){
    Optional<Events> evento = eventsRepository.findById(idevent);
    if(!evento.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " + idevent);
    return eventsRepository.save(event);
  }

  public void deleteEvent(Integer idEvent){
    Optional<Events> evento = eventsRepository.findById(idEvent);
    if(!evento.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " + idEvent);

    eventsRepository.deleteById(idEvent);
  }

}
