package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.persistence.dao.ReportTypeDao;
import com.telecom.statsandanalysis.persistence.entity.ReportType;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class ReportTypeServiceImpl extends BaseServiceImpl<ReportType, Integer> implements ReportTypeDao {
    private final ReportTypeDao reportTypeDao;

    public ReportTypeServiceImpl(ReportTypeDao reportTypeDao) {
        super(reportTypeDao);
        this.reportTypeDao = reportTypeDao;
    }
}
