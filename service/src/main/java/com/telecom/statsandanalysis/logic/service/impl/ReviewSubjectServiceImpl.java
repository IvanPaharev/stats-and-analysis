package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.ReviewSubjectService;
import com.telecom.statsandanalysis.persistence.dao.ReviewSubjectDao;
import com.telecom.statsandanalysis.persistence.entity.ReviewSubject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class ReviewSubjectServiceImpl extends BaseServiceImpl<ReviewSubject, Integer> implements ReviewSubjectService {
    private final ReviewSubjectDao reviewSubjectDao;

    public ReviewSubjectServiceImpl(ReviewSubjectDao reviewSubjectDao) {
        super(reviewSubjectDao);
        this.reviewSubjectDao = reviewSubjectDao;
    }
}
