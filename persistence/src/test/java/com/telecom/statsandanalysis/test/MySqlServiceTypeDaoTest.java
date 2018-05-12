package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import com.telecom.statsandanalysis.persistence.entity.ServiceType;
import com.telecom.statsandanalysis.persistence.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlServiceTypeDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlServiceTypeDao")
    private BaseDao<ServiceType, Integer> serviceTypeDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        ServiceType serviceType = (ServiceType) getDao().get(testId);
        serviceType.setDescription(newName);
        getDao().update(serviceType);
        assertEquals(newName, serviceType.getDescription());
    }

    @Override
    protected BaseDao getDao() {
        return serviceTypeDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new ServiceType("t", "t");
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new ServiceType("t", "t"),
                new ServiceType("w", "t"));
    }
}
