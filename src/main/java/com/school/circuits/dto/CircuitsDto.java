package com.school.circuits.dto;

import com.school.circuits.entities.Circuits;

public class CircuitsDto {
    private Integer idcircuito;

    private Integer nro;
    private String nombrecircuital;

    public CircuitsDto() {
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

    @Override
    public String toString() {
        return "CircuitsDto{" +
                "idcircuito=" + idcircuito +
                ", nro=" + nro +
                ", nombrecircuital='" + nombrecircuital + '\'' +
                '}';
    }
}
