package com.telecom.statsandanalysis.persistence.dao.mySqlImpl;

import com.telecom.statsandanalysis.persistence.dao.RoleDao;
import com.telecom.statsandanalysis.persistence.dao.ServiceTypeDao;
import com.telecom.statsandanalysis.persistence.entity.Role;
import com.telecom.statsandanalysis.persistence.entity.ServiceType;
import org.springframework.stereotype.Repository;


/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public class MySqlServiceTypeDao extends MySqlBaseDao<ServiceType, Integer> implements ServiceTypeDao {
    public MySqlServiceTypeDao() {
        super(ServiceType.class);
    }
}
