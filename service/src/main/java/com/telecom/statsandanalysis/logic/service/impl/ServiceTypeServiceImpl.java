package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.ServiceTypeService;
import com.telecom.statsandanalysis.persistence.dao.ServiceTypeDao;
import com.telecom.statsandanalysis.persistence.entity.ServiceType;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class ServiceTypeServiceImpl extends BaseServiceImpl<ServiceType, Integer> implements ServiceTypeService {
    private final ServiceTypeDao serviceTypeDao;

    public ServiceTypeServiceImpl(ServiceTypeDao serviceTypeDao) {
        super(serviceTypeDao);
        this.serviceTypeDao = serviceTypeDao;
    }
}
