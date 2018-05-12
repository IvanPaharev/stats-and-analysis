package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.config.DataConfig;
import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

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
public class MySqlUserServiceDaoTest {

    @Autowired
    @Resource(name = "mySqlUserServiceDao")
    private BaseDao<UserService, UserServicePK> userServiceDao;

    @Autowired
    @Resource(name = "mySqlUserDao")
    private BaseDao<User, Integer> userDao;

    @Autowired
    @Resource(name = "mySqlServiceDao")
    private BaseDao<Service, Integer> serviceDao;

    @Autowired
    @Resource(name = "mySqlStatusDao")
    private BaseDao<Status, Integer> statusDao;

    @Test
    public void testUpdate() {
        double newName = -666;
        UserService userService = (UserService) getDao().get(testId);
        userService.setBalance(newName);
        getDao().update(userService);
        assertEquals(newName, userService.getBalance(), 1e-15);
    }

    private UserService entity;
    protected UserServicePK testId;

    @Before
    public void setUp(){
        entity = getEntity();
        testId = ((UserService)userServiceDao.getAll().get(0)).getUserServicePK();
    }

    @Test
    public void testAddAndGetAll() {
        int size = userServiceDao.getAll().size();
        userServiceDao.add(entity);
        System.out.println(entity.getBalance());
        assertTrue(size < userServiceDao.getAll().size());
    }

    @Test
    public void testGet() {
        entity = userServiceDao.get(testId);
        assertNotNull(entity);
    }


    @Test
    public void testDelete() {
        userServiceDao.delete(testId);
        assertNull(userServiceDao.get(testId));
    }

    protected BaseDao getDao() {
        return userServiceDao;
    }

    protected UserService getEntity() {
        return new UserService(
                new UserServicePK(
                        userDao.getAll().get(1).getId(),
                        serviceDao.getAll().get(0).getId()
                ),
                0, statusDao.getAll().get(0));
    }
}
