package com.telecom.statsandanalysis.persistence.dao.mySqlImpl;

import com.telecom.statsandanalysis.persistence.dao.AnswerDao;
import com.telecom.statsandanalysis.persistence.dao.RoleDao;
import com.telecom.statsandanalysis.persistence.entity.Answer;
import com.telecom.statsandanalysis.persistence.entity.Role;
import org.springframework.stereotype.Repository;


/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public class MySqlAnswerDao extends MySqlBaseDao<Answer, Integer> implements AnswerDao {
    public MySqlAnswerDao() {
        super(Answer.class);
    }
}
