package com.hozom.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hozom.server.domain.Trial;
import com.hozom.server.util.HozomException;
import com.hozom.server.util.SqlUtil;

/**
 * @author Tony
 * 
 */
public class TrialDao {
    private static final Logger LOG = Logger.getLogger(TrialDao.class);

    public Trial findTrial(final String mobilephone) throws HozomException {

        Trial trial = null;

        BaseDao dao = BaseDaoFactory.getInstance().getBaseDao();

        try {
            SqlUtil props = SqlUtil.getInstance();
            List<Object> paras = new ArrayList<Object>();
            paras.add(mobilephone);

            ResultSet rs = dao.querySql(props.getProp("trials.findTrial"),
                    paras);
            if (rs.next()) {
                trial = new Trial(mobilephone, rs.getDate("update_time"), rs
                        .getString("ip_address"));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new HozomException("Wrong in read ResultSet.");
        } finally {
            dao.close();
        }

        return trial;
    }

    /**
     * @param trial
     * @throws HozomException
     */
    public void insertTrial(Trial trial) throws HozomException {
        BaseDao dao = BaseDaoFactory.getInstance().getBaseDao();
        try {
            SqlUtil props = SqlUtil.getInstance();

            List<Object> paras = new ArrayList<Object>();

            paras.add(trial.getMobilephone());
            paras.add(trial.getUpdateTime());
            paras.add(trial.getIpAddress());

            dao.updateSql(props.getProp("trials.insertTrial"), paras);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new HozomException("Update error.");
        } finally {
            dao.close();
        }
    }
}
