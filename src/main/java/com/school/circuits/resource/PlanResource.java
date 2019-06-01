package com.school.circuits.resource;


import com.school.circuits.entities.Events;
import com.school.circuits.entities.Plan;
import com.school.circuits.service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/plan") //   /plan/events
public class PlanResource {


        private PlanService planService;
        public PlanResource(PlanService planService) {
        this.planService = planService;
        }

  @GetMapping( value ="/find/{idplan}")
  public Optional<Plan> findPlan(@PathVariable Integer idplan){

          return planService.findPlan(idplan);
  }

  @GetMapping( value = "/findAll")
  public ArrayList findAllPlans(){
          return planService.findAllByEstado();
  }

  @PostMapping( value="/addPlan")
  public Plan addPlan(@RequestBody Plan plan){
          return planService.addPlan(plan);
  }

  @PutMapping( value="/inactivate/{idplan}")
  public Plan inactivatePlan(@RequestBody HashMap<String, Object> json, @PathVariable Integer idplan){
          return planService.inactivatePlan(idplan);
  }

  @PutMapping( value ="/updatePlan/{idplan}")
  public Plan updatePlan(@RequestBody Plan plan, @PathVariable Integer idplan){

          return planService.updatePlan(plan, idplan);
  }

  @GetMapping( value ="/events")
  public ArrayList findBoardEvents(){
          return planService.findBoardsEvents();
  }

  @GetMapping( value="/getFullPlan/{idplan}")
  public HashMap<String, Object> findFullPlan(@PathVariable Integer idplan){
          return planService.findFullPlan(idplan);
  }

  @GetMapping( value="/getFullPlanByCircuit/{idcircuito}")
  public HashMap<String, Object> findFullPlanByCircuit(@PathVariable Integer idcircuito)
  {
          return planService.findFullPlanByCircuit(idcircuito);

  }

}
