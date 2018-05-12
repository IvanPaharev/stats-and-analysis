package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.AnswerService;
import com.telecom.statsandanalysis.persistence.dao.AnswerDao;
import com.telecom.statsandanalysis.persistence.entity.Answer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class AnswerServiceImpl extends BaseServiceImpl<Answer, Integer> implements AnswerService {
    private final AnswerDao answerDao;

    public AnswerServiceImpl(AnswerDao answerDao) {
        super(answerDao);
        this.answerDao = answerDao;
    }
}
