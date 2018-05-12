package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.GradeService;
import com.telecom.statsandanalysis.persistence.dao.GradeDao;
import com.telecom.statsandanalysis.persistence.entity.Grade;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class GradeServiceImpl extends BaseServiceImpl<Grade, Integer> implements GradeService {
    private final GradeDao gradeDao;

    public GradeServiceImpl(GradeDao gradeDao) {
        super(gradeDao);
        this.gradeDao = gradeDao;
    }
}
