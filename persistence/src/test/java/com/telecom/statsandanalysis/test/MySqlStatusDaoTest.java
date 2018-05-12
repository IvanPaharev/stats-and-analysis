package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import com.telecom.statsandanalysis.persistence.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlStatusDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlStatusDao")
    private BaseDao<Status, Integer> statusDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        Status status = (Status) getDao().get(testId);
        status.setDescription(newName);
        getDao().update(status);
        assertEquals(newName, status.getDescription());
    }

    @Override
    protected BaseDao getDao() {
        return statusDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new Status("t", "t");
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new Status("t", "t"),
                new Status("t", "t"));
    }
}
