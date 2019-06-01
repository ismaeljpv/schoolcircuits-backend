package com.school.circuits.resource;


import com.school.circuits.entities.Department;
import com.school.circuits.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/dpto")
public class DepartmentResource {

  private DepartmentService dptoService;
  public DepartmentResource(DepartmentService dptoService) {
    this.dptoService = dptoService;
  }

  @GetMapping(value="/getDeparments/{idplan}")
  public List<Department> findAllByPlan(@PathVariable Integer idplan){
    return dptoService.findDeparments(idplan);
  }

  @GetMapping(value="/findDeparment/{iddepar}")
  public Optional<Department> findDeparment(@PathVariable Integer iddepar){
    return dptoService.findDeparment(iddepar);
  }

  @PostMapping(value ="/addDeparment")
  public Department addDeparment(@RequestBody Department depar){

    return dptoService.addDeparment(depar);
  }

  @PutMapping( value ="/updateDeparment/{iddepar}")
  public Department updateDeparment(@RequestBody Department depar, @PathVariable Integer iddepar){
    return dptoService.updateDepar(depar, iddepar);
  }

  @DeleteMapping(value ="/deleteDeparment/{iddep}")
  public void deleteDeparment(@PathVariable Integer iddep){
      dptoService.deleteDeparment(iddep);
  }
}
