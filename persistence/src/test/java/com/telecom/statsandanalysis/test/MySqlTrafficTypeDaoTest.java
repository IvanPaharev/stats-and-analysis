package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import com.telecom.statsandanalysis.persistence.entity.Status;
import com.telecom.statsandanalysis.persistence.entity.TrafficType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlTrafficTypeDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlTrafficTypeDao")
    private BaseDao<TrafficType, Integer> trafficTypeDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        TrafficType trafficType = (TrafficType) getDao().get(testId);
        trafficType.setDescription(newName);
        getDao().update(trafficType);
        assertEquals(newName, trafficType.getDescription());
    }

    @Override
    protected BaseDao getDao() {
        return trafficTypeDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new TrafficType("t", "t");
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new TrafficType("t", "t"),
                new TrafficType("w", "t"));
    }
}
