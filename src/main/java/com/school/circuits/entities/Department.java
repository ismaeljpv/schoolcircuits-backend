package com.school.circuits.entities;


import javax.persistence.*;

@Entity
@Table(name = "tab_dpto_plan")
public class Department {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer iddptoPlan;

  private String descripcion;
  private Integer idplan;

  public Department(){}

  public Integer getIddptoPlan() {
    return iddptoPlan;
  }

  public void setIddptoPlan(Integer iddptoPlan) {
    this.iddptoPlan = iddptoPlan;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Integer getIdplan() {
    return idplan;
  }

  public void setIdplan(Integer idplan) {
    this.idplan = idplan;
  }

  @Override
  public String toString() {
    return "Department{" +
      "iddptoPlan=" + iddptoPlan +
      ", descripcion='" + descripcion + '\'' +
      ", idplan=" + idplan +
      '}';
  }
}
