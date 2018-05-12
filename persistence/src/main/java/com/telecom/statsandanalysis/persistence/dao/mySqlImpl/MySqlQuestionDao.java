package com.telecom.statsandanalysis.persistence.dao.mySqlImpl;

import com.telecom.statsandanalysis.persistence.dao.QuestionDao;
import com.telecom.statsandanalysis.persistence.dao.RoleDao;
import com.telecom.statsandanalysis.persistence.entity.Question;
import com.telecom.statsandanalysis.persistence.entity.Role;
import org.springframework.stereotype.Repository;


/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public class MySqlQuestionDao extends MySqlBaseDao<Question, Integer> implements QuestionDao {
    public MySqlQuestionDao() {
        super(Question.class);
    }
}
