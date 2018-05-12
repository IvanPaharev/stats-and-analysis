package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import com.telecom.statsandanalysis.persistence.entity.Role;
import com.telecom.statsandanalysis.persistence.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlRoleDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlRoleDao")
    private BaseDao<Role, Integer> roleDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        Role role = (Role) getDao().get(testId);
        role.setRole(newName);
        getDao().update(role);
        assertEquals(newName, role.getRole());
    }

    @Override
    protected BaseDao getDao() {
        return roleDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new Role("t");
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new Role("t"),
                new Role("w"));
    }
}
