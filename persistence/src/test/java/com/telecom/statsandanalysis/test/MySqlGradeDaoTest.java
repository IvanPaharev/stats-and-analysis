package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import com.telecom.statsandanalysis.persistence.entity.Grade;
import com.telecom.statsandanalysis.persistence.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlGradeDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlGradeDao")
    private BaseDao<Grade, Integer> gradeDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        Grade grade = (Grade) getDao().get(testId);
        grade.setDescription(newName);
        getDao().update(grade);
        assertEquals(newName, grade.getDescription());
    }

    @Override
    protected BaseDao getDao() {
        return gradeDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new Grade("t", "t");
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new Grade("t", "t"),
                new Grade("w", "t"));
    }
}
