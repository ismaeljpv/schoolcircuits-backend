package com.school.circuits.entities;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtProcessing;
import java.util.Date;

@Entity
@Table(name = "mst_usuarios")
public class Users {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idusuario;


    private String nombreusuario;
    private String correo;
    private String clave;
    private Date createAt;
    private Date updateAt;
    private String perfil;
    private Integer idpersona;


    public Users(){}

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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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


    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    @Override
    public String toString() {
        return "Users{" +
                "idusuario=" + idusuario +
                ", nombreusuario='" + nombreusuario + '\'' +
                ", correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", perfil='" + perfil + '\'' +
                ", idpersona=" + idpersona +
                '}';
    }
}
