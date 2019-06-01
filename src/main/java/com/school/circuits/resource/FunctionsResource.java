package com.school.circuits.resource;


import com.school.circuits.entities.Functions;
import com.school.circuits.service.FunctionsService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/functions")
public class FunctionsResource {

  private FunctionsService functionsService;
  public FunctionsResource(FunctionsService functionsService) {
    this.functionsService = functionsService;
  }

  @GetMapping( value ="/getFunction/{idpersona}")
  public Optional<Functions> findFunction(@PathVariable Integer idpersona){
    return functionsService.findFunction(idpersona);
  }

  @PostMapping( value ="/addFunction")
  public Functions addPerson(@RequestBody Functions function){
    return functionsService.addFunction(function);
  }

  @DeleteMapping( value ="/deleteFunction/{idpersona}")
  public void deleteFunction(@PathVariable Integer idpersona){
        functionsService.deleteFunction(idpersona);
  }
}
