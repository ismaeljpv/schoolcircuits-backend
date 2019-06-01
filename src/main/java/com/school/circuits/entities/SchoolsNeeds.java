package com.school.circuits.entities;


import javax.persistence.*;

@Entity
@Table(name = "tab_p_necesidades")
public class SchoolsNeeds {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer idplantelnec;

  private String causa;
  private String situacionactual;
  private Integer idplantel;
  private Integer idpersona;

  public SchoolsNeeds(){}

  public Integer getIdplantelnec() {
    return idplantelnec;
  }

  public void setIdplantelnec(Integer idplantelnec) {
    this.idplantelnec = idplantelnec;
  }

  public String getCausa() {
    return causa;
  }

  public void setCausa(String causa) {
    this.causa = causa;
  }

  public String getSituacionactual() {
    return situacionactual;
  }

  public void setSituacionactual(String situacionactual) {
    this.situacionactual = situacionactual;
  }

  public Integer getIdplantel() {
    return idplantel;
  }

  public void setIdplantel(Integer idplantel) {
    this.idplantel = idplantel;
  }

  public Integer getIdpersona() {
    return idpersona;
  }

  public void setIdpersona(Integer idpersona) {
    this.idpersona = idpersona;
  }

  @Override
  public String toString() {
    return "SchoolsNeeds{" +
      "idplantelnec=" + idplantelnec +
      ", causa='" + causa + '\'' +
      ", situacionactual='" + situacionactual + '\'' +
      ", idplantel=" + idplantel +
      ", idpersona=" + idpersona +
      '}';
  }
}
