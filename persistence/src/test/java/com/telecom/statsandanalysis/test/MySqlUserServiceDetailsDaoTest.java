package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlUserServiceDetailsDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlUserServiceDetailsDao")
    private BaseDao<UserServiceDetails, Integer> userServiceDetailsDao;

    @Autowired
    @Resource(name = "mySqlUserServiceDao")
    private BaseDao<UserService, UserServicePK> userServiceDao;

    @Autowired
    @Resource(name = "mySqlUserDao")
    private BaseDao<User, Integer> userDao;

    @Autowired
    @Resource(name = "mySqlTrafficTypeDao")
    private BaseDao<TrafficType, Integer> trafficTypeDao;

    @Override
    public void testUpdate() {
        double newName = 666;
        UserServiceDetails userServiceDetails = (UserServiceDetails) getDao().get(testId);
        userServiceDetails.setTraffic(newName);
        getDao().update(userServiceDetails);
        assertEquals(newName, userServiceDetails.getTraffic(), 1e-15);
    }

    @Override
    protected BaseDao getDao() {
        return userServiceDetailsDao;
    }

    @Override
    protected BaseEntity getEntity() {
        UserServicePK userServicePK = userServiceDao.getAll().get(0).getUserServicePK();
        return new UserServiceDetails(
                userServiceDao.get(userServicePK),
                userDao.get(userServicePK.getUserId()),
                trafficTypeDao.getAll().get(0),
                new Timestamp(118, 5, 11, 12, 12, 12, 12),
                new Timestamp(118, 5, 11, 14, 12, 12, 12),
                12);
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        UserServicePK userServicePK = userServiceDao.getAll().get(0).getUserServicePK();
        return Arrays.asList(new UserServiceDetails(
                        userServiceDao.get(userServicePK),
                        userDao.get(userServicePK.getUserId()),
                        trafficTypeDao.getAll().get(0),
                        new Timestamp(118, 5, 11, 12, 12, 12, 12),
                        new Timestamp(118, 5, 11, 14, 12, 12, 12),
                        12),
                new UserServiceDetails(
                        userServiceDao.get(userServicePK),
                        userDao.get(userServicePK.getUserId()),
                        trafficTypeDao.getAll().get(0),
                        new Timestamp(118, 4, 11, 12, 12, 12, 12),
                        new Timestamp(118, 4, 11, 14, 12, 12, 12),
                        12));
    }
}
