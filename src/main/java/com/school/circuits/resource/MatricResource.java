package com.school.circuits.resource;


import com.school.circuits.entities.Matric;
import com.school.circuits.service.MatricService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/matric")
public class MatricResource {





    private MatricService matService;
    public MatricResource(MatricService matService) {
      this.matService = matService;
    }

    @GetMapping(value ="/getMatriculas")
    public List<Matric> findMatriculas(){
      return matService.getMatriculas();
    }

    @GetMapping(value ="/getMatricula/{idmat}")
    public Optional<Matric> getMatric(@PathVariable Integer idmat){
      return matService.findMatric(idmat);
    }

    @GetMapping(value = "/getMatriculasPlantel/{idplantel}")
    public HashMap<String, Object> getAllMatByPlantel(@PathVariable Integer idplantel){

      return matService.getAllMatByPlantel(idplantel);
    }

   @GetMapping(value = "/getMatriculasCircuit/{idcircuit}")
   public HashMap<String, Object> getAllMatByCircuit(@PathVariable Integer idcircuit){

    return matService.getAllMatByCircuit(idcircuit);
   }

    @PostMapping(value="/addMatricula")
    public Matric addMatric(@RequestBody Matric matricula){
      return matService.addMatric(matricula);
    }

    @PutMapping(value ="/updateMatricula/{idmat}")
    public Matric updateAction(@RequestBody Matric matricula, @PathVariable Integer idmat){
      return matService.updateAction(matricula, idmat);
    }

    @DeleteMapping(value="/deleteMatricula/{idmat}")
    public void deleteAction(@PathVariable Integer idmat){
      matService.deleteMatric(idmat);
    }
  }



