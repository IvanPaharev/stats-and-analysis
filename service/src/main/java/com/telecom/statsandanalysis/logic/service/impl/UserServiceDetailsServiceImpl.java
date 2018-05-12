package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.UserServiceDetailsService;
import com.telecom.statsandanalysis.persistence.dao.UserServiceDetailsDao;
import com.telecom.statsandanalysis.persistence.entity.UserServiceDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class UserServiceDetailsServiceImpl extends BaseServiceImpl<UserServiceDetails, Integer> implements UserServiceDetailsService {
    private final UserServiceDetailsDao userServiceDetailsDao;

    public UserServiceDetailsServiceImpl(UserServiceDetailsDao userServiceDetailsDao) {
        super(userServiceDetailsDao);
        this.userServiceDetailsDao = userServiceDetailsDao;
    }
}
