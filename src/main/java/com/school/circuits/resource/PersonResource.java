package com.school.circuits.resource;


import com.school.circuits.dto.PersonDto;
import com.school.circuits.entities.Person;
import com.school.circuits.entities.Schools;
import com.school.circuits.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/person")
public class PersonResource {

    private PersonService personService;
    public PersonResource(PersonService personService) {
        this.personService =personService;
    }



    @GetMapping( value = "/getAll")
    public List<PersonDto> findPersons(){
        return personService.findPersons();
    }

    @GetMapping( value="/getFullPerson/{idpersona}")
    public HashMap<String, Object> findFullPerson(@PathVariable Integer idpersona){
        return personService.findFullPerson(idpersona);
    }

    @PutMapping( value = "/updatePerson/{idPersona}")
    public Person updatePerson(@RequestBody Person persona, @PathVariable Integer idPersona){
      return personService.updatePerson(persona, idPersona);
    }

    @GetMapping(value = "/getSupervisores")
    public List<PersonDto> findPrueba(){
        return personService.findSupervisores();
    }

    @GetMapping(value = "/getSupervisores2")
    public List<PersonDto> findPrueba2(){
    return personService.findSupervisores2();
  }

    @PostMapping( value ="/addPerson")
    public Person addPerson(@RequestBody Person persona){
        return personService.addPerson(persona);
    }

    @DeleteMapping( value="/deletePerson/{idpersona}")
    public void deletePerson(@PathVariable Integer idpersona){
        personService.deletePerson(idpersona);
    }

    @PostMapping( value="/enlaces")
    public HashMap<String, Object> findParticipacion(@RequestBody  HashMap<String, Object> json){
      String enl = (String) json.get("enlace");
      int idcircuito = (int) json.get("idcircuito");

      return personService.findParticipacion(idcircuito, enl);
    }

    @PostMapping( value = "/personal")
    public ArrayList findPersonal(@RequestBody  HashMap<String, Object> json){

      String status = (String) json.get("status");
      int idSchool = (int) json.get("idschool");

      return personService.findPersonalByStatus(status, idSchool);
    }

    @GetMapping( value = "/directores/{idcircuito}")
    public HashMap<String, Object> findPersonal(@PathVariable Integer idcircuito){

    return personService.findDirectores(idcircuito);
  }

   @GetMapping( value ="/allPersonal/{idplantel}")
   public  HashMap<String, Object> findAllPersonal(@PathVariable Integer idplantel){

      return personService.findAllPersonal(idplantel);
   }

}
