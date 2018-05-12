package com.telecom.statsandanalysis.test.suite;

import com.telecom.statsandanalysis.persistence.dao.mySqlImpl.MySqlGradeDao;
import com.telecom.statsandanalysis.persistence.dao.mySqlImpl.MySqlRoleDao;
import com.telecom.statsandanalysis.test.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by A-one on 10.04.2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        MySqlAnswerDaoTest.class,
        MySqlAttachmentDaoTest.class,
        MySqlGradeDaoTest.class,
        MySqlPriorityDaoTest.class,
        MySqlQuestionDaoTest.class,
        MySqlReportDaoTest.class,
        MySqlReportTypeDaoTest.class,
        MySqlReviewDaoTest.class,
        MySqlReviewSubjectDaoTest.class,
        MySqlRoleDaoTest.class,
        MySqlServiceDaoTest.class,
        MySqlServiceTypeDaoTest.class,
        MySqlStatusDaoTest.class,
        MySqlSurveyDaoTest.class,
        MySqlTrafficTypeDaoTest.class,
        MySqlUserAnswerDaoTest.class,
        MySqlUserDaoTest.class,
        MySqlUserServiceDaoTest.class,
        MySqlUserServiceDetailsDaoTest.class
})
public class MySqlDaoTestSuite {
}
