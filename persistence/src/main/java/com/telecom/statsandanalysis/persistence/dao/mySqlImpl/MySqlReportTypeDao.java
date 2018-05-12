package com.telecom.statsandanalysis.persistence.dao.mySqlImpl;

import com.telecom.statsandanalysis.persistence.dao.ReportTypeDao;
import com.telecom.statsandanalysis.persistence.dao.RoleDao;
import com.telecom.statsandanalysis.persistence.entity.ReportType;
import com.telecom.statsandanalysis.persistence.entity.Role;
import org.springframework.stereotype.Repository;


/**
 * Created by A-one on 10.04.2017.
 */
@Repository
public class MySqlReportTypeDao extends MySqlBaseDao<ReportType, Integer> implements ReportTypeDao {
    public MySqlReportTypeDao() {
        super(ReportType.class);
    }
}
