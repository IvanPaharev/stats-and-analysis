package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.ReportService;
import com.telecom.statsandanalysis.persistence.dao.ReportDao;
import com.telecom.statsandanalysis.persistence.entity.Report;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class ReportServiceImpl extends BaseServiceImpl<Report, Integer> implements ReportService {
    private final ReportDao reportDao;

    public ReportServiceImpl(ReportDao reportDao) {
        super(reportDao);
        this.reportDao = reportDao;
    }
}
