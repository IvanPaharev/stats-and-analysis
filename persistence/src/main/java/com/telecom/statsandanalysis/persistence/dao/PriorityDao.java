package com.telecom.statsandanalysis.persistence.dao;

import com.telecom.statsandanalysis.persistence.entity.Priority;
import com.telecom.statsandanalysis.persistence.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by A-one on 19.04.2017.
 */
@Repository
public interface PriorityDao extends BaseDao<Priority, Integer> {
}
