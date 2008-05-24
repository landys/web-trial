package com.hozom.server.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hozom.server.domain.Applicant;
import com.hozom.server.util.HozomException;
import com.hozom.server.util.SqlUtil;

/**
 * @author Tony
 * 
 */
public class ApplicantDao {
    private static final Logger LOG = Logger.getLogger(ApplicantDao.class);

    /**
     * @param mobilephone
     * @return
     * @throws HozomException
     */
    public Applicant findApplicant(final String mobilephone)
            throws HozomException {

        Applicant applicant = null;

        BaseDao dao = BaseDaoFactory.getInstance().getBaseDao();

        try {
            SqlUtil props = SqlUtil.getInstance();
            List<Object> paras = new ArrayList<Object>();
            paras.add(mobilephone);

            ResultSet rs = dao.querySql(props
                    .getProp("applicants.findApplicant"), paras);
            if (rs.next()) {
                applicant = new Applicant(rs.getString("email"), rs
                        .getString("full_name"), mobilephone, rs
                        .getDate("update_time"), rs.getString("ip_address"));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new HozomException("Wrong in read ResultSet.");
        } finally {
            dao.close();
        }

        return applicant;
    }

    /**
     * @param trial
     * @throws HozomException
     */
    public void insertApplicant(final Applicant applicant)
            throws HozomException {
        BaseDao dao = BaseDaoFactory.getInstance().getBaseDao();
        try {
            SqlUtil props = SqlUtil.getInstance();

            List<Object> paras = new ArrayList<Object>();
            paras.add(applicant.getEmail());
            paras.add(applicant.getFullName());
            paras.add(applicant.getMobilephone());
            paras.add(applicant.getUpdateTime());
            paras.add(applicant.getIpAddress());

            dao.updateSql(props.getProp("applicants.insertApplicant"), paras);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new HozomException("Update error.");
        } finally {
            dao.close();
        }
    }
}
