package com.telecom.statsandanalysis.logic.service.impl;


import com.telecom.statsandanalysis.logic.service.UserServiceService;
import com.telecom.statsandanalysis.persistence.dao.UserServiceDao;
import com.telecom.statsandanalysis.persistence.entity.UserService;
import com.telecom.statsandanalysis.persistence.entity.UserServicePK;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class UserServiceServiceImpl extends BaseServiceImpl<UserService, UserServicePK> implements UserServiceService {
    private final UserServiceDao userServiceDao;

    public UserServiceServiceImpl(UserServiceDao userServiceDao) {
        super(userServiceDao);
        this.userServiceDao = userServiceDao;
    }
}
