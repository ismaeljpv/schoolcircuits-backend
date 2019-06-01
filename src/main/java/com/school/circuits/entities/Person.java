package com.school.circuits.entities;


import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "mst_personal")
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idpersona;

    private String cedula;
    private char nacionalidad;
    private String sexo;
    private String apellido2;
    private String apellido1;
    private String nombre1;
    private String nombre2;
    private String correoPersona;
    private String direccion;
    private String telefono;
    private Date fNacimiento;
    private Date fIngreso;
    private String nivelAcadem;
    private String cargoNominal;
    private String cargoFuncion;
    private String estatus;
    private String supervisor;
    private String foto;
    private String observaciones;
    private String digitosCuenta;
    private String carnetpSerial;
    private String carnetpCodigo;
    private Date createAt;
    private Date updateAt;

    private Integer idplantel;
    private Integer idcircuito;

    public Person(){}

    public Integer getIdpersona() {
        return idpersona;
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

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
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

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
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

    public String getCargoFuncion() {
        return cargoFuncion;
    }

    public void setCargoFuncion(String cargoFuncion) {
        this.cargoFuncion = cargoFuncion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDigitosCuenta() {
        return digitosCuenta;
    }

    public void setDigitosCuenta(String digitosCuenta) {
        this.digitosCuenta = digitosCuenta;
    }

    public String getCarnetpSerial() {
        return carnetpSerial;
    }

    public void setCarnetpSerial(String carnetpSerial) {
        this.carnetpSerial = carnetpSerial;
    }

    public String getCarnetpCodigo() {
        return carnetpCodigo;
    }

    public void setCarnetpCodigo(String carnetpCodigo) {
        this.carnetpCodigo = carnetpCodigo;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getIdplantel() {
        return idplantel;
    }

    public void setIdplantel(Integer idPlantel) {
        this.idplantel = idPlantel;
    }

    public Integer getIdcircuito() {
        return idcircuito;
    }

    public void setIdcircuito(Integer idCircuito) {
        this.idcircuito = idCircuito;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idpersona=" + idpersona +
                ", cedula='" + cedula + '\'' +
                ", nacionalidad=" + nacionalidad +
                ", sexo=" + sexo +
                ", apellido2='" + apellido2 + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", nombre1='" + nombre1 + '\'' +
                ", nombre2='" + nombre2 + '\'' +
                ", correoPersona='" + correoPersona + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fNacimiento=" + fNacimiento +
                ", fIngreso=" + fIngreso +
                ", nivelAcadem='" + nivelAcadem + '\'' +
                ", cargoNominal='" + cargoNominal + '\'' +
                ", cargoFuncion='" + cargoFuncion + '\'' +
                ", estatus='" + estatus + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", foto=" + foto +
                ", observaciones='" + observaciones + '\'' +
                ", digitosCuenta='" + digitosCuenta + '\'' +
                ", carnetpSerial='" + carnetpSerial + '\'' +
                ", carnetpCodigo='" + carnetpCodigo + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", idPlantel=" + idplantel +
                ", idcircuito=" + idcircuito +
                '}';
    }
}
