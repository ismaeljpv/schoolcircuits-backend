package com.school.circuits.resource;

import com.school.circuits.entities.Events;
import com.school.circuits.service.EventsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class EventsResource {

  private EventsService eventsService;
  public EventsResource(EventsService eventsService) {
    this.eventsService = eventsService;
  }

  @GetMapping( value ="/findAll")
  public List<Events> findAllEvents(){
    return eventsService.findAllEvents();
  }

  @GetMapping( value="/findEvents")
  public ArrayList findEvents(){
    return eventsService.findEvents();
  }

  @GetMapping( value="/findEvent/{idevent}")
  public Events findEvent(@PathVariable Integer idevent){
    return eventsService.findEvent(idevent);
  }

  @PostMapping( value ="/addEvents")
  public Events addEvent(@RequestBody Events event){
    return eventsService.addEvent(event);
  }

  @PutMapping( value ="/updateEvent/{idevent}")
  public Events updateEvent(@RequestBody Events event, @PathVariable Integer idevent){
    return eventsService.updateEvent(event, idevent);
  }

  @DeleteMapping( value="/deleteEvent/{idevent}")
  public void deleteEvent( @PathVariable int idevent ){
    eventsService.deleteEvent(idevent);
  }
}
