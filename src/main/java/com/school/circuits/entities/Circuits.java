package com.school.circuits.entities;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Map;

@Entity
@Table(name = "mst_circuitoseducativos")
public class Circuits {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idcircuito;

    private Integer nro;
    private String nombrecircuital;
    private String codigoCircuital;
    private String lema;
    private String puntoycirculo;
    private Integer nroplanteles;
    private String imagenGeoref;
    private String estado;
    private String municipio;
    private String parroquia;

    public Circuits(){}

    public Circuits(Integer nro, String nombrecircuital, String codigoCircuital, String lema, String puntoycirculo, Integer nroplanteles, String estado, String municipio, String parroquia,String imagenGeoref) {
        this.nro = nro;
        this.nombrecircuital = nombrecircuital;
        this.codigoCircuital = codigoCircuital;
        this.lema = lema;
        this.puntoycirculo = puntoycirculo;
        this.nroplanteles = nroplanteles;
        this.estado = estado;
        this.municipio = municipio;
        this.parroquia = parroquia;
        this.imagenGeoref = imagenGeoref;
    }

    public Circuits(Integer idcircuito, Integer nro, String nombrecircuital, String codigoCircuital, String lema, String puntoycirculo, Integer nroplanteles, String estado, String municipio, String parroquia,String imagenGeoref) {
        this.idcircuito = idcircuito;
        this.nro = nro;
        this.nombrecircuital = nombrecircuital;
        this.codigoCircuital = codigoCircuital;
        this.lema = lema;
        this.puntoycirculo = puntoycirculo;
        this.nroplanteles = nroplanteles;
        this.estado = estado;
        this.municipio = municipio;
        this.parroquia = parroquia;
        this.imagenGeoref = imagenGeoref;
    }

    public Integer getIdcircuito() {
        return idcircuito;
    }

    public void setIdcircuito(Integer idcircuito) {
        this.idcircuito = idcircuito;
    }

    public Integer getNro() {
        return nro;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }

    public String getNombrecircuital() {
        return nombrecircuital;
    }

    public void setNombrecircuital(String nombrecircuital) {
        this.nombrecircuital = nombrecircuital;
    }

    public String getCodigoCircuital() {
        return codigoCircuital;
    }

    public void setCodigoCircuital(String codigoCircuital) {
        this.codigoCircuital = codigoCircuital;
    }

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public String getPuntoycirculo() {
        return puntoycirculo;
    }

    public void setPuntoycirculo(String puntoycirculo) {
        this.puntoycirculo = puntoycirculo;
    }

    public Integer getNroplanteles() {
        return nroplanteles;
    }

    public void setNroplanteles(Integer nroplanteles) {
        this.nroplanteles = nroplanteles;
    }

    public String getImagenGeoref() {
        return imagenGeoref;
    }

    public void setImagenGeoref(String imagenGeoref) {
        this.imagenGeoref = imagenGeoref;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    @Override
    public String toString() {
        return "Circuits{" +
                "idcircuito=" + idcircuito +
                ", nro=" + nro +
                ", nombrecircuital='" + nombrecircuital + '\'' +
                ", codigoCircuital='" + codigoCircuital + '\'' +
                ", lema='" + lema + '\'' +
                ", puntoycirculo='" + puntoycirculo + '\'' +
                ", nroplanteles=" + nroplanteles +
                ", imagenGeoref=" + imagenGeoref +
                ", estado='" + estado + '\'' +
                ", municipio='" + municipio + '\'' +
                ", parroquia='" + parroquia + '\'' +
                '}';
    }
}
