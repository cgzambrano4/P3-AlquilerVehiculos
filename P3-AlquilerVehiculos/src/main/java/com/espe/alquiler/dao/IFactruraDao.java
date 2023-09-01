package com.espe.alquiler.p3alquilervehiculos.Facturas.Dao;


import com.espe.alquiler.p3alquilervehiculos.Facturas.Modelo.Facturas;

import java.util.List;

public interface IFactruraDao {
    Facturas buscarPorId(int id);

    List<Facturas> obtenerFacturas();


    void guardarFactura(Facturas factura);

    void editar(Facturas facturas);

    void eliminar(int id);
}