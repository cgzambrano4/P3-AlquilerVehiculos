package com.espe.cz.idao;

import com.espe.cz.dao.IUsuarioDao;
import com.espe.cz.model.JPAUtil;
import com.espe.cz.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

//Creado - paso 4.1
public class UsuarioDaoImpl implements IUsuarioDao {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public void guardar(Usuario usuario) {
        entityManager.getTransaction().begin(); //inicializo
        entityManager.persist(usuario); //persisto o guardo
        entityManager.getTransaction().commit(); //commit
        //JPAUtil.shutdown(); //cierro
    }

    @Override
    public void editar(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
        ///JPAUtil.shutdown();
    }

    @Override
    public Usuario buscar(int id) {
        Usuario oUsuario = new Usuario();
        oUsuario = entityManager.find(Usuario.class, id);
        //JPAUtil.shutdown();
        return oUsuario;
    }

    @Override
    public List<Usuario> obtenerUsuarios(){
        List<Usuario> listaUsuarios;
        //sentencia JPQL
        Query query = entityManager.createQuery("SELECT u FROM Usuario u");
        listaUsuarios = query.getResultList();
        return listaUsuarios;
    }

    //agregado
    @Override
    public void eliminar(int id) {
        Usuario oUsuario;
        oUsuario = entityManager.find(Usuario.class, id);//encuentro al usuario
        entityManager.getTransaction().begin();//inicio la transaccion
        entityManager.remove(oUsuario);//remuevo el usuario
        entityManager.getTransaction().commit();//actualizo la transaccion y la base de datos
    }
}
