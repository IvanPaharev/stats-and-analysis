package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.StatusService;
import com.telecom.statsandanalysis.persistence.dao.StatusDao;
import com.telecom.statsandanalysis.persistence.entity.Status;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class StatusServiceImpl extends BaseServiceImpl<Status, Integer> implements StatusService {
    private final StatusDao statusDao;

    public StatusServiceImpl(StatusDao statusDao) {
        super(statusDao);
        this.statusDao = statusDao;
    }
}
