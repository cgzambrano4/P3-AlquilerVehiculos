package com.espe.alquiler.idao;

import com.espe.alquiler.dao.IAutoDAO;
import com.espe.alquiler.model.Auto;
import com.espe.alquiler.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class AutoDAOImpl implements IAutoDAO {
    private EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void guardar(Auto auto) {
        entityManager.getTransaction().begin();
        entityManager.persist(auto);
        entityManager.getTransaction().commit();
    }

    @Override
    public void editar(Auto auto) {
        entityManager.getTransaction().begin();
        entityManager.merge(auto);
        entityManager.getTransaction().commit();
    }

    @Override
    public Auto buscar(int id) {
        return entityManager.find(Auto.class, id);
    }

    @Override
    public List<Auto> obtenerAuto() {
        Query query = entityManager.createQuery("SELECT a FROM Auto a");
        return query.getResultList();
    }

    @Override
    public void eliminar(int id) {
        entityManager.getTransaction().begin();
        Auto auto = entityManager.find(Auto.class, id);
        if (auto != null) {
            entityManager.remove(auto);
        }
        entityManager.getTransaction().commit();
    }

}

