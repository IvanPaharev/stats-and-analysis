package com.telecom.statsandanalysis.persistence.dao;

import com.telecom.statsandanalysis.persistence.entity.Role;
import com.telecom.statsandanalysis.persistence.entity.UserServiceDetails;
import org.springframework.stereotype.Repository;

/**
 * Created by A-one on 19.04.2017.
 */
@Repository
public interface UserServiceDetailsDao extends BaseDao<UserServiceDetails, Integer> {
}
