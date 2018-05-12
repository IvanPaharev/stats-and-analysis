package com.telecom.statsandanalysis.persistence.dao.mySqlImpl;

import com.telecom.statsandanalysis.persistence.dao.RoleDao;
import com.telecom.statsandanalysis.persistence.dao.UserServiceDetailsDao;
import com.telecom.statsandanalysis.persistence.entity.Role;
import com.telecom.statsandanalysis.persistence.entity.UserServiceDetails;
import org.springframework.stereotype.Repository;


/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public class MySqlUserServiceDetailsDao extends MySqlBaseDao<UserServiceDetails, Integer> implements UserServiceDetailsDao {
    public MySqlUserServiceDetailsDao() {
        super(UserServiceDetails.class);
    }
}
