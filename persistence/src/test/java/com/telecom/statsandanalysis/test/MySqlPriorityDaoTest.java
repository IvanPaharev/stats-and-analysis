package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import com.telecom.statsandanalysis.persistence.entity.Priority;
import com.telecom.statsandanalysis.persistence.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlPriorityDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlPriorityDao")
    private BaseDao<Priority, Integer> priorityDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        Priority priority = (Priority) getDao().get(testId);
        priority.setDescription(newName);
        getDao().update(priority);
        assertEquals(newName, priority.getDescription());
    }

    @Override
    protected BaseDao getDao() {
        return priorityDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new Priority("t", "t");
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new Priority("t", "t"),
                new Priority("w", "t"));
    }
}
