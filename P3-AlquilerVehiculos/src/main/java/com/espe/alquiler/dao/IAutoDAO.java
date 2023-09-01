package com.espe.alquiler.dao;

import com.espe.alquiler.model.Auto;

import java.util.List;

public interface IAutoDAO {
    void guardar(Auto auto);

    void editar(Auto auto);

    Auto buscar(int id);

    List<Auto> obtenerAuto();

    void eliminar(int id);
}


