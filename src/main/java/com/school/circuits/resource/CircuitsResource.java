package com.school.circuits.resource;

import com.school.circuits.dto.CircuitsDto;
import com.school.circuits.entities.Circuits;
import com.school.circuits.service.CircuitsService;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/circuits")
public class CircuitsResource {

    private CircuitsService circuitsService;
    public CircuitsResource(CircuitsService circuitService) {
        this.circuitsService = circuitService;
    }

    @GetMapping( value = "/getAll")
    public List<Circuits> findCircuits(){
        return circuitsService.findCircuits();
    }

    @GetMapping( value="/getCircuits")
    public List<CircuitsDto> findCircuitsDto(){
        return circuitsService.findCircuitsDto();
    }

    @GetMapping( value ="/getFullCircuits")
    public ArrayList findCircuitsWithSuper(){
        return circuitsService.findCircuitsWithSuper();
    }

    @GetMapping( value ="/getCircuit/{idCircuit}")
    public HashMap<String ,Object> findCircuit( @PathVariable int idCircuit ){
        return circuitsService.findCircuit(idCircuit);
    }

    @GetMapping(value ="/getAllSchools/{idCircuit}")
    public HashMap<String ,Object> findAllSchool( @PathVariable int idCircuit ){
      return circuitsService.findSchoolByCircuit(idCircuit);
    }

    @PostMapping(value ="/addCircuit")
    public Circuits addCircuit( @RequestBody HashMap<String ,Object> json){
        Integer idpersona = (Integer) json.get("idpersona");
        Integer nro = (Integer) json.get("nro");
        String nombrecircuital = (String) json.get("nombrecircuital");
        String codigoCircuital = (String) json.get("codigoCircuital");
        String lema = (String) json.get("lema");
        String puntoycirculo = (String) json.get("puntoycirculo");
        Integer nroplanteles = (Integer) json.get("nroplanteles");
        String imagenGeoref = (String) json.get("imagenGeoref");
        String estado = (String) json.get("estado");
        String municipio = (String) json.get("municipio");
        String parroquia = (String) json.get("parroquia");



        Circuits circuit = new Circuits(nro, nombrecircuital, codigoCircuital, lema, puntoycirculo, nroplanteles, estado, municipio, parroquia, imagenGeoref);
        return circuitsService.addCircuit(circuit, idpersona);
    }

    @PutMapping( value ="/updateCircuit/{idCircuit}")
    public Circuits updateCircuit( @PathVariable int idCircuit ,@RequestBody HashMap<String ,Object> json){
        Integer idcircuito = (Integer) json.get("idcircuito");
        Integer idpersona = (Integer) json.get("idpersona");
        Integer nro = (Integer) json.get("nro");
        String nombrecircuital = (String) json.get("nombrecircuital");
        String codigoCircuital = (String) json.get("codigoCircuital");
        String lema = (String) json.get("lema");
        String puntoycirculo = (String) json.get("puntoycirculo");
        Integer nroplanteles = (Integer) json.get("nroplanteles");
        String imagenGeoref = (String) json.get("imagenGeoref");
        String estado = (String) json.get("estado");
        String municipio = (String) json.get("municipio");
        String parroquia = (String) json.get("parroquia");



        Circuits circuit = new Circuits(idcircuito, nro, nombrecircuital, codigoCircuital, lema, puntoycirculo, nroplanteles, estado, municipio, parroquia, imagenGeoref);
        return circuitsService.updateCircuit(circuit, idpersona, idCircuit);
    }

    @DeleteMapping(value = "/deleteCircuit/{idCircuit}")
    public void deleteUser(@PathVariable Integer idCircuit){
        circuitsService.deleteCircuit(idCircuit);
    }

}
