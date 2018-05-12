package com.telecom.statsandanalysis.persistence.dao;

import com.telecom.statsandanalysis.persistence.exception.DaoException;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public interface BaseDao<E, ID extends Serializable> {
    E add(E e) throws DaoException;
    Collection<E> addAll(Collection<E> collection);
    E get(ID id);
    List<E> getAll();
    E update(E e);
    void delete(E e);
    void delete(ID id);
    void deleteAll(Collection<E> collection);
}
