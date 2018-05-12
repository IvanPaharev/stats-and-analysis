package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlReportDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlReportDao")
    private BaseDao<Report, Integer> reportDao;

    @Autowired
    @Resource(name = "mySqlUserDao")
    private BaseDao<User, Integer> userDao;

    @Autowired
    @Resource(name = "mySqlReportTypeDao")
    private BaseDao<ReportType, Integer> reportTypeDao;

    @Autowired
    @Resource(name = "mySqlPriorityDao")
    private BaseDao<Priority, Integer> priorityDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        Report report = (Report) getDao().get(testId);
        report.setDescription(newName);
        getDao().update(report);
        assertEquals(newName, report.getDescription());
    }

    @Override
    protected BaseDao getDao() {
        return reportDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new Report("de", userDao.get(1), reportTypeDao.get(1), priorityDao.get(1));
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new Report("de", userDao.get(1), reportTypeDao.get(1), priorityDao.get(1)),
                new Report("de", userDao.get(1), reportTypeDao.get(1), priorityDao.get(1)));
    }
}
