package com.telecom.statsandanalysis.persistence.dao.mySqlImpl;

import com.telecom.statsandanalysis.persistence.dao.RoleDao;
import com.telecom.statsandanalysis.persistence.dao.TrafficTypeDao;
import com.telecom.statsandanalysis.persistence.entity.Role;
import com.telecom.statsandanalysis.persistence.entity.TrafficType;
import org.springframework.stereotype.Repository;


/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public class MySqlTrafficTypeDao extends MySqlBaseDao<TrafficType, Integer> implements TrafficTypeDao {
    public MySqlTrafficTypeDao() {
        super(TrafficType.class);
    }
}
