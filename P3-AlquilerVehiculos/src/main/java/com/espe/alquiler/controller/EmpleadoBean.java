package com.espe.alquiler.controller;

//agregado hoy

import com.espe.alquiler.dao.IEmpleadoDao;
import com.espe.alquiler.idao.EmpleadoDaoImpl;
import com.espe.alquiler.model.Empleado;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;
import java.util.Map;

@RequestScoped
@Named
public class EmpleadoBean {
    IEmpleadoDao empleadoDao = new EmpleadoDaoImpl();

    public List<Empleado> obtenerEmpleados() {
        return empleadoDao.obtenerEmpleados();
    }

    public String index(){

        return "/indexEmpleado.xhtml";
    }

    //Agregado hoy
    public String editar(int id) {
        Empleado empleado;
        empleado = empleadoDao.buscar(id);
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("empleado", empleado);
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

    public String nuevo() {
        Empleado oEmpleado = new Empleado();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("empleado", oEmpleado);
        return "/nuevoEmpleado.xhtml";
    }

    //agregado
    public String guardar(Empleado empleado) {
        empleadoDao.guardar(empleado);
        return "/indexEmpleado.xhtml";
    }
}