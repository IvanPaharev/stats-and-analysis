package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.TrafficTypeService;
import com.telecom.statsandanalysis.persistence.dao.TrafficTypeDao;
import com.telecom.statsandanalysis.persistence.entity.TrafficType;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class TrafficTypeServiceImpl extends BaseServiceImpl<TrafficType, Integer> implements TrafficTypeService {
    private final TrafficTypeDao trafficTypeDao;

    public TrafficTypeServiceImpl(TrafficTypeDao trafficTypeDao) {
        super(trafficTypeDao);
        this.trafficTypeDao = trafficTypeDao;
    }
}
