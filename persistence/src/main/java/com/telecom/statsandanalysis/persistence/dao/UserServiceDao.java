package com.telecom.statsandanalysis.persistence.dao;

import com.telecom.statsandanalysis.persistence.entity.Role;
import com.telecom.statsandanalysis.persistence.entity.UserService;
import com.telecom.statsandanalysis.persistence.entity.UserServicePK;
import org.springframework.stereotype.Repository;

/**
 * Created by A-one on 19.04.2017.
 */
@Repository
public interface UserServiceDao extends BaseDao<UserService, UserServicePK> {
}
