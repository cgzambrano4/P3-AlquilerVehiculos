package com.espe.alquiler.idao;

import com.espe.alquiler.dao.IEmpleadoDao;
import com.espe.alquiler.model.Usuarios;
import com.espe.alquiler.util.JPAUtil;
import com.espe.alquiler.model.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

//Creado - paso 4.1
public class EmpleadoDaoImpl implements IEmpleadoDao {
    private EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void guardar(Empleado empleado) {
        entityManager.getTransaction().begin(); //inicializo
        entityManager.persist(empleado); //persisto o guardo
        entityManager.getTransaction().commit(); //commit
    }
    @Override
    public void editar(Empleado empleado) {
        entityManager.getTransaction().begin();
        entityManager.merge(empleado);
        entityManager.getTransaction().commit();
    }

    @Override
    public Empleado buscar(int id) {
        return entityManager.find(Empleado.class, id);
    }

    @Override
    public List<Empleado> obtenerEmpleados(){
        Query query = entityManager.createQuery("SELECT em FROM Empleado em");
        return query.getResultList();
    }

    //agregado
    @Override
    public void eliminar(int id) {
        entityManager.getTransaction().begin();
        Empleado empleado = entityManager.find(Empleado.class, id);
        if (empleado != null) {
            entityManager.remove(empleado);
        }
        entityManager.getTransaction().commit();
    }
}
