package com.school.circuits.entities;


import javax.persistence.*;

@Entity
@Table(name = "tab_acciones")
public class Actions {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idaccion;

  private String descripcion;
  private String totalParticipantes;
  private Integer iddptoPlan;

  public Actions() {
  }

  public Integer getIdaccion() {
    return idaccion;
  }

  public void setIdaccion(Integer idaccion) {
    this.idaccion = idaccion;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getTotalParticipantes() {
    return totalParticipantes;
  }

  public void setTotalParticipantes(String totalParticipantes) {
    this.totalParticipantes = totalParticipantes;
  }

  public Integer getIddptoPlan() {
    return iddptoPlan;
  }

  public void setIddptoPlan(Integer iddptoPlan) {
    this.iddptoPlan = iddptoPlan;
  }

  @Override
  public String toString() {
    return "Actions{" +
      "idaccion=" + idaccion +
      ", descripcion='" + descripcion + '\'' +
      ", totalParticipantes='" + totalParticipantes + '\'' +
      ", iddptoPlan=" + iddptoPlan +
      '}';
  }
}
