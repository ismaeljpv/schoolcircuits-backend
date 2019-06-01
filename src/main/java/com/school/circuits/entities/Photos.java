package com.school.circuits.entities;


import javax.persistence.*;

@Entity
@Table(name = "tab_evidencias")
public class Photos {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer idevidencia;

  private String observaciones;
  private String foto;
  private Integer idplan;

  public Photos(){}

  public Integer getIdevidencia() {
    return idevidencia;
  }

  public void setIdevidencia(Integer idevidencia) {
    this.idevidencia = idevidencia;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public Integer getIdplan() {
    return idplan;
  }

  public void setIdplan(Integer idplan) {
    this.idplan = idplan;
  }

  @Override
  public String toString() {
    return "Photos{" +
      "idevidencia=" + idevidencia +
      ", observaciones='" + observaciones + '\'' +
      ", foto='" + foto + '\'' +
      ", idplan=" + idplan +
      '}';
  }
}
