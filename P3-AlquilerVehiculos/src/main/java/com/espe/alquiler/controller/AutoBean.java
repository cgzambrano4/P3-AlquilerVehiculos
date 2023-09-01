package com.espe.alquiler.controller;

import com.espe.alquiler.dao.IAutoDAO;
import com.espe.alquiler.idao.AutoDAOImpl;
import com.espe.alquiler.model.Auto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;
import java.util.Map;


@RequestScoped
@Named
public class AutoBean {


    IAutoDAO autoDAO = new AutoDAOImpl();
    // Prueba para pasar datos a la vista
    public List<Auto> obtenerAuto(){
        return autoDAO.obtenerAuto();
    }


    public String index(){
        return "/indexAuto.xhtml";
    }

    public String editar (int id){
        Auto auto;
        auto = autoDAO.buscar(id);
        // Crear una coleccion de tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        // Pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("auto", auto);
        System.out.println(auto);
        return "/editarAuto.xhtml";
    }

    public String actualizar(Auto auto) {
        autoDAO.editar(auto);
        return "/indexAuto.xhtml";
    }

    public String eliminar(int id) {
        autoDAO.eliminar(id);
        return "/indexAuto.xhtml";
    }

    public String nuevo() {
        Auto oAuto = new Auto();
        // Crear una colección de tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        // Pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("auto", oAuto);
        return "/nuevoAuto.xhtml";
    }

    public String guardar(Auto auto){
        autoDAO.guardar(auto);
        return "/indexAuto.xhtml";
    }
}
