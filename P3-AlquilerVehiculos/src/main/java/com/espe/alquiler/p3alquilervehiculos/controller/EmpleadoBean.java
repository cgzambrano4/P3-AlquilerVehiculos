package com.espe.alquiler.controller;

//agregado hoy

import com.espe.alquiler.dao.IEmpleadoDao;
import com.espe.alquiler.idao.EmpleadoDaoImpl;
import com.espe.alquiler.model.Empleado;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestScoped
@Named
public class EmpleadoBean {
    //prueba para pasar datos quemados a la vista
    IEmpleadoDao empleadoDao = new EmpleadoDaoImpl();

    public List<Empleado> obtenerEmpleados() {


        //INstanciar objetos para no usar los datos quemados
        return empleadoDao.obtenerEmpleados();
    }

    //Agregado hoy
    public String editar(int id) {

        Empleado oEmpleado;
        oEmpleado = empleadoDao.buscar(id);

        //crear una coleccion tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del sessionMap hacia la vista
        sessionMap.put("empleado", oEmpleado);
        System.out.println(oEmpleado);
        return "/editarEmpleado.xhtml";
    }

    //Agregado hoy
    public String actualizar(Empleado empleado) {
        empleadoDao.editar(empleado);
        return "/indexEmpleado.xhtml";
    }

    //agregado
    public String eliminar(int id) {
        empleadoDao.eliminar(id);
        return "/indexEmpleado.xhtml";
    }

    //agregado
    public String nuevo() {
        Empleado oEmpleado = new Empleado();
        //crear una coleccion tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del sessionMap hacia la vista
        sessionMap.put("empleado", oEmpleado);
        System.out.println(oEmpleado);
        return "/nuevoEmpleado.xhtml";
    }

    //agregado
    public String guardar(Empleado empleado) {
        empleadoDao.guardar(empleado);
        return "/indexEmpleado.xhtml";
    }
}