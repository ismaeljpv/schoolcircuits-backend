package com.school.circuits.service;

import com.school.circuits.dto.CircuitsDto;
import com.school.circuits.dto.PersonDto;
import com.school.circuits.entities.Circuits;
import com.school.circuits.entities.Person;
import com.school.circuits.entities.Schools;
import com.school.circuits.exception.EntityNotFound;
import com.school.circuits.repository.CircuitsRepository;
import com.school.circuits.repository.PersonRepository;
import com.school.circuits.repository.SchoolsRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CircuitsService {

    @Autowired
    private CircuitsRepository circuitsRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SchoolsRepository schoolsRepository;

    private static final Logger logger = LoggerFactory.getLogger(UsersService.class);

    public List<Circuits> findCircuits(){

        return circuitsRepository.findAll();
    }

    public List<CircuitsDto> findCircuitsDto(){
        List<Circuits> circuitos = circuitsRepository.findAll();

       return circuitos.stream().map(this::convertToCircuitsDto).collect(Collectors.toList());
    }

    public ArrayList findCircuitsWithSuper(){
        ArrayList FullCircuit = new ArrayList();
        List<Circuits> circuits = circuitsRepository.findAll();

        for(int i=0; i< circuits.size(); i++){
            Circuits circuit = circuits.get(i);
            Integer idCircuit = circuit.getIdcircuito();
            Optional<Person> persona1 = personRepository.findByIdcircuito(idCircuit);
            if(!persona1.isPresent()){
              HashMap<String, Object> Map = new HashMap<>();
              Map.put("Circuit", circuit);
              Map.put("Person", "SIN ASIGNAR");
              FullCircuit.add(i, Map);

            }else {
              Person persona = persona1.get();
              HashMap<String, Object> Map = new HashMap<>();
              Map.put("Circuit", circuit);
              Map.put("Person", persona.getNombre1() +" "+persona.getApellido1());
              FullCircuit.add(i, Map);
            }

        }

        return FullCircuit;
    }

    public HashMap<String ,Object> findCircuit( int idCircuit) {

        Circuits circuit = circuitsRepository.findById(idCircuit).get();
        Integer idCircuito = circuit.getIdcircuito();
        Optional<Person> persona1 = personRepository.findByIdcircuito(idCircuito);
        HashMap<String ,Object> Map = new HashMap<>();

        if(!persona1.isPresent()){
        Map.put("Circuit", circuit);
        Map.put("Person", null);

        }else {
          Person persona = persona1.get();
          Map.put("Circuit", circuit);
          Map.put("Person", persona.getIdpersona());

        }

        return Map;
    }

    public Circuits addCircuit (Circuits circuit, Integer idpersona){

        String cogigoCircuital = circuit.getCodigoCircuital();
        Optional<Circuits> cir = circuitsRepository.findByCodigoCircuital(cogigoCircuital);
        if (cir.isPresent()) {
        throw new EntityNotFound("Registrado duplicado por el valor " + cir);
        } else {
          circuitsRepository.save(circuit);
          Circuits agr = circuitsRepository.findByCodigoCircuital(cogigoCircuital).get();
          Integer idcircuito = agr.getIdcircuito();
          Person persona = personRepository.findById(idpersona).get();
          persona.setIdcircuito(idcircuito);
          personRepository.save(persona);
          return agr;
      }
    }

    public Circuits updateCircuit(Circuits circuit, Integer idpersona, Integer idCircuit){

        Optional<Person> person = personRepository.findByIdcircuito(idCircuit);
        if (!person.isPresent()) {
          Person newperson2 = personRepository.findById(idpersona).get();
          newperson2.setIdcircuito(circuit.getIdcircuito());
          personRepository.save(newperson2);

        } else {
            Person persona = person.get();
            persona.setIdcircuito(null);
            personRepository.save(persona);

            Person newperson2 = personRepository.findById(idpersona).get();
            newperson2.setIdcircuito(null);
            newperson2.setIdcircuito(circuit.getIdcircuito());
            personRepository.save(newperson2);
        }
        return circuitsRepository.save(circuit);
    }

    public void deleteCircuit(Integer idCircuit){

        Optional<Person> persona = personRepository.findByIdcircuito(idCircuit);
        if (!persona.isPresent()){
            throw new EntityNotFound("No hay resultado por el valor: " + idCircuit);
        }else{
            Person person = persona.get();
            person.setIdcircuito(null);
            personRepository.save(person);
            Optional<Circuits> circuito = circuitsRepository.findById(idCircuit);
            if (!circuito.isPresent())
                throw new EntityNotFound("No hay resultado por el valor: " + idCircuit);
            circuitsRepository.deleteById(idCircuit);

        }
    }

    public HashMap<String, Object> findSchoolByCircuit(Integer idCircuito){

      HashMap<String, Object> resultados = new HashMap<>();

      Circuits circuito = circuitsRepository.findById(idCircuito).get();
      List<Schools> escuelas = schoolsRepository.findAllByIdcircuito(idCircuito);
      Person persona = personRepository.findByIdcircuito(idCircuito).get();

      resultados.put("circuit", circuito);
      resultados.put("Schools", escuelas);
      resultados.put("supervisor", persona);

      return resultados;
    }

    // Coversion a PersonDto
    private CircuitsDto convertToCircuitsDto(Circuits circuito) {
        return new ModelMapper().map(circuito, CircuitsDto.class);
    }

}
