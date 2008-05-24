package com.hozom.server.dao;

import java.util.Date;

import org.apache.log4j.Logger;

import com.hozom.server.domain.Trial;

import junit.framework.TestCase;

/**
 * @author tony
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class TrialDaoTest extends TestCase {
    private static final Logger LOG = Logger.getLogger(ApplicantDaoTest.class);
    private TrialDao testTarget;

    /**
     * {@inheritDoc}
     */
    protected void setUp() throws Exception {
        testTarget = new TrialDao();
    }

    /**
     * Test method for
     * {@link com.hozom.server.dao.TrialDao#insertTrial(com.hozom.server.domain.Trial)}.
     */
    public void testInsertAndFindTrial() throws Exception {
        try {
            Trial trial = new Trial("13777474748", new Date(), "12.2.2.3");
            testTarget.insertTrial(trial);
            Trial ra = testTarget.findTrial("13777474748");
            assertEquals(trial.getIpAddress(), ra.getIpAddress());
            assertEquals(trial.getMobilephone(), ra.getMobilephone());
        } catch (Exception e) {
            LOG.error(e.getMessage());
            fail();
        }
    }

}
