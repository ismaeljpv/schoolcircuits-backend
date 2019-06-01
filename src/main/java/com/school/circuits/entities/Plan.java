package com.school.circuits.entities;

import javax.persistence.*;

@Entity
@Table(name = "tab_plan_accion")
public class Plan {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idplan;

  private String titulo;
  private String momento;
  private String estado;
   private Integer idcircuito;



  public Plan(){}

  public Integer getIdplan() {
    return idplan;
  }

  public void setIdplan(Integer idplan) {
    this.idplan = idplan;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getMomento() {
    return momento;
  }

  public void setMomento(String momento) {
    this.momento = momento;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Integer getIdcircuito() {
    return idcircuito;
  }

  public void setIdcircuito(Integer idcircuito) {
    this.idcircuito = idcircuito;
  }

  @Override
  public String toString() {
    return "Plan{" +
      "idplan=" + idplan +
      ", titulo='" + titulo + '\'' +
      ", momento='" + momento + '\'' +
      ", estado='" + estado + '\'' +
      ", idcircuito=" + idcircuito +
      '}';
  }
}
