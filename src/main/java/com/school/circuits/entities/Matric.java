package com.school.circuits.entities;

import javax.persistence.*;

@Entity
@Table(name = "tab_matriculas")
public class Matric {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idmatricula;

  private String descripcionNivel;
  private String grado;
  private Integer aulas;
  private Integer secciones;
  private Integer varones;
  private Integer hembras;
  private Integer total;
  private Integer idplantel;

  public Matric(){}

  public Integer getIdmatricula() {
    return idmatricula;
  }

  public void setIdmatricula(Integer idmatricula) {
    this.idmatricula = idmatricula;
  }

  public String getDescripcionNivel() {
    return descripcionNivel;
  }

  public void setDescripcionNivel(String descripcionNivel) {
    this.descripcionNivel = descripcionNivel;
  }

  public String getGrado() {
    return grado;
  }

  public void setGrado(String grado) {
    this.grado = grado;
  }

  public Integer getAulas() {
    return aulas;
  }

  public void setAulas(Integer aulas) {
    this.aulas = aulas;
  }

  public Integer getSecciones() {
    return secciones;
  }

  public void setSecciones(Integer secciones) {
    this.secciones = secciones;
  }

  public Integer getVarones() {
    return varones;
  }

  public void setVarones(Integer varones) {
    this.varones = varones;
  }

  public Integer getHembras() {
    return hembras;
  }

  public void setHembras(Integer hembras) {
    this.hembras = hembras;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Integer getIdplantel() {
    return idplantel;
  }

  public void setIdplantel(Integer idplantel) {
    this.idplantel = idplantel;
  }

  @Override
  public String toString() {
    return "Matric{" +
      "idmatricula=" + idmatricula +
      ", descripcionNivel='" + descripcionNivel + '\'' +
      ", grado='" + grado + '\'' +
      ", aulas=" + aulas +
      ", secciones=" + secciones +
      ", varones=" + varones +
      ", hembras=" + hembras +
      ", total=" + total +
      ", idplantel=" + idplantel +
      '}';
  }
}
