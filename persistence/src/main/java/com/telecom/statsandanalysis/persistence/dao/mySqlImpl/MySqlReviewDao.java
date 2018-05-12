package com.telecom.statsandanalysis.persistence.dao.mySqlImpl;

import com.telecom.statsandanalysis.persistence.dao.ReviewDao;
import com.telecom.statsandanalysis.persistence.dao.RoleDao;
import com.telecom.statsandanalysis.persistence.entity.Review;
import com.telecom.statsandanalysis.persistence.entity.ReviewPK;
import com.telecom.statsandanalysis.persistence.entity.Role;
import org.springframework.stereotype.Repository;


/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public class MySqlReviewDao extends MySqlBaseDao<Review, ReviewPK> implements ReviewDao {
    public MySqlReviewDao() {
        super(Review.class);
    }
}
