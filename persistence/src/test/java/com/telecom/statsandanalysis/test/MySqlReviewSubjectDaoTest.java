package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import com.telecom.statsandanalysis.persistence.entity.ReviewSubject;
import com.telecom.statsandanalysis.persistence.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlReviewSubjectDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlReviewSubjectDao")
    private BaseDao<ReviewSubject, Integer> reviewSubjectDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        ReviewSubject reviewSubject = (ReviewSubject) getDao().get(testId);
        reviewSubject.setDescription(newName);
        getDao().update(reviewSubject);
        assertEquals(newName, reviewSubject.getDescription());
    }

    @Override
    protected BaseDao getDao() {
        return reviewSubjectDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new ReviewSubject("t", "t");
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new ReviewSubject("t", "t"),
                new ReviewSubject("w", "t"));
    }
}
