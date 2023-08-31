package com.espe.cz.controller;

//agregado hoy

import com.espe.cz.dao.IUsuarioDao;
import com.espe.cz.idao.UsuarioDaoImpl;
import com.espe.cz.model.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestScoped
@Named
public class UsuarioBean {
    //prueba para pasar datos quemados a la vista
    IUsuarioDao usuarioDao = new UsuarioDaoImpl();

    public List<Usuario> obtenerUsuarios() {
        /*
        List<Usuario> listaUsuarios = new ArrayList<>();

        Usuario u1 = new Usuario();
        u1.setIdusuario(1);
        u1.setNombreusuario("César Zambrano");
        u1.setCedulausuario("2300042922");
        u1.setTelefonousuario("0939581046");
        u1.setEmailusuario("cgzambrano4@espe.edu.ec");
        u1.setDireccionusuario("Chigüilpe");

        Usuario u2 = new Usuario();
        u2.setIdusuario(2);
        u2.setNombreusuario("Marcos Zambrano");
        u2.setCedulausuario("1306398429");
        u2.setTelefonousuario("022915000");
        u2.setEmailusuario("mgzambrano5@espe.edu.ec");
        u2.setDireccionusuario("Chigüilpe");

        listaUsuarios.add(u1);
        listaUsuarios.add(u2);

        return listaUsuarios;
     */

        //INstanciar objetos para no usar los datos quemados
        return usuarioDao.obtenerUsuarios();
    }

    //Agregado hoy
    public String editar(int id) {

        Usuario oUsuario;
        oUsuario = usuarioDao.buscar(id);

        //crear una coleccion tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del sessionMap hacia la vista
        sessionMap.put("usuario", oUsuario);
        System.out.println(oUsuario);
        return "/editar.xhtml";
    }

    //Agregado hoy
    public String actualizar(Usuario usuario) {
        usuarioDao.editar(usuario);
        return "/index.xhtml";
    }

    //agregado
    public String eliminar(int id) {
        usuarioDao.eliminar(id);
        return "/index.xhtml";
    }

    //agregado
    public String nuevo() {
        Usuario oUsuario = new Usuario();
        //crear una coleccion tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del sessionMap hacia la vista
        sessionMap.put("usuario", oUsuario);
        System.out.println(oUsuario);
        return "/nuevo.xhtml";
    }

    //agregado
    public String guardar(Usuario usuario) {
        usuarioDao.guardar(usuario);
        return "/index.xhtml";
    }
}