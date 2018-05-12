package com.telecom.statsandanalysis.test;

import com.telecom.statsandanalysis.persistence.dao.BaseDao;
import com.telecom.statsandanalysis.persistence.entity.Attachment;
import com.telecom.statsandanalysis.persistence.entity.BaseEntity;
import com.telecom.statsandanalysis.persistence.entity.Report;
import com.telecom.statsandanalysis.persistence.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by A-one on 10.04.2017.
 */
public class MySqlAttachmentDaoTest extends BaseDaoGenericTest{

    @Autowired
    @Resource(name = "mySqlAttachmentDao")
    private BaseDao<Attachment, Integer> attachmentDao;

    @Autowired
    @Resource(name = "mySqlReportDao")
    private BaseDao<Report, Integer> reportDao;

    @Override
    public void testUpdate() {
        String newName = "new description";
        Attachment attachment = (Attachment) getDao().get(testId);
        attachment.setAttachmentSource(newName);
        getDao().update(attachment);
        assertEquals(newName, attachment.getAttachmentSource());
    }

    @Override
    protected BaseDao getDao() {
        return attachmentDao;
    }

    @Override
    protected BaseEntity getEntity() {
        return new Attachment("t", reportDao.get(1));
    }

    @Override
    protected Collection<BaseEntity> getCollection() {
        return Arrays.asList(new Attachment("t", reportDao.get(1)),
                new Attachment("w", reportDao.get(1)));
    }
}
