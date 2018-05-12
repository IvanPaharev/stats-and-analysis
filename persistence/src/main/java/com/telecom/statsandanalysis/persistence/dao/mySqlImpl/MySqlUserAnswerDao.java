package com.telecom.statsandanalysis.persistence.dao.mySqlImpl;

import com.telecom.statsandanalysis.persistence.dao.RoleDao;
import com.telecom.statsandanalysis.persistence.dao.UserAnswerDao;
import com.telecom.statsandanalysis.persistence.entity.Role;
import com.telecom.statsandanalysis.persistence.entity.UserAnswer;
import org.springframework.stereotype.Repository;


/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public class MySqlUserAnswerDao extends MySqlBaseDao<UserAnswer, Integer> implements UserAnswerDao {
    public MySqlUserAnswerDao() {
        super(UserAnswer.class);
    }
}
