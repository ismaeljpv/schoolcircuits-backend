package com.school.circuits.dto;

import javax.persistence.Id;

public class UserDto {

    @Id
    private Integer idusuario;

    private String nombreusuario;
    private String correo;
    private Integer idpersona;
    private String perfil;

    public UserDto() {
    }

    public UserDto(Integer idusuario, String nombreusuario, String correo, Integer idpersona, String perfil) {
        this.idusuario = idusuario;
        this.nombreusuario = nombreusuario;
        this.correo = correo;
        this.idpersona = idpersona;
        this.perfil = perfil;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "idusuario=" + idusuario +
                ", nombreusuario='" + nombreusuario + '\'' +
                ", correo='" + correo + '\'' +
                ", idpersona=" + idpersona +
                ", perfil=" + perfil +
                '}';
    }
}
