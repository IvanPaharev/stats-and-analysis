package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import com.telecom.statsandanalysis.persistence.entity.Question;
import com.telecom.statsandanalysis.persistence.entity.Status;
import com.telecom.statsandanalysis.persistence.entity.Survey;
import com.telecom.statsandanalysis.persistence.utils.QuestionTypes;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlQuestionDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlQuestionDao")
    private BaseDao<Question, Integer> questionDao;

    @Autowired
    @Resource(name = "mySqlSurveyDao")
    private BaseDao<Survey, Integer> surveyDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        Question question = (Question) getDao().get(testId);
        question.setQuestion(newName);
        getDao().update(question);
        assertEquals(newName, question.getQuestion());
    }

    @Override
    protected BaseDao getDao() {
        return questionDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new Question("q", QuestionTypes.SINGLE, surveyDao.get(1));
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new Question("q", QuestionTypes.SINGLE, surveyDao.get(1)),
                new Question("w", QuestionTypes.SINGLE, surveyDao.get(1)));
    }
}
