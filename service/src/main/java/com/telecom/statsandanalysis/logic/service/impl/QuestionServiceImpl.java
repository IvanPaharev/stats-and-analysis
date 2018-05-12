package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.QuestionService;
import com.telecom.statsandanalysis.persistence.dao.QuestionDao;
import com.telecom.statsandanalysis.persistence.entity.Question;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class QuestionServiceImpl extends BaseServiceImpl<Question, Integer> implements QuestionService {
    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        super(questionDao);
        this.questionDao = questionDao;
    }
}
