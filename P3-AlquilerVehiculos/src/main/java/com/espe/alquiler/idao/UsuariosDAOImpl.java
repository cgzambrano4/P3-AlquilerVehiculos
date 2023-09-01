package com.espe.alquiler.idao;

import com.espe.alquiler.dao.IUsuariosDAO;
import com.espe.alquiler.model.Usuarios;
import com.espe.alquiler.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class UsuariosDAOImpl implements IUsuariosDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public void guardar(Usuarios usuarios) {
        entityManager.getTransaction().begin(); //inicializo
        entityManager.persist(usuarios); //persisto o guardo
        entityManager.getTransaction().commit(); //commit
        //JPAUtil.shutdown();
    }

    @Override
    public void editar(Usuarios usuarios) {
        entityManager.getTransaction().begin();
        entityManager.merge(usuarios);
        entityManager.getTransaction().commit();
        //JPAUtil.shutdown();
    }

    @Override
    public Usuarios buscar(int id) {
        Usuarios oUsuarios;
        oUsuarios = entityManager.find(Usuarios.class, id);
        //JPAUtil.shutdown();
        return oUsuarios;
    }

    @Override
    public Usuarios buscarUsuarioPorUsernamePassword(String username, String password) {
        try {
            Query query = entityManager.createQuery("SELECT u FROM Usuarios u WHERE u.username = :username AND u.password = :password");
            query.setParameter("Username", username);
            query.setParameter("Password", password);
            return (Usuarios) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Usuarios> obtenerUsuarios() {
        IUsuariosDAO usuariosDAO = new UsuariosDAOImpl();
        List<Usuarios> usuarios = usuariosDAO.obtenerUsuarios();

        for (Usuarios usuario : usuarios) {
            System.out.println("ID: " + usuario.getId_Usuarios());
            System.out.println("Username: " + usuario.getUsername());
            System.out.println("Password: " + usuario.getPassword());
            System.out.println("-------------------------");
        }
        return usuarios;
    }

    @Override
    public void eliminar(int id) {
        Usuarios oUsuario;
        oUsuario = entityManager.find(Usuarios.class, id);//encuentro al usuario
        entityManager.getTransaction().begin();//inicio la transaccion
        entityManager.remove(oUsuario);//remuevo el usuario
        entityManager.getTransaction().commit();
    }
}
