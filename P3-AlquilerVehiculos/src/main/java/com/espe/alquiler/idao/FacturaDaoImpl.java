package com.espe.alquiler.p3alquilervehiculos.Facturas.Idao;

import com.espe.alquiler.p3alquilervehiculos.Facturas.Dao.IFactruraDao;
import com.espe.alquiler.p3alquilervehiculos.Facturas.Modelo.Facturas;
import com.espe.alquiler.p3alquilervehiculos.Facturas.Modelo.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class FacturaDaoImpl implements IFactruraDao {

    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public Facturas buscarPorId(int id) {
        Facturas oFacturas = new Facturas();
        oFacturas = entityManager.find(Facturas.class, id);
        return oFacturas;
    }

    @Override
    public List<Facturas> obtenerFacturas() {

        List<Facturas> listaFactura;
        //sentencia JPQL
        Query query = entityManager.createQuery("SELECT f FROM Facturas f ");
        listaFactura = query.getResultList();
        return listaFactura;

    }




    @Override
    public void guardarFactura(Facturas factura) {
        entityManager.getTransaction().begin();
        entityManager.persist(factura);
        entityManager.getTransaction().commit();
    }


    @Override

    public void editar(Facturas factura) {
        entityManager.getTransaction().begin();
        entityManager.merge(factura);
        entityManager.getTransaction().commit();
    }


    @Override
    public void eliminar(int id) {
        Facturas oFacturas;
        oFacturas = entityManager.find(Facturas.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(oFacturas);

        entityManager.getTransaction().commit();

    }


}
