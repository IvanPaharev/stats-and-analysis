package com.telecom.statsandanalysis.persistence.dao.mySqlImpl;

import com.telecom.statsandanalysis.persistence.dao.StatusDao;
import com.telecom.statsandanalysis.persistence.entity.Status;
import org.springframework.stereotype.Repository;


/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public class MySqlStatusDao extends MySqlBaseDao<Status, Integer> implements StatusDao {
    public MySqlStatusDao() {
        super(Status.class);
    }
}
