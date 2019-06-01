package com.school.circuits.service;

import com.school.circuits.entities.Actions;
import com.school.circuits.entities.Circuits;
import com.school.circuits.entities.Department;
import com.school.circuits.entities.Plan;
import com.school.circuits.exception.EntityNotFound;
import com.school.circuits.repository.ActionsRepository;
import com.school.circuits.repository.CircuitsRepository;
import com.school.circuits.repository.DepartmentRepository;
import com.school.circuits.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class PlanService {


  @Autowired
  private PlanRepository planRepository;

  @Autowired
  private CircuitsRepository circuitsRepository;

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private ActionsRepository actionsRepository;

  public List<Plan> findByEstado(){
    String estado = "ACTIVO";
    return planRepository.findByEstado(estado);
  }

  public Optional<Plan> findPlan(Integer idplan){
    Optional<Plan> plan = planRepository.findById(idplan);
    if (!plan.isPresent())
    throw new EntityNotFound("No hay resultado por el valor: " + idplan);
    return plan;
  }

  public ArrayList findAllByEstado(){
    ArrayList result = new ArrayList();
    String estado = "ACTIVO";
    List<Plan> planes = planRepository.findByEstado(estado);

    for(int i=0; i < planes.size(); i++){

      Plan plan = planes.get(i);
      Integer idcircuito = plan.getIdcircuito();

      Circuits circuito = circuitsRepository.findById(idcircuito).get();
      HashMap<String, Object> Map = new HashMap<>();

      Map.put("Plan", plan);
      Map.put("Circuit", circuito);
      result.add(i, Map);
    }

    return result;
  }

  public Plan addPlan(Plan plan){
    return planRepository.save(plan);
  }

  public Plan inactivatePlan( Integer idplan){

    Optional<Plan> plans = planRepository.findById(idplan);
    if (!plans.isPresent()){
      throw new EntityNotFound("No hay resultado por el valor: " + idplan);
    }else{
      Plan plan = plans.get();
      plan.setEstado("INACTIVO");
      return planRepository.save(plan);
    }
  }

  public Plan updatePlan(Plan plan, Integer idplan) {
    Optional<Plan> plans = planRepository.findById(idplan);
    if (!plans.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " + idplan);
    return planRepository.save(plan);
  }

  public ArrayList findBoardsEvents(){
    ArrayList arrayresultado = new ArrayList();
    List<Circuits> circuitos = circuitsRepository.findAll();

      for(int i = 0; i < circuitos.size(); i++){
        Circuits circuito = circuitos.get(i);
        Integer idCircuito = circuito.getIdcircuito();
        List<Plan> planes = planRepository.findByIdcircuito(idCircuito);
        HashMap<String, Object> resultados = new HashMap<>();
        for(int j=0; j < planes.size(); j++){
          Plan plan = planes.get(j);
          String estado = plan.getEstado();
          if(estado.equalsIgnoreCase("ACTIVO")){
            resultados.put("circuito", circuito);
            resultados.put("planes", plan);
            arrayresultado.add(resultados);
          }

        }
      }

    return arrayresultado;
  }

  public HashMap<String, Object> findFullPlan(Integer idplan){

    HashMap<String, Object> Map = new HashMap<>();

    Plan plan = planRepository.findById(idplan).get();
    Integer idcircuito = plan.getIdcircuito();
    Circuits circuito = circuitsRepository.findById(idcircuito).get();

    List<Department> dptos = departmentRepository.findByIdplan(idplan);
    ArrayList accionArray = new ArrayList();

    for(int i = 0; i< dptos.size(); i++){
      HashMap<String, Object> child = new HashMap<>();
      Department dpto = dptos.get(i);
      Integer idDpto = dpto.getIddptoPlan();
      List<Actions> acciones = actionsRepository.findByIddptoPlan(idDpto);

      child.put("dpto", dpto);
      child.put("acciones", acciones);
      accionArray.add(i, child);
    }

    Map.put("plan", plan);
    Map.put("circuito", circuito);
    Map.put("detail", accionArray);

    return Map;
  }

  public HashMap<String, Object> findFullPlanByCircuit(Integer idcircuito){

      ArrayList departArray = new ArrayList();
      ArrayList accionArray = new ArrayList();
      HashMap<String, Object> resultados = new HashMap<>();
      Circuits circuito = circuitsRepository.findById(idcircuito).get();
      List<Plan> planes = planRepository.findByIdcircuito(idcircuito);

      resultados.put("circuito", circuito);

      for(int j=0; j < planes.size(); j++){
        HashMap<String, Object> child1 = new HashMap<>();
        Plan plan = planes.get(j);
        Integer idplan = plan.getIdplan();
        child1.put("plan", plan);

        List<Department> dptos = departmentRepository.findByIdplan(idplan);

        for(int i=0; i < dptos.size(); i++){
          HashMap<String, Object> child2 = new HashMap<>();
          Department dpto = dptos.get(i);
          Integer iddpto = dpto.getIddptoPlan();
          List<Actions> acciones = actionsRepository.findByIddptoPlan(iddpto);

          child2.put("dpto", dpto);
          child2.put("acciones", acciones);
          accionArray.add(i, child2);
        }

        child1.put("detalles", accionArray);
        departArray.add(j, child1);

      }
      resultados.put("planes", departArray);

    return resultados;
  }

}
