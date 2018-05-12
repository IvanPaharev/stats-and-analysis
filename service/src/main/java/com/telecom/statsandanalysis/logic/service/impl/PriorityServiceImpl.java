package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.PriorityService;
import com.telecom.statsandanalysis.persistence.dao.PriorityDao;
import com.telecom.statsandanalysis.persistence.entity.Priority;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class PriorityServiceImpl extends BaseServiceImpl<Priority, Integer> implements PriorityService {
    private final PriorityDao priorityDao;

    public PriorityServiceImpl(PriorityDao priorityDao) {
        super(priorityDao);
        this.priorityDao = priorityDao;
    }
}
