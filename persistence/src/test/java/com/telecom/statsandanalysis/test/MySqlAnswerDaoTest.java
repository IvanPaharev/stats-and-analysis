package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.Answer;
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
public class MySqlAnswerDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlAnswerDao")
    private BaseDao<Answer, Integer> answerDao;

    @Autowired
    @Resource(name = "mySqlSurveyDao")
    private BaseDao<Survey, Integer> surveyDao;

    @Override
    public void testUpdate() {
        String newName = "new answer";
        Answer answer = (Answer) getDao().get(testId);
        answer.setAnswer(newName);
        getDao().update(answer);
        assertEquals(newName, answer.getAnswer());
    }

    @Override
    protected BaseDao getDao() {
        return answerDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new Answer("t", surveyDao.get(1));
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new Answer("t", surveyDao.get(1)),
                new Answer("w", surveyDao.get(1)));
    }
}
