package com.school.circuits.dto;

import javax.persistence.Id;
import java.util.Date;

public class PersonDto {

    @Id
    private Integer idpersona;

    private String cedula;
    private char nacionalidad;
    private String sexo;
    private String apellido1;
    private String nombre1;
    private String correoPersona;
    private String direccion;
    private Date fNacimiento;
    private Date fIngreso;
    private String nivelAcadem;
    private String cargoNominal;
    private String observaciones;
    private Integer idPlantel;
    private String estatus;
    private String cargoFuncion;

    public PersonDto(){}

    public Integer getIdpersona() {
        return idpersona;
    }

    public PersonDto(Integer idpersona, String cedula, char nacionalidad, String sexo, String apellido1, String nombre1, String correoPersona, String direccion, Date fNacimiento, Date fIngreso, String nivelAcadem, String cargoNominal, String observaciones, Integer idPlantel) {
        this.idpersona = idpersona;
        this.cedula = cedula;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.apellido1 = apellido1;
        this.nombre1 = nombre1;
        this.correoPersona = correoPersona;
        this.direccion = direccion;
        this.fNacimiento = fNacimiento;
        this.fIngreso = fIngreso;
        this.nivelAcadem = nivelAcadem;
        this.cargoNominal = cargoNominal;
        this.observaciones = observaciones;
        this.idPlantel = idPlantel;
    }

    public PersonDto(Integer idpersona, String cedula, char nacionalidad, String apellido1, String nombre1) {
        this.idpersona = idpersona;
        this.cedula = cedula;
        this.nacionalidad = nacionalidad;
        this.apellido1 = apellido1;
        this.nombre1 = nombre1;
    }


    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public char getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(char nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getCorreoPersona() {
        return correoPersona;
    }

    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public Date getfIngreso() {
        return fIngreso;
    }

    public void setfIngreso(Date fIngreso) {
        this.fIngreso = fIngreso;
    }

    public String getNivelAcadem() {
        return nivelAcadem;
    }

    public void setNivelAcadem(String nivelAcadem) {
        this.nivelAcadem = nivelAcadem;
    }

    public String getCargoNominal() {
        return cargoNominal;
    }

    public void setCargoNominal(String cargoNominal) {
        this.cargoNominal = cargoNominal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getIdPlantel() {
        return idPlantel;
    }

    public void setIdPlantel(Integer idPlantel) {
        this.idPlantel = idPlantel;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getCargoFuncion() {
        return cargoFuncion;
    }

    public void setCargoFuncion(String cargoFuncion) {
        this.cargoFuncion = cargoFuncion;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "idpersona=" + idpersona +
                ", cedula='" + cedula + '\'' +
                ", nacionalidad=" + nacionalidad +
                ", sexo='" + sexo + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", nombre1='" + nombre1 + '\'' +
                ", correoPersona='" + correoPersona + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fNacimiento=" + fNacimiento +
                ", fIngreso=" + fIngreso +
                ", nivelAcadem='" + nivelAcadem + '\'' +
                ", cargoNominal='" + cargoNominal + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", estatus='" + estatus + '\'' +
                ", cargoFuncion='" + cargoFuncion + '\'' +
                ", idPlantel=" + idPlantel +
                '}';
    }
}
