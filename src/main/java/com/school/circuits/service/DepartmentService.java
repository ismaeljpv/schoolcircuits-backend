package com.school.circuits.service;


import com.school.circuits.entities.Actions;
import com.school.circuits.entities.Department;
import com.school.circuits.entities.Plan;
import com.school.circuits.exception.EntityNotFound;
import com.school.circuits.repository.ActionsRepository;
import com.school.circuits.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private ActionsRepository actionsRepository;

  public List<Department> findDeparments(Integer idplan){
    return departmentRepository.findByIdplan(idplan);
  }

  public Department addDeparment(Department depar){
    return departmentRepository.save(depar);
  }

  public Optional<Department> findDeparment(Integer iddepar){
    Optional<Department> department = departmentRepository.findById(iddepar);
    if (!department.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " + iddepar);
    return department;
  }

  public Department updateDepar(Department depar, Integer iddepar){
    Optional<Department> department = departmentRepository.findById(iddepar);
    if (!department.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " + iddepar);
   return departmentRepository.save(depar);
  }

  public void deleteDeparment(Integer iddep){
    Optional<Department> department = departmentRepository.findById(iddep);
    if (!department.isPresent()) {
      throw new EntityNotFound("No hay resultado por el valor: " + iddep);
    }else{
      List<Actions> acciones = actionsRepository.findByIddptoPlan(iddep);
      for(int i=0; i< acciones.size(); i++){
        Actions accion = acciones.get(i);
        Integer idaccion = accion.getIdaccion();
        actionsRepository.deleteById(idaccion);
      }
    }
    departmentRepository.deleteById(iddep);
  }
}
