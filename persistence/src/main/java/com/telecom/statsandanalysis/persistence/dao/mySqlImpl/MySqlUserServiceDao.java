package com.telecom.statsandanalysis.persistence.dao.mySqlImpl;

import com.telecom.statsandanalysis.persistence.dao.RoleDao;
import com.telecom.statsandanalysis.persistence.dao.UserServiceDao;
import com.telecom.statsandanalysis.persistence.entity.Role;
import com.telecom.statsandanalysis.persistence.entity.UserService;
import com.telecom.statsandanalysis.persistence.entity.UserServicePK;
import org.springframework.stereotype.Repository;


/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public class MySqlUserServiceDao extends MySqlBaseDao<UserService, UserServicePK> implements UserServiceDao {
    public MySqlUserServiceDao() {
        super(UserService.class);
    }
}
