package com.school.circuits.entities;


import javax.persistence.*;

@Entity
@Table(name = "tab_funciones_especiales")
public class Functions {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer idfuncEsp;

  private String enlace;
  private String voceroCe;
  private Integer idpersona;

  public Functions() {

  }

  public Integer getIdfuncEsp() {
    return idfuncEsp;
  }

  public void setIdfuncEsp(Integer idfuncEsp) {
    this.idfuncEsp = idfuncEsp;
  }

  public String getEnlace() {
    return enlace;
  }

  public void setEnlace(String enlace) {
    this.enlace = enlace;
  }

  public String getVoceroCe() {
    return voceroCe;
  }

  public void setVoceroCe(String voceroCe) {
    this.voceroCe = voceroCe;
  }

  public Integer getIdpersona() {
    return idpersona;
  }

  public void setIdpersona(Integer idpersona) {
    this.idpersona = idpersona;
  }

  @Override
  public String toString() {
    return "Functions{" +
      "idfuncEsp=" + idfuncEsp +
      ", enlace='" + enlace + '\'' +
      ", voceroCe='" + voceroCe + '\'' +
      ", idpersona=" + idpersona +
      '}';
  }
}
