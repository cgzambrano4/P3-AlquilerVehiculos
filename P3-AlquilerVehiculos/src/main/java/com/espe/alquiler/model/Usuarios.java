package com.espe.alquiler.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Usuarios")
    private int id_Usuarios;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;

    public int getId_Usuarios() {
        return id_Usuarios;
    }

    public void setId_Usuarios(int id_Usuarios) {
        this.id_Usuarios = id_Usuarios;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id_Usuarios=" + id_Usuarios +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
