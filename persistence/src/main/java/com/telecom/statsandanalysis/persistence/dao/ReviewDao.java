package com.telecom.statsandanalysis.persistence.dao;

import com.telecom.statsandanalysis.persistence.entity.Review;
import com.telecom.statsandanalysis.persistence.entity.ReviewPK;
import com.telecom.statsandanalysis.persistence.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by A-one on 19.04.2017.
 */
@Repository
public interface ReviewDao extends BaseDao<Review, ReviewPK> {
}
