package com.espe.alquiler.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados") //nombre que esta en la base de datos
public class Empleado {
    //Creación de los atributos - paso 1.1
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para generar automaticamente
    private Integer Id_Empleados;

    @Column
    private String Nombres;

    @Column
    private String Apellidos;

    @Column
    private String Direccion;

    @Column
    private String Telefono;

    @Column
    private String CorreoElectronico;
    @Column
    private String FechaContrato;

    public Integer getId_Empleados() {
        return Id_Empleados;
    }

    public void setId_Empleados(Integer id_Empleados) {
        Id_Empleados = id_Empleados;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        CorreoElectronico = correoElectronico;
    }

    public String getFechaContrato() {
        return FechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        FechaContrato = fechaContrato;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Empleado{" +
                "Id_Empleados=" + Id_Empleados +
                ", Nombres='" + Nombres + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", CorreoElectronico='" + CorreoElectronico + '\'' +
                ", FechaContrato='" + FechaContrato + '\'' +
                '}';
    }
}
