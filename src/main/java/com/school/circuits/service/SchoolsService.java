package com.school.circuits.service;

import com.school.circuits.dto.SchoolsDto;
import com.school.circuits.entities.Circuits;
import com.school.circuits.entities.Person;
import com.school.circuits.entities.Schools;
import com.school.circuits.entities.SchoolsNeeds;
import com.school.circuits.exception.EntityNotFound;
import com.school.circuits.repository.CircuitsRepository;
import com.school.circuits.repository.PersonRepository;
import com.school.circuits.repository.SchoolsNeedsRepository;
import com.school.circuits.repository.SchoolsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolsService {

    @Autowired
    private SchoolsRepository schoolsRepository;

    @Autowired
    private CircuitsRepository circuitsRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SchoolsNeedsRepository snRepository;

    public List<Schools> findAllSchools(){
        return schoolsRepository.findAll();
    }


    public List<SchoolsDto> findAllSchoolsDto(){
        List<Schools> schools = schoolsRepository.findAll();
        return schools.stream().map(this::convertToSchoolsDto).collect(Collectors.toList());
    }

    public SchoolsDto findSchoolDto(Integer idplantel){

        Schools schools = schoolsRepository.findById(idplantel).get();

        SchoolsDto school =  new SchoolsDto();
        school.setPlantel(schools.getPlantel());
        school.setAnoFundacion(schools.getAnoFundacion());
        school.setCodigoAdmin(schools.getCodigoAdmin());
        school.setDireccion(schools.getDireccion());
        school.setGeorefLatitud(schools.getGeorefLatitud());
        school.setGeorefLongitud(schools.getGeorefLongitud());
        school.setIdplantel(schools.getIdplantel());
        school.setIdcircuito(schools.getIdcircuito());
        school.setCodigoEstadistico(schools.getCodigoEstadistico());
        school.setSige(schools.getSige());
        return school;
    }

    public Optional<Schools> findSchool(int idplantel){
        return schoolsRepository.findById(idplantel);
    }

    public Schools addSchool(Schools school){

      String rif = school.getRif();
      Optional<Schools> escuela = schoolsRepository.findByRif(rif);
      if (escuela.isPresent())
        throw new EntityNotFound("Registro duplicado por el valor" + rif);
      return schoolsRepository.save(school);
    }

    public Schools updateSchool(Schools school, Integer idplantel){
        Optional<Schools> updateSchool = schoolsRepository.findById(idplantel);
        if (!updateSchool.isPresent())
            throw new EntityNotFound("No hay resultado por el valor: " + idplantel);

        return schoolsRepository.save(school);
    }

    public void deleteSchool(Integer idschool){
        Optional<Schools> school = schoolsRepository.findById(idschool);
        if (!school.isPresent()){
            throw new EntityNotFound("No hay resultado por el valor: " + idschool);
        }else{
            Optional<Person> person = personRepository.findByIdplantel(idschool);
            if(!person.isPresent()){
                schoolsRepository.deleteById(idschool);
            }else{
                Person persona = person.get();
                persona.setIdplantel(null);
                personRepository.save(persona);
                schoolsRepository.deleteById(idschool);
            }
        }
    }

    public HashMap<String, Object> findFullSchool(Integer idschool){

      Schools school = schoolsRepository.findById(idschool).get();
      Integer idCircuito = school.getIdcircuito();
      Person persona = personRepository.findByIdcircuito(idCircuito).get();
      Circuits circuito = circuitsRepository.findById(idCircuito).get();
      List<Person> personas = personRepository.findAllByIdplantel(idschool);
      Optional<SchoolsNeeds> necesidades = snRepository.findByIdplantel(idschool);

      HashMap<String, Object> resultados = new HashMap<>();
      resultados.put("school", school);
      resultados.put("persons", personas);
      resultados.put("needs", necesidades );
      resultados.put("circuit", circuito);
      resultados.put("supervisor", persona);

      return resultados;
    }

    // Coversion a SchoolDto
    private SchoolsDto convertToSchoolsDto(Schools school) {
        return new ModelMapper().map(school, SchoolsDto.class);
    }
}
