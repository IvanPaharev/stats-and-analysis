package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.config.DataConfig;
import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MySqlReviewDaoTest {

    @Autowired
    @Resource(name = "mySqlReviewDao")
    private BaseDao<Review, ReviewPK> reviewDao;

    @Autowired
    @Resource(name = "mySqlUserDao")
    private BaseDao<User, Integer> userDao;

    @Autowired
    @Resource(name = "mySqlGradeDao")
    private BaseDao<Grade, Integer> gradeDao;

    @Autowired
    @Resource(name = "mySqlPriorityDao")
    private BaseDao<Priority, Integer> priorityDao;

    @Autowired
    @Resource(name = "mySqlReviewSubjectDao")
    private BaseDao<ReviewSubject, Integer> reviewSubjectDao;

    @Test
    public void testUpdate() {
        String newName = "new description";
        Review review = (Review) reviewDao.get(testId);
        review.setReview(newName);
        reviewDao.update(review);
        assertEquals(newName, review.getReview());
    }

    private Review entity;
    protected ReviewPK testId;

    @Before
    public void setUp(){
        entity = getEntity();
        testId = ((Review)reviewDao.getAll().get(0)).getReviewPK();
    }

    @Test
    public void testAddAndGetAll() {
        int size = reviewDao.getAll().size();
        reviewDao.add(entity);
        System.out.println(entity.getGrade());
        assertTrue(size < reviewDao.getAll().size());
    }

    @Test
    public void testGet() {
        entity = reviewDao.get(testId);
        assertNotNull(entity);
    }


    @Test
    public void testDelete() {
        reviewDao.delete(testId);
        assertNull(reviewDao.get(testId));
    }

    protected Review getEntity() {
        return new Review(
                new ReviewPK(userDao.getAll().get(1).getId(),
                        reviewSubjectDao.getAll().get(0).getId()),
                "q",
                userDao.getAll().get(0),
                reviewSubjectDao.getAll().get(0),
                gradeDao.getAll().get(0),
                priorityDao.getAll().get(0)
        );
    }
}
