package com.school.circuits.service;

import com.school.circuits.dto.PersonDto;
import com.school.circuits.entities.*;
import com.school.circuits.exception.EntityNotFound;
import com.school.circuits.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SchoolsRepository schoolsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private FunctionsRepository funcRepository;

    @Autowired
    private CircuitsRepository circuitsRepository;

    public List<PersonDto> findPersons(){
        List<Person> persona = personRepository.findAll();

        return persona.stream().map(this::convertToPersonDto).collect(Collectors.toList());
    }

    public HashMap<String, Object> findFullPerson(Integer idpersona){

        Optional<Person> persona = personRepository.findById(idpersona);
        HashMap<String, Object> Map = new HashMap<String, Object>();
        if(!persona.isPresent())
            throw new EntityNotFound("No hay resultado por el valor: " + idpersona);
        else {
            Person person = persona.get();
            Map.put("Person", person);
            Integer idplantel = person.getIdplantel();
            if (idplantel != null){
                Schools school = schoolsRepository.findById(idplantel).get();
                Map.put("School", school);
            }

        }
        return Map;
    }

    public List<PersonDto> findSupervisores(){
        List<Person> persona = personRepository.findAllSupervisores();

        return persona.stream().map(this::convertToPersonDto).collect(Collectors.toList());
    }

  public List<PersonDto> findSupervisores2(){
    List<Person> persona = personRepository.findAllSupervisores2();

    return persona.stream().map(this::convertToPersonDto).collect(Collectors.toList());
  }

    public Person addPerson(Person persona){
      String cedula = persona.getCedula();
      Optional<Person> person = personRepository.findByCedula(cedula);
      if(person.isPresent())
        throw new EntityNotFound("El registro ya existe por el valor " + cedula);
      return personRepository.save(persona);
    }

    public void deletePerson(Integer idpersona){
        Optional<Users> usuario = usersRepository.findByIdpersona(idpersona);
        if(!usuario.isPresent()){
          Optional<Functions> funciones = funcRepository.findByIdpersona(idpersona);
          if (!funciones.isPresent()){
            personRepository.deleteById(idpersona);
          }else{
          Functions fun = funciones.get();
          fun.setIdpersona(null);
          funcRepository.save(fun);
          personRepository.deleteById(idpersona);
          }
          }else{
            Users user = usuario.get();
            Integer iduser = user.getIdpersona();
            usersRepository.deleteById(iduser);

          Optional<Functions> funciones = funcRepository.findByIdpersona(idpersona);
          if (!funciones.isPresent()){
            personRepository.deleteById(idpersona);
          }else{
            Functions fun = funciones.get();
            fun.setIdpersona(null);
            funcRepository.save(fun);
            personRepository.deleteById(idpersona);
          }

        }
    }

    public Person updatePerson(Person persona, Integer idpersona){
      Optional<Person> person = personRepository.findById(idpersona);
      if(!person.isPresent())
        throw new EntityNotFound("No hay resultado por el valor: " + idpersona);

      return personRepository.save(persona);
    }

    public HashMap<String, Object> findParticipacion(Integer idcircuito, String enl){

      HashMap<String, Object> resultados = new HashMap<>();
      ArrayList enlaces = new ArrayList();
      Optional<Circuits> circuit = circuitsRepository.findById(idcircuito);

      if (!circuit.isPresent()){
        throw new EntityNotFound("No hay resultado por el valor: " + idcircuito);
      }else {
        Circuits circuito = circuit.get();
        String nombre = circuito.getNombrecircuital();
        String codigocir = circuito.getCodigoCircuital();

        List<Schools> escuelas = schoolsRepository.findAllByIdcircuito(idcircuito);
        for (int i = 0; i < escuelas.size(); i++) {

          Schools escuela = escuelas.get(i);
          String plantel = escuela.getPlantel();
          String direccion = escuela.getDireccion();
          String rif = escuela.getRif();
          String codAdmin = escuela.getCodigoAdmin();

          Integer idesc = escuela.getIdplantel();

          List<Person> personas = personRepository.findAllByIdplantel(idesc);
          for (int j = 0; i < personas.size(); i++) {
            HashMap<String, Object> resultados2 = new HashMap<>();
            Person persona = personas.get(i);

            String nombre1 = persona.getNombre1();
            String nombre2 = persona.getNombre2();
            String apellido1 = persona.getApellido1();
            String apellido2 = persona.getApellido2();
            String cedula = persona.getCedula();
            String telefono = persona.getTelefono();
            String cargo = persona.getCargoFuncion();

            Integer idpersona = persona.getIdpersona();

            Optional<Functions> funciones = funcRepository.findByIdpersona(idpersona);
            if (funciones.isPresent()) {
              Functions funcion = funciones.get();
              String enlace = funcion.getEnlace();
              if (enlace.equalsIgnoreCase(enl)) {
                resultados2.put("nombre", nombre1 +" "+ nombre2 );
                resultados2.put("apellido", apellido1 +" "+ apellido2);
                resultados2.put("cedula", cedula);
                resultados2.put("telefono", telefono);
                resultados2.put("cargo", cargo);
                resultados2.put("plantel", plantel);
                resultados2.put("codAdmin", codAdmin);
                resultados2.put("direccion", direccion);
                resultados2.put("rif", rif);
                resultados2.put("enlace", funcion);
                enlaces.add(j, resultados2);
              }
            }

          }

        }

        resultados.put("circuito", nombre);
        resultados.put("codigocir", codigocir);
        resultados.put("enlaces", enlaces);
      }

      return resultados;
    }

    public ArrayList findPersonalByStatus(String status, int idSchool){

      ArrayList personal = new ArrayList();

      Optional<Schools> escuela = schoolsRepository.findById(idSchool);
      if(!escuela.isPresent()) {
        throw new EntityNotFound("No hay resultado por el valor: " + idSchool);
      }else{
        Schools school = escuela.get();
        String plantel = school.getPlantel();
        String direccion = school.getDireccion();
        String rif = school.getRif();
        String codAdmin = school.getCodigoAdmin();
        List<Person> personas = personRepository.findAllByIdplantel(idSchool);
        for(int i=0; i < personas.size(); i++){
          HashMap<String, Object> resultados = new HashMap<>();
          Person persona = personas.get(i);
          String estatus = persona.getEstatus();
          if(estatus.equalsIgnoreCase(status)){
              resultados.put("persona", persona);
              resultados.put("plantel", plantel);
              resultados.put("codAdmin", codAdmin);
              resultados.put("direccion", direccion);
              resultados.put("rif", rif);
              personal.add(i, resultados);
          }
        }

      }


      return personal;
    }

    public HashMap<String, Object> findDirectores(Integer idcircuito){

      HashMap<String, Object> results = new HashMap<>();
      ArrayList directores = new ArrayList();

      Optional<Circuits> circuit = circuitsRepository.findById(idcircuito);

      if (!circuit.isPresent()){
        throw new EntityNotFound("No hay resultado por el valor: " + idcircuito);
      }else {

        Circuits circuito = circuit.get();
        String nombre = circuito.getNombrecircuital();
        String codigocir = circuito.getCodigoCircuital();
        List<Schools> escuelas = schoolsRepository.findAllByIdcircuito(idcircuito);
        for (int i = 0; i < escuelas.size(); i++) {
          Schools escuela = escuelas.get(i);
          String plantel = escuela.getPlantel();
          String direccion = escuela.getDireccion();
          String rif = escuela.getRif();
          String codAdmin = escuela.getCodigoAdmin();

          Integer idesc = escuela.getIdplantel();

          List<Person> personas = personRepository.findAllByIdplantel(idesc);
          for (int j = 0; i < personas.size(); i++) {
            HashMap<String, Object> resultados = new HashMap<>();
            Person persona = personas.get(i);
            String cargo = persona.getCargoFuncion();
            if(cargo.equalsIgnoreCase("DIRECTOR(A)")){
              resultados.put("persona", persona);
              resultados.put("plantel", plantel);
              resultados.put("codAdmin", codAdmin);
              resultados.put("direccion", direccion);
              resultados.put("rif", rif);
              directores.add(j, resultados);
            }
          }


        }

        results.put("circuito", nombre);
        results.put("codigocir", codigocir);
        results.put("directores", directores);

      }

      return results;
    }

    public HashMap<String, Object> findAllPersonal(Integer idplantel){

      Optional<Schools> escuela = schoolsRepository.findById(idplantel);
      HashMap<String, Object> results = new HashMap<>();

      if (!escuela.isPresent()){
        throw new EntityNotFound("No hay resultado por el valor: " + idplantel);
      }else {

        Schools school = escuela.get();
        String plantel = school.getPlantel();
        String rif = school.getRif();
        List <Person> personal =  personRepository.findAllByIdplantel(idplantel);

        results.put("plantel", plantel);
        results.put("rif", rif);
        results.put("personal", personal);
      }

      return results;
    }

    // Coversion a PersonDto
    private PersonDto convertToPersonDto(Person persona) {
        return new ModelMapper().map(persona, PersonDto.class);

    }
}
