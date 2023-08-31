package com.espe.cz.dao;

import com.espe.cz.model.Usuario;

import java.util.List;

//Creado - paso 3.1
public interface IUsuarioDao {
    //funciones CRUD
    void guardar(Usuario usuario);
    void editar(Usuario usuario);
    Usuario buscar(int id);
    List<Usuario> obtenerUsuarios();

    //agregado
    void eliminar(int id);
}
