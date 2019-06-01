package com.school.circuits.resource;

import com.school.circuits.entities.Actions;
import com.school.circuits.service.ActionsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/actions")
public class ActionsResource {

  private ActionsService actService;
  public ActionsResource(ActionsService actService) {
    this.actService = actService;
  }

  @GetMapping(value ="/findActions/{idDptoPlan}")
  public List<Actions> findActions(@PathVariable Integer idDptoPlan){
    return actService.findActions(idDptoPlan);
  }

  @GetMapping(value ="/getAction/{idact}")
  public Optional<Actions> getAction(@PathVariable Integer idact){
    return actService.getAction(idact);
  }

  @PostMapping(value="/addAction")
  public Actions addAction(@RequestBody Actions action){
    return actService.addAction(action);
  }

  @PutMapping(value ="/updateAction/{idact}")
  public Actions updateAction(@RequestBody Actions action, @PathVariable Integer idact){
      return actService.updateAction(action, idact);
  }

  @DeleteMapping(value="/deleteAction/{idaction}")
  public void deleteAction(@PathVariable Integer idaction){
    actService.deleteAction(idaction);
  }

  @GetMapping(value ="/getStadistics")
  public HashMap<String, Object> stadistics(){
    return actService.estadisticas();
  }
}
