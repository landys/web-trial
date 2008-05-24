package com.hozom.server.manager;

import com.hozom.server.dao.ApplicantDao;
import com.hozom.server.dao.TrialDao;
import com.hozom.server.domain.Applicant;
import com.hozom.server.domain.Trial;
import com.hozom.server.util.Assert;
import com.hozom.server.util.HozomException;

/**
 * The class does everything of the application, including database access,
 * application logic, etc.
 * 
 * @author tony
 */
public class TrialManager {

    /**
     * @param applicant
     */
    public void addApplicant(final Applicant applicant) throws HozomException {
        Assert.notNull(applicant, "The object cannot be null.");

        ApplicantDao dao = new ApplicantDao();
        dao.insertApplicant(applicant);
    }

    /**
     * @param trial
     */
    public void addTrial(final Trial trial) throws HozomException {
        Assert.notNull(trial, "The object cannot be null.");

        TrialDao dao = new TrialDao();
        dao.insertTrial(trial);
    }
}
