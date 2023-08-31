package com.espe.alquiler.dao;

import com.espe.alquiler.model.Empleado;

import java.util.List;

//Creado - paso 3.1
public interface IEmpleadoDao {
    //funciones CRUD
    void guardar(Empleado empleado);
    void editar(Empleado empleado);
    Empleado buscar(int id);
    List<Empleado> obtenerEmpleados();

    //agregado
    void eliminar(int id);
}
