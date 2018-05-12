package com.telecom.statsandanalysis.persistence.dao.mySqlImpl;

import com.telecom.statsandanalysis.persistence.dao.ReviewSubjectDao;
import com.telecom.statsandanalysis.persistence.dao.RoleDao;
import com.telecom.statsandanalysis.persistence.entity.ReviewSubject;
import com.telecom.statsandanalysis.persistence.entity.Role;
import org.springframework.stereotype.Repository;


/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public class MySqlReviewSubjectDao extends MySqlBaseDao<ReviewSubject, Integer> implements ReviewSubjectDao {
    public MySqlReviewSubjectDao() {
        super(ReviewSubject.class);
    }
}
