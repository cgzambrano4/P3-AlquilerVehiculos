package com.espe.alquiler.dao;

import com.espe.alquiler.model.Usuarios;

import java.util.List;

public interface IUsuariosDAO {
    void guardar(Usuarios usuarios);
    void editar(Usuarios usuarios);
    Usuarios buscar(int id);
    Usuarios buscarUsuarioPorUsernamePassword(String username, String password);
    List<Usuarios> obtenerUsuarios();
    void eliminar(int id);
}
