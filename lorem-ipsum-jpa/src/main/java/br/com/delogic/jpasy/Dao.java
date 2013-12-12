package br.com.delogic.jpasy;

import java.util.Collection;

public interface Dao {

    void create(Object entity);

    void create(Collection<? extends Object> entities);

    <E> E read(Object id, Class<E> clazz);

    void update(Object entity);

    void update(Collection<? extends Object> entities);

    void delete(Object entity);

    void delete(Collection<? extends Object> entity);

    <E> With<E> find(Class<E> type);

}