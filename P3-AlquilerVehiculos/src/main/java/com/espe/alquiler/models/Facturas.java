package com.espe.alquiler.p3alquilervehiculos.Facturas.Modelo;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="facturas")
public class Facturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "Id_Facturas")
    private Integer Id_Facturas;

    @Column(name = "Id_Empleados")
    private Long Id_Empleados;

    @Column(name = "Id_Vehiculos")
    private Long idVehiculos;
    @Column
    private String NombreCliente;
    @Column
    private String CedulaCliente;
    @Column
    private String DireccionCliente;
    @Column
    private String TelefonoCliente;
    @Column
    private Date FechaAlquiler;
    @Column
    private Date FechaDevolucion;
    @Column
    private Float PrecioAlquilerDia;
    @Column
    private Float AbonoAlquiler;
    @Column
    private Float TotalAlquiler;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    // Método para formatear la fecha antes de guardarla en la base de datos
    public String getFormattedFechaAlquiler() {
        if (FechaAlquiler != null) {
            return DATE_FORMAT.format(FechaAlquiler);
        }
        return null;
    }

    // Método para establecer la fecha después de recuperarla de la base de datos
    public void setFormattedFechaAlquiler(String formattedFechaAlquiler) {
        try {
            FechaAlquiler = DATE_FORMAT.parse(formattedFechaAlquiler);
        } catch (ParseException e) {
            // Manejar la excepción en caso de un formato de fecha incorrecto
            e.printStackTrace();
        }
    }

    public String getFormattedFechaDevolucion() {
        if (FechaDevolucion != null) {
            return DATE_FORMAT.format(FechaDevolucion);
        }
        return null;
    }

    // Método para establecer la fecha después de recuperarla de la base de datos
    public void setFormattedFechaDevolucion(String formattedFechaAlquiler) {
        try {
            FechaDevolucion = DATE_FORMAT.parse(formattedFechaAlquiler);
        } catch (ParseException e) {
            // Manejar la excepción en caso de un formato de fecha incorrecto
            e.printStackTrace();
        }
    }
    public Long getId_Empleados() {
        return Id_Empleados;
    }

    public void setId_Empleados(Long id_Empleados) {
        Id_Empleados = id_Empleados;
    }

    public Long getIdVehiculos() {
        return idVehiculos;
    }

    public void setIdVehiculos(Long idVehiculos) {
        this.idVehiculos = idVehiculos;
    }

    public Integer getId_Facturas() {
        return Id_Facturas;
    }

    public void setId_Facturas(Integer id_Facturas) {
        Id_Facturas = id_Facturas;
    }


    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }

    public String getCedulaCliente() {
        return CedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        CedulaCliente = cedulaCliente;
    }

    public String getDireccionCliente() {
        return DireccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        DireccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return TelefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        TelefonoCliente = telefonoCliente;
    }

    public Date getFechaAlquiler() {
        return FechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        FechaAlquiler = fechaAlquiler;
    }

    public Date getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        FechaDevolucion = fechaDevolucion;
    }

    public Float getPrecioAlquilerDia() {
        return PrecioAlquilerDia;
    }

    public void setPrecioAlquilerDia(Float precioAlquilerDia) {
        PrecioAlquilerDia = precioAlquilerDia;
    }

    public Float getAbonoAlquiler() {
        return AbonoAlquiler;
    }

    public void setAbonoAlquiler(Float abonoAlquiler) {
        AbonoAlquiler = abonoAlquiler;
    }

    public Float getTotalAlquiler() {
        return TotalAlquiler;
    }

    public void setTotalAlquiler(Float totalAlquiler) {
        TotalAlquiler = totalAlquiler;
    }

}
