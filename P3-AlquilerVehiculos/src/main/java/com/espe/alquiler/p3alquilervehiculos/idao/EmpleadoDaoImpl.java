package com.espe.alquiler.idao;

import com.espe.alquiler.dao.IEmpleadoDao;
import com.espe.alquiler.model.JPAUtil;
import com.espe.alquiler.model.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

//Creado - paso 4.1
public class EmpleadoDaoImpl implements IEmpleadoDao {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public void guardar(Empleado empleado) {
        entityManager.getTransaction().begin(); //inicializo
        entityManager.persist(empleado); //persisto o guardo
        entityManager.getTransaction().commit(); //commit
        //JPAUtil.shutdown(); //cierro
    }

    @Override
    public void editar(Empleado empleado) {
        entityManager.getTransaction().begin();
        entityManager.merge(empleado);
        entityManager.getTransaction().commit();
        ///JPAUtil.shutdown();
    }

    @Override
    public Empleado buscar(int id) {
        empleado oEmpleado = new Usuario();
        oEmpleado = entityManager.find(Empleado.class, id);
        //JPAUtil.shutdown();
        return oEmpleado;
    }

    @Override
    public List<Empleado> obtenerEmpleados(){
        List<Empleado> listaEmpleados;
        //sentencia JPQL
        Query query = entityManager.createQuery("SELECT u FROM empleados u");
        listaEmpleados = query.getResultList();
        return listaEmpleados;
    }

    //agregado
    @Override
    public void eliminar(int id) {
        Empleado oEmpleado;
        oEmpleado = entityManager.find(Empleado.class, id);//encuentro al usuario
        entityManager.getTransaction().begin();//inicio la transaccion
        entityManager.remove(oEmpleado);//remuevo el usuario
        entityManager.getTransaction().commit();//actualizo la transaccion y la base de datos
    }
}
