package br.com.delogic.jpasy.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.eclipse.persistence.queries.ReadObjectQuery;

import br.com.delogic.jpasy.Dao;
import br.com.delogic.jpasy.With;

public class JpaDaoImpl implements Dao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Object entity) {
        this.entityManager.persist(entity);
        entityManager.flush();
    }

    @Override
    public void delete(Object entity) {
        // se for uma Entidade base com código comum então pegamos o ID e
        // refazemos a consulta para poder remover
        entityManager.remove(entity);
        // apos o delete é executado devemos mandar o comando para o banco para
        // ter certeza que próximas ações utilizarão resultados corretos
        entityManager.flush();
    }

    @Override
    public <E> E read(Object id, Class<E> clazz) {
        E entidade = entityManager.find(clazz, id);
        return entidade;
    }

    @Override
    public void create(Collection<? extends Object> entidade) {
        for (Object o : entidade) {
            create(o);
        }
    }

    @Override
    public void update(Collection<? extends Object> entidade) {
        for (Object o : entidade) {
            update(o);
        }
    }

    @Override
    public void delete(Collection<? extends Object> entidade) {
        for (Object o : entidade) {
            delete(o);
        }
    }

    @Override
    public void update(Object entidade) {
        entityManager.merge(entidade);
        // após o update é necessário enviar os comandos para o banco
        // para ter certeza que os dados utilizados estarão corretos
        // para próximas ações como consultas por exemplos
        entityManager.flush();
        // em casos de relacionamentos com cascade all, após os objetos
        // serem inseridos a PK não é populada, então este refresh
        // irá repopular todos os objetos renovando os dados e pks/fks/etc
        refresh(entidade);
    }

    private void refresh(Object entidade) {
        ReadObjectQuery query = new ReadObjectQuery(entidade);
        query.setShouldLoadResultIntoSelectionObject(true);
        EntityManagerImpl em = (EntityManagerImpl) entityManager.getDelegate();
        em.getActiveSession().executeQuery(query);
    }

    @Override
    public <E> With<E> find(Class<E> type) {
        JpaFromImpl from = new JpaFromImpl(entityManager, JpaSqlCommand.SELECT);
        return from.from(type);
    }

}
