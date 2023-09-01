package com.espe.alquiler.dao;

import com.espe.alquiler.model.Empleado;

import java.util.List;

public interface IEmpleadoDao {
    void guardar(Empleado empleado);
    void editar(Empleado empleado);
    Empleado buscar(int id);
    List<Empleado> obtenerEmpleados();
    void eliminar(int id);
}
