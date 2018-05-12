package com.telecom.statsandanalysis.persistence.dao.mySqlImpl;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public abstract class MySqlBaseDao<E, ID extends Serializable> implements BaseDao<E, ID> {
    private Class<E> daoClass;

    @Autowired
    protected EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    protected EntityManager entityManager;

    public MySqlBaseDao(Class<E> daoClass) {
        this.daoClass = daoClass;
    }

    @Override
    public E add(E e) {
        try {
            entityManager.persist(e);
        } catch (EntityExistsException ex) {
            throw new DaoException("Entity already exists", ex);
        }
        return e;
    }

    @Override
    public Collection<E> addAll(Collection<E> collection) {
        for (E e : collection) {
            entityManager.persist(e);
        }
        return collection;
    }

    @Override
    public E get(ID id) {
        return entityManager.find(daoClass, id);
    }

    @Override
    public E update(E e) {
        return entityManager.merge(e);
    }

    @Override
    public void delete(E e) {
        if (e != null) {
            entityManager.remove(e);
        }
    }

    @Override
    public void delete(ID id) {
        E e = entityManager.find(daoClass, id);
        if (e != null) {
            entityManager.remove(e);
        }
    }

    @Override
    public List<E> getAll() {
        CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = builder.createQuery(daoClass);
        Root<E> root = criteriaQuery.from(daoClass);
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void deleteAll(Collection<E> collection) {
        for (E e : collection) {
            entityManager.remove(e);
        }
    }
}
