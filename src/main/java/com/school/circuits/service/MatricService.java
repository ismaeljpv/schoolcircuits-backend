package com.school.circuits.service;


import com.school.circuits.dto.SchoolsDto;
import com.school.circuits.entities.Circuits;
import com.school.circuits.entities.Matric;
import com.school.circuits.entities.Schools;
import com.school.circuits.exception.EntityNotFound;
import com.school.circuits.repository.CircuitsRepository;
import com.school.circuits.repository.MatricRepository;
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
public class MatricService {

  @Autowired
  private MatricRepository matricRepository;

  @Autowired
  private SchoolsRepository schoolsRepository;

  @Autowired
  private CircuitsRepository circuitsRepository;

  private static final Logger logger = LoggerFactory.getLogger(UsersService.class);

  public Matric addMatric (Matric matric){
    return matricRepository.save(matric);
  }

  public Optional<Matric> findMatric(Integer idmatric){
    return matricRepository.findById(idmatric);
  }

  public ArrayList getMatriculas(){
    ArrayList resultados = new ArrayList();
    List<Schools> escuelas = schoolsRepository.findAll();
    List<SchoolsDto> schoolDTOS = escuelas.stream().map(this::convertToSchoolsDto).collect(Collectors.toList());

    for(int i=0; i < schoolDTOS.size(); i++){
      SchoolsDto school = schoolDTOS.get(i);
      Integer idescuela = school.getIdplantel();
      List<Matric> matriculas = matricRepository.findByIdplantel(idescuela);
      HashMap<String, Object> map = new HashMap<>();
      map.put("escuela", school);
      map.put("matriculas", matriculas);
      resultados.add(i, map);
    }

    return resultados;
  }

  public HashMap<String, Object> getAllMatByPlantel(Integer idplantel){
    HashMap<String, Object> resultados = new HashMap<>();

    Optional<Schools> escuela = schoolsRepository.findById(idplantel);
    if (!escuela.isPresent()){
      throw new EntityNotFound("No hay resultado por el valor: " +  idplantel);
    }else{
      Schools school = escuela.get();
      List<Matric> matriculas = matricRepository.findByIdplantel(idplantel);

      resultados.put("school", school);
      resultados.put("matriculas", matriculas);
    }

    return resultados;
  }

  public HashMap<String, Object> getAllMatByCircuit(Integer idcircuit){
    HashMap<String, Object> resultados = new HashMap<>();
    ArrayList results = new ArrayList();
    String nombrecircuital;

    int miv = 0;
    int mih = 0;
    int mpv = 0;
    int mph = 0;
    int mgv = 0;
    int mgh = 0;
    int ca =0;
    int cs =0;


    Optional<Circuits> circuit = circuitsRepository.findById(idcircuit);
    if (!circuit.isPresent()){
      throw new EntityNotFound("No hay resultado por el valor: " +  idcircuit);
    }else{

      Circuits circuito = circuit.get();
      Integer idcircuito = circuito.getIdcircuito();
      nombrecircuital = circuito.getNombrecircuital();


     List<Schools> schools = schoolsRepository.findAllByIdcircuito(idcircuito);
      for(int i=0; i < schools.size(); i++){

          HashMap<String, Object> temporal = new HashMap<>();
          Schools escuela = schools.get(i);
          Integer idschool = escuela.getIdplantel();
          String  plantel = escuela.getPlantel();

          List<Matric> matriculas = matricRepository.findByIdplantel(idschool);
          for(int j=0; j < matriculas.size(); j++){

            Matric mat = matriculas.get(j);
            Integer varones = mat.getVarones();
            Integer hembras = mat.getHembras();
            Integer caulas = mat.getAulas();
            Integer csecciones = mat.getSecciones();
            Integer total = mat.getTotal();

            String nivel = mat.getDescripcionNivel();

            logger.info("nivel = "+nivel);

            if(nivel.equalsIgnoreCase("INICIAL")){
              miv += varones;
              mih += hembras;
            }

            if(nivel.equalsIgnoreCase("PRIMARIA")){
              mpv += varones;
              mph += hembras;
            }
            if(nivel.equalsIgnoreCase("MEDIA GENERAL")){
              mgv += varones;
              mgh += hembras;
            }

            ca += caulas;
            cs += csecciones;
          }


          temporal.put("plantel", plantel);
          temporal.put("varonesInicial", miv);
          temporal.put("hembrasInicial", mih);
          temporal.put("totalInicial", miv + mih);
          temporal.put("varonesPrimaria", mpv);
          temporal.put("hembrasPrimaria", mph);
          temporal.put("totalPrimaria", mpv + mph);
          temporal.put("varonesGeneral", mgv);
          temporal.put("hembrasGeneral", mgh);
          temporal.put("totalGeneral", mgv + mgh);
          temporal.put("totalAulas", ca);
          temporal.put("totalSecciones", cs);
          temporal.put("totalVarones", miv + mpv + mgv);
          temporal.put("totalHembras", mih + mph + mgh);
          temporal.put("TotalEntero", miv + mpv + mgv + mih + mph + mgh);
          results.add(i, temporal);

          miv = 0;
          mih = 0;
          mpv = 0;
          mph = 0;
          mgv = 0;
          mgh = 0;
          ca =0;
          cs =0;

      }
    }

    resultados.put("circuit", nombrecircuital);
    resultados.put("planteles", results);

    return resultados;
  }

  public Matric updateAction(Matric matric, Integer idmatri){
    Optional<Matric> matricula = matricRepository.findById(idmatri);
    if (!matricula.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " +  idmatri);
    return matricRepository.save(matric);
  }


  public void deleteMatric(Integer idmatric){
    Optional<Matric> matricula = matricRepository.findById(idmatric);
    if (!matricula.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " +  idmatric);
    matricRepository.deleteById(idmatric);
  }

    // Coversion a SchoolDto
    private SchoolsDto convertToSchoolsDto(Schools school) {
    return new ModelMapper().map(school, SchoolsDto.class);
  }
}
