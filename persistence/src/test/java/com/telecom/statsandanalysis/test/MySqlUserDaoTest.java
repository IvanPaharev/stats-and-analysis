package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import com.telecom.statsandanalysis.persistence.entity.Status;
import com.telecom.statsandanalysis.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlUserDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlUserDao")
    private BaseDao<User, Integer> userDao;

    @Autowired
    @Resource(name = "mySqlStatusDao")
    private BaseDao<Status, Integer> statusDao;

    @Override
    public void testUpdate() {
        String newName = "newCategory";
        User user = (User) getDao().get(testId);
        user.setFirstname(newName);
        getDao().update(user);
        assertEquals(newName, user.getFirstname());
    }

    @Override
    protected BaseDao getDao() {
        return userDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new User("t", "t", "t", "t", "t", statusDao.get(1));
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new User("t", "t", "t", "t", "t", statusDao.get(1)),
                new User("w", "w", "w", "w", "w", statusDao.get(1)));
    }
}
