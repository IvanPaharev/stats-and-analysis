package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.RoleService;
import com.telecom.statsandanalysis.logic.service.UserService;
import com.telecom.statsandanalysis.persistence.dao.UserDao;
import com.telecom.statsandanalysis.persistence.entity.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by A-one on 23.04.2017.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {
    private final UserDao userDao;
    private final RoleService roleService;

    public UserServiceImpl(UserDao userDao, RoleService roleService) {
        super(userDao);
        this.userDao = userDao;
        this.roleService = roleService;
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public User update(User user) {
        user.setPassword(userDao.get(user.getId()).getPassword());
        return userDao.update(user);
    }

    @Override
    public User add(User user) {
        if (userDao.getUserByEmail(user.getEmail()) == null) {
            user = userDao.add(user);
            user.setRoles(new ArrayList<>(Collections.singletonList(roleService.get(1))));
        }
        return user;
    }

}
