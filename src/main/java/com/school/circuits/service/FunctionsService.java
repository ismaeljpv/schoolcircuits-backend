package com.school.circuits.service;

import com.school.circuits.entities.Functions;
import com.school.circuits.exception.EntityNotFound;
import com.school.circuits.repository.CircuitsRepository;
import com.school.circuits.repository.FunctionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FunctionsService {

  @Autowired
  private FunctionsRepository funcRepository;

  public Optional<Functions> findFunction(Integer idpersona){
    return funcRepository.findByIdpersona(idpersona);
  }

  public Functions addFunction(Functions function){
    return funcRepository.save(function);
  }

  public void deleteFunction(Integer idpersona) {

    Optional<Functions> funciones = funcRepository.findByIdpersona(idpersona);
    if (!funciones.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " + idpersona);
    Functions fun = funciones.get();
    Integer idFuncion = fun.getIdfuncEsp();
    funcRepository.deleteById(idFuncion);

  }

}
