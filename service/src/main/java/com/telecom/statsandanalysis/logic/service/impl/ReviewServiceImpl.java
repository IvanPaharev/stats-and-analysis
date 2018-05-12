package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.ReviewService;
import com.telecom.statsandanalysis.persistence.dao.ReviewDao;
import com.telecom.statsandanalysis.persistence.entity.Review;
import com.telecom.statsandanalysis.persistence.entity.ReviewPK;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class ReviewServiceImpl extends BaseServiceImpl<Review, ReviewPK> implements ReviewService {
    private final ReviewDao reviewDao;

    public ReviewServiceImpl(ReviewDao reviewDao) {
        super(reviewDao);
        this.reviewDao = reviewDao;
    }
}
