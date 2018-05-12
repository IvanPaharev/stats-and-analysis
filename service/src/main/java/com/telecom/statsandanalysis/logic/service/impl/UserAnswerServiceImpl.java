package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.UserAnswerService;
import com.telecom.statsandanalysis.persistence.dao.UserAnswerDao;
import com.telecom.statsandanalysis.persistence.entity.UserAnswer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class UserAnswerServiceImpl extends BaseServiceImpl<UserAnswer, Integer> implements UserAnswerService {
    private final UserAnswerDao userAnswerDao;

    public UserAnswerServiceImpl(UserAnswerDao userAnswerDao) {
        super(userAnswerDao);
        this.userAnswerDao = userAnswerDao;
    }
}
