package com.school.circuits.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tab_carteleras")
public class Events {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer idcartelera;

  private String titulo;
  private String contenido;
  private String imagen;
  private Date fechaEvento;
  private Integer idcircuito;

  public Events(){}

  public Integer getIdcartelera() {
    return idcartelera;
  }

  public void setIdcartelera(Integer idcartelera) {
    this.idcartelera = idcartelera;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getContenido() {
    return contenido;
  }

  public void setContenido(String contenido) {
    this.contenido = contenido;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public Integer getIdcircuito() {
    return idcircuito;
  }

  public void setIdcircuito(Integer idcircuito) {
    this.idcircuito = idcircuito;
  }

  public Date getFechaEvento() {
    return fechaEvento;
  }

  public void setFechaEvento(Date fechaEvento) {
    this.fechaEvento = fechaEvento;
  }

  @Override
  public String toString() {
    return "Events{" +
      "idcartelera=" + idcartelera +
      ", titulo='" + titulo + '\'' +
      ", contenido='" + contenido + '\'' +
      ", imagen='" + imagen + '\'' +
      ", fechaEvento=" + fechaEvento +
      ", idcircuito=" + idcircuito +
      '}';
  }
}
