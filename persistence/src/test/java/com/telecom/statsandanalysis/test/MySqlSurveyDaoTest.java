package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import com.telecom.statsandanalysis.persistence.entity.Status;
import com.telecom.statsandanalysis.persistence.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlSurveyDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlSurveyDao")
    private BaseDao<Survey, Integer> surveyDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        Survey survey = (Survey) getDao().get(testId);
        survey.setDescription(newName);
        getDao().update(survey);
        assertEquals(newName, survey.getDescription());
    }

    @Override
    protected BaseDao getDao() {
        return surveyDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new Survey("t", "t");
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new Survey("t", "t"),
                new Survey("w", "t"));
    }
}
