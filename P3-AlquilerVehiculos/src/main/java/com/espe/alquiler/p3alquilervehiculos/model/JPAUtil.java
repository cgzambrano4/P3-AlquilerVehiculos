package com.espe.alquiler.model;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//Creado - paso 2.1
public class JPAUtil {

    //Creación de los metodos CRUD
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";

    private static EntityManagerFactory factory;

    //establecer el Entity Manager para poder realizar las operaciones CRUD
    public static EntityManagerFactory getEntityManagerFactory() {
        if(factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    //funcion para cerrar la persistencia
    public static void shutdown() {
        if(factory != null) {
            factory.close();
        }
    }
}
