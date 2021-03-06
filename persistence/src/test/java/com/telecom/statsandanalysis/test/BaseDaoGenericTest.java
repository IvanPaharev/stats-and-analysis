package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.config.DataConfig;
import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by A-one on 10.04.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DataConfig.class)
@Rollback
@Transactional
@EnableConfigurationProperties
public abstract class BaseDaoGenericTest {

    private Collection<BaseEntity> collection;
    private BaseEntity entity;
    protected int testId;
    private int deleteId;

    @Before
    public void setUp(){
        entity = getEntity();
        collection = getCollection();
        testId = ((BaseEntity)getDao().getAll().get(0)).getId();
    }

    @Test
    public void testGetAll() {
        List es = getDao().getAll();
        assertNotNull(es);
        assertEquals(false, es.isEmpty());
    }

    @Test
    public void testAdd() {
        getDao().add(entity);
        assertNotNull(getDao().get(entity.getId()));
        deleteId = entity.getId();
    }

    @Test
    public void testAddAll() {
        getDao().addAll(collection);
        for (BaseEntity entity : collection) {
            assertNotNull(getDao().get(entity.getId()));
        }
    }

    @Test
    public void testGet() {
        entity = (BaseEntity) getDao().get(testId);
        assertNotNull(entity);
    }

    @Test
    public abstract void testUpdate();

    @Test
    public void testDelete() {
        getDao().delete(deleteId);
        assertNull(getDao().get(deleteId));
    }

    protected abstract BaseDao getDao();
    protected abstract BaseEntity getEntity();
    protected abstract Collection<BaseEntity> getCollection();
}
