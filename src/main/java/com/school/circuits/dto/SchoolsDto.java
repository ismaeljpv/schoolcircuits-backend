package com.school.circuits.dto;

import java.sql.Blob;

public class SchoolsDto {

    private Integer idplantel;
    private String plantel;
    private String codigoAdmin;
    private String anoFundacion;
    private String georefLatitud;
    private String georefLongitud;
    private Integer idcircuito;
    private String direccion;
    private String codigoEstadistico;
    private String sige;


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

    public String getCodigoAdmin() {
        return codigoAdmin;
    }

    public void setCodigoAdmin(String codigoAdmin) {
        this.codigoAdmin = codigoAdmin;
    }

    public String getAnoFundacion() {
        return anoFundacion;
    }

    public void setAnoFundacion(String anoFundacion) {
        this.anoFundacion = anoFundacion;
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

    public Integer getIdcircuito() {
        return idcircuito;
    }

    public void setIdcircuito(Integer idcircuito) {
        this.idcircuito = idcircuito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoEstadistico() {
        return codigoEstadistico;
    }

    public void setCodigoEstadistico(String codigoEstadistico) {
        this.codigoEstadistico = codigoEstadistico;
    }

    public String getSige() {
        return sige;
    }

    public void setSige(String sige) {
        this.sige = sige;
    }


    @Override
    public String toString() {
        return "SchoolsDto{" +
                "idplantel=" + idplantel +
                ", plantel='" + plantel + '\'' +
                ", codigoAdmin='" + codigoAdmin + '\'' +
                ", anoFundacion='" + anoFundacion + '\'' +
                ", georefLatitud='" + georefLatitud + '\'' +
                ", georefLongitud='" + georefLongitud + '\'' +
                ", idcircuito=" + idcircuito +
                ", direccion='" + direccion + '\'' +
                ", codigoEstadistico='" + codigoEstadistico + '\'' +
                ", sige='" + sige + '\'' +
                '}';
    }
}
