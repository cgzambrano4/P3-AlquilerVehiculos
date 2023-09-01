package com.espe.alquiler.controller;

import com.espe.alquiler.dao.IUsuariosDAO;
import com.espe.alquiler.idao.UsuariosDAOImpl;
import com.espe.alquiler.model.Usuarios;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class UsuariosBean implements Serializable {
    String username;
    String password;
    Usuarios loggedInUser;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        IUsuariosDAO usuariosDAO = new UsuariosDAOImpl();
        Usuarios usuario = usuariosDAO.buscarUsuarioPorUsernamePassword(username, password);

        if (usuario != null) {
            loggedInUser = usuario;
            usuariosDAO.obtenerUsuarios(); // Añade esto para listar los usuarios por consola
            return "dashboard.xhtml?faces-redirect=true";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales inválidas"));
            return null;
        }
    }

    public String logout() {
        loggedInUser = null;
        return "/index.xhtml?faces-redirect=true";
    }

    public boolean isLoggedIn() {
        return loggedInUser != null;
    }
}
