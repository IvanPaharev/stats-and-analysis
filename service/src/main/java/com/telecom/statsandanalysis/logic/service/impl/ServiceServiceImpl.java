package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.ServiceService;
import com.telecom.statsandanalysis.persistence.dao.ServiceDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class ServiceServiceImpl extends BaseServiceImpl<com.telecom.statsandanalysis.persistence.entity.Service, Integer> implements ServiceService {
    private final ServiceDao serviceDao;

    public ServiceServiceImpl(ServiceDao serviceDao) {
        super(serviceDao);
        this.serviceDao = serviceDao;
    }
}
