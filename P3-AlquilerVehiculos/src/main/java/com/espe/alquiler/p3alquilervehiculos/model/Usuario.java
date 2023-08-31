package com.espe.cz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario") //nombre que esta en la base de datos
public class Usuario {
    //Creación de los atributos - paso 1.1
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para generar automaticamente
    private Integer idusuario;

    @Column
    private String nombreusuario;

    @Column
    private String cedulausuario;

    @Column
    private String telefonousuario;

    @Column
    private String emailusuario;

    @Column
    private String direccionusuario;

    //Metodos getters and setter
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

    public String getCedulausuario() {
        return cedulausuario;
    }

    public void setCedulausuario(String cedulausuario) {
        this.cedulausuario = cedulausuario;
    }

    public String getTelefonousuario() {
        return telefonousuario;
    }

    public void setTelefonousuario(String telefonousuario) {
        this.telefonousuario = telefonousuario;
    }

    public String getEmailusuario() {
        return emailusuario;
    }

    public void setEmailusuario(String emailusuario) {
        this.emailusuario = emailusuario;
    }

    public String getDireccionusuario() {
        return direccionusuario;
    }

    public void setDireccionusuario(String direccionusuario) {
        this.direccionusuario = direccionusuario;
    }

    //toString()
    @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idusuario +
                ", nombreusuario='" + nombreusuario + '\'' +
                ", cedulausuario='" + cedulausuario + '\'' +
                ", telefonousuario='" + telefonousuario + '\'' +
                ", emailusuario='" + emailusuario + '\'' +
                ", direccionusuario='" + direccionusuario + '\'' +
                '}';
    }
}
