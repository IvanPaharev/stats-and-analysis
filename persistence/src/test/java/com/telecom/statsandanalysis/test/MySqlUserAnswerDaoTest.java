package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.*;
import com.telecom.statsandanalysis.persistence.entity.UserAnswer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlUserAnswerDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlUserAnswerDao")
    private BaseDao<UserAnswer, Integer> userAnswerDao;

    @Autowired
    @Resource(name = "mySqlSurveyDao")
    private BaseDao<Survey, Integer> surveyDao;

    @Autowired
    @Resource(name = "mySqlUserDao")
    private BaseDao<User, Integer> userDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        UserAnswer userAnswer = (UserAnswer) getDao().get(testId);
        userAnswer.setUserAnswer(newName);
        getDao().update(userAnswer);
        assertEquals(newName, userAnswer.getUserAnswer());
    }

    @Override
    protected BaseDao getDao() {
        return userAnswerDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new UserAnswer("t", userDao.getAll().get(0), surveyDao.getAll().get(0));
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new UserAnswer("t", userDao.getAll().get(0), surveyDao.getAll().get(0)),
                new UserAnswer("w", userDao.getAll().get(0), surveyDao.getAll().get(0)));
    }
}
