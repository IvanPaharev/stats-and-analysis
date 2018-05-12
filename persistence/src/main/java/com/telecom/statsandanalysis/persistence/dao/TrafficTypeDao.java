package com.telecom.statsandanalysis.persistence.dao;

import com.telecom.statsandanalysis.persistence.entity.Role;
import com.telecom.statsandanalysis.persistence.entity.TrafficType;
import org.springframework.stereotype.Repository;

/**
 * Created by A-one on 19.04.2017.
 */
@Repository
public interface TrafficTypeDao extends BaseDao<TrafficType, Integer> {
}
