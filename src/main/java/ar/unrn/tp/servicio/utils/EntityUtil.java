package ar.unrn.tp.servicio.utils;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class EntityUtil<T> {
    /*
    * ObjectDB: jpa-objectdb
    * PosgresSQL: jpa-postgres
     */

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Transactional
//    @Override
//    public void executeInTransaction(Consumer<EntityManager> action) {
//        try {
//            action.accept(entityManager);
//        } catch (Exception e) {
//            throw new RuntimeException("Error durante la transaccion", e);
//        }
//    }
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void ejecutarTransaccion(Consumer<EntityManager> bloqueDeCodigo) {
            bloqueDeCodigo.accept(entityManager);
    }

    @Transactional
    public List<T> ejecutarQuery(Function<EntityManager, List<T>> bloqueDeCodigo) {
        return bloqueDeCodigo.apply(entityManager);
    }

    @Transactional
    public T ejecutarIndividualQuery(Function<EntityManager, T> bloqueDeCodigo) {
        return bloqueDeCodigo.apply(entityManager);
    }

}
