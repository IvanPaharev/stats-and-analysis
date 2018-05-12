package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import com.telecom.statsandanalysis.persistence.entity.Service;
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
public class MySqlServiceDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlServiceDao")
    private BaseDao<Service, Integer> serviceDao;

    @Autowired
    @Resource(name = "mySqlServiceTypeDao")
    private BaseDao<ServiceType, Integer> serviceTypeDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        Service service = (Service) getDao().get(testId);
        service.setDescription(newName);
        getDao().update(service);
        assertEquals(newName, service.getDescription());
    }

    @Override
    protected BaseDao getDao() {
        return serviceDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new Service("t", "t", 0, 0, serviceTypeDao.getAll().get(0));
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new Service("t", "t", 0, 0, serviceTypeDao.getAll().get(0)),
                new Service("w", "t", 0, 0, serviceTypeDao.getAll().get(0)));
    }
}
