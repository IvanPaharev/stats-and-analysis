package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.SurveyService;
import com.telecom.statsandanalysis.persistence.dao.SurveyDao;
import com.telecom.statsandanalysis.persistence.entity.Survey;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class SurveyServiceImpl extends BaseServiceImpl<Survey, Integer> implements SurveyService {
    private final SurveyDao surveyDao;

    public SurveyServiceImpl(SurveyDao surveyDao) {
        super(surveyDao);
        this.surveyDao = surveyDao;
    }
}
