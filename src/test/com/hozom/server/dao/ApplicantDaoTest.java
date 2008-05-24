package com.hozom.server.dao;

import java.util.Date;

import org.apache.log4j.Logger;

import com.hozom.server.domain.Applicant;

import junit.framework.TestCase;

public class ApplicantDaoTest extends TestCase {
    private static final Logger LOG = Logger.getLogger(ApplicantDaoTest.class);
    private ApplicantDao testTarget;

    protected void setUp() throws Exception {
        testTarget = new ApplicantDao();
    }

    public void testInsertAndFindApplicant() throws Exception {
        try {
            Applicant applicant = new Applicant("a@b.c", "tony", "13777474748",
                    new Date(), "10.10.10.2");
            testTarget.insertApplicant(applicant);
            Applicant ra = testTarget.findApplicant("13777474748");
            assertEquals(applicant.getEmail(), ra.getEmail());
            assertEquals(applicant.getMobilephone(), ra.getMobilephone());
        } catch (Exception e) {
            LOG.error(e.getMessage());
            fail();
        }
    }

}
