package com.espe.alquiler.p3alquilervehiculos.Facturas.Controller;


import com.espe.alquiler.p3alquilervehiculos.Facturas.Dao.IFactruraDao;
import com.espe.alquiler.p3alquilervehiculos.Facturas.Idao.FacturaDaoImpl;
import com.espe.alquiler.p3alquilervehiculos.Facturas.Modelo.*;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


@RequestScoped
@Named
public class FacturaBean implements Serializable {

    IFactruraDao facturaDao = new FacturaDaoImpl();

    private Facturas facturas = new Facturas(); // Agregamos una instancia de Facturas



    public String nuevo() {
        Facturas factura = new Facturas();
        Map<String, Object> sessionMap = jakarta.faces.context.FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("factura", factura);
        return "/registroFactura.xhtml";
    }

    public String crear( Facturas factura) {

        Float totalAlquiler =
                ((factura.getFechaDevolucion().getTime() - factura.getFechaAlquiler().getTime()) /
                        (1000 * 60 * 60 * 24) + 1) * factura.getPrecioAlquilerDia() -
                        factura.getAbonoAlquiler();
        factura.setTotalAlquiler(totalAlquiler);
        facturaDao.guardarFactura(factura);
        return "/index.xhtml";
    }


    public List<Facturas> obtenerFacturas() {
        return facturaDao.obtenerFacturas(); // Asegúrate de que esta línea funcione correctamente
    }


    //Actualizar

    public String editar(int id){

        Facturas oFacturas;
        oFacturas = facturaDao.buscarPorId(id);

        //crear una coleccion de tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("factura", oFacturas);
        System.out.println(oFacturas);
        return "/actualizarFactura.xhtml";
    }

    public String actualizar(Facturas facturas) {

        Float totalAlquiler =
                ((facturas.getFechaDevolucion().getTime() - facturas.getFechaAlquiler().getTime()) /
                        (1000 * 60 * 60 * 24) + 1) * facturas.getPrecioAlquilerDia() -
                        facturas.getAbonoAlquiler();
        facturas.setTotalAlquiler(totalAlquiler);

        facturaDao.editar(facturas);
        return "/index.xhtml";
    }
    public String eliminar(int id){
        facturaDao.eliminar(id);
        return "/index.xhtml";

    }

    public Facturas obtenerFacturaPorId(int id) {
        // Utilizar el materiaDAO para buscar y devolver la materia correspondiente
        return facturaDao.buscarPorId(id);
    }


}
