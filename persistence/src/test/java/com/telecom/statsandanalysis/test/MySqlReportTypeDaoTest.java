package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import com.telecom.statsandanalysis.persistence.entity.ReportType;
import com.telecom.statsandanalysis.persistence.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlReportTypeDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlReportTypeDao")
    private BaseDao<ReportType, Integer> reportTypeDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        ReportType reportType = (ReportType) getDao().get(testId);
        reportType.setDescription(newName);
        getDao().update(reportType);
        assertEquals(newName, reportType.getDescription());
    }

    @Override
    protected BaseDao getDao() {
        return reportTypeDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new ReportType("t", "t");
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new ReportType("t", "t"),
                new ReportType("w", "t"));
    }
}
