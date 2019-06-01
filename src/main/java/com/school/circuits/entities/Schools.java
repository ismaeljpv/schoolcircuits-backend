package com.school.circuits.entities;


import javax.persistence.*;
import java.sql.Blob;
import java.time.Year;

@Entity
@Table(name = "mst_planteles")
public class Schools {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idplantel;

    private String plantel;
    private String rif;
    private String codigoAdmin;
    private String codigoElectoral;
    private String codigoEstadistico;
    private String codigoDea;
    private String direccion;
    private String peicLema;
    private String anoFundacion;
    private String consejoEduc;
    private String centroVotacion;
    private String sige;
    private String georefLatitud;
    private String georefLongitud;
    private String logo;
    private String observaciones;
    private String dependencias;
    private String niveles;
    private String condInmueble;
    private Integer idcircuito;

    public Schools(){}

    public Integer getIdplantel() {
        return idplantel;
    }

    public void setIdplantel(Integer idplantel) {
        this.idplantel = idplantel;
    }

    public String getPlantel() {
        return plantel;
    }

    public void setPlantel(String plantel) {
        this.plantel = plantel;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getCodigoAdmin() {
        return codigoAdmin;
    }

    public void setCodigoAdmin(String codigoAdmin) {
        this.codigoAdmin = codigoAdmin;
    }

    public String getCodigoElectoral() {
        return codigoElectoral;
    }

    public void setCodigoElectoral(String codigoElectoral) {
        this.codigoElectoral = codigoElectoral;
    }

    public String getCodigoEstadistico() {
        return codigoEstadistico;
    }

    public void setCodigoEstadistico(String codigoEstadistico) {
        this.codigoEstadistico = codigoEstadistico;
    }

    public String getCodigoDea() {
        return codigoDea;
    }

    public void setCodigoDea(String codigoDea) {
        this.codigoDea = codigoDea;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPeicLema() {
        return peicLema;
    }

    public void setPeicLema(String peicLema) {
        this.peicLema = peicLema;
    }

    public String getAnoFundacion() {
        return anoFundacion;
    }

    public void setAnoFundacion(String anoFundacion) {
        this.anoFundacion = anoFundacion;
    }

    public String getConsejoEduc() {
        return consejoEduc;
    }

    public void setConsejoEduc(String consejoEduc) {
        this.consejoEduc = consejoEduc;
    }

    public String getCentroVotacion() {
        return centroVotacion;
    }

    public void setCentroVotacion(String centroVotacion) {
        this.centroVotacion = centroVotacion;
    }

    public String getSige() {
        return sige;
    }

    public void setSige(String sige) {
        this.sige = sige;
    }

    public String getGeorefLatitud() {
        return georefLatitud;
    }

    public void setGeorefLatitud(String georefLatitud) {
        this.georefLatitud = georefLatitud;
    }

    public String getGeorefLongitud() {
        return georefLongitud;
    }

    public void setGeorefLongitud(String georefLongitud) {
        this.georefLongitud = georefLongitud;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDependencias() {
        return dependencias;
    }

    public void setDependencias(String dependencias) {
        this.dependencias = dependencias;
    }

    public String getNiveles() {
        return niveles;
    }

    public void setNiveles(String niveles) {
        this.niveles = niveles;
    }

    public String getCondInmueble() {
        return condInmueble;
    }

    public void setCondInmueble(String condInmueble) {
        this.condInmueble = condInmueble;
    }

    public Integer getIdcircuito() {
        return idcircuito;
    }

    public void setIdcircuito(Integer idcircuito) {
        this.idcircuito = idcircuito;
    }

    @Override
    public String toString() {
        return "Schools{" +
                "idplantel=" + idplantel +
                ", plantel='" + plantel + '\'' +
                ", rif='" + rif + '\'' +
                ", codigoAdmin='" + codigoAdmin + '\'' +
                ", codigoElectoral='" + codigoElectoral + '\'' +
                ", codigoEstadistico='" + codigoEstadistico + '\'' +
                ", codigoDea='" + codigoDea + '\'' +
                ", direccion='" + direccion + '\'' +
                ", peicLema='" + peicLema + '\'' +
                ", anoFundacion=" + anoFundacion +
                ", consejoEduc='" + consejoEduc + '\'' +
                ", centroVotacion='" + centroVotacion + '\'' +
                ", sige='" + sige + '\'' +
                ", georefLatitud='" + georefLatitud + '\'' +
                ", georefLongitud='" + georefLongitud + '\'' +
                ", logo=" + logo +
                ", observaciones='" + observaciones + '\'' +
                ", dependencias='" + dependencias + '\'' +
                ", niveles='" + niveles + '\'' +
                ", condInmueble='" + condInmueble + '\'' +
                ", idcircuito=" + idcircuito +
                '}';
    }
}
