package com.telecom.statsandanalysis.persistence.dao.mySqlImpl;

import com.telecom.statsandanalysis.persistence.dao.GradeDao;
import com.telecom.statsandanalysis.persistence.dao.RoleDao;
import com.telecom.statsandanalysis.persistence.entity.Grade;
import com.telecom.statsandanalysis.persistence.entity.Role;
import org.springframework.stereotype.Repository;


/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public class MySqlGradeDao extends MySqlBaseDao<Grade, Integer> implements GradeDao {
    public MySqlGradeDao() {
        super(Grade.class);
    }
}
