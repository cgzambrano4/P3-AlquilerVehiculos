package com.espe.alquiler.dao;


import com.espe.alquiler.model.Facturas;

import java.util.List;

public interface IFactruraDao {
    Facturas buscarPorId(int id);

    List<Facturas> obtenerFacturas();


    void guardarFactura(Facturas factura);

    void editar(Facturas facturas);

    void eliminar(int id);
}