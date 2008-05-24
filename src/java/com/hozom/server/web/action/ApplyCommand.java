package com.hozom.server.web.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hozom.server.domain.Applicant;
import com.hozom.server.manager.TrialManager;

/**
 * Command class for application of hozom trial. It only saves the data, and no
 * other action.
 * 
 * @author tony
 */
public class ApplyCommand implements Command {
    private static final Logger LOG = Logger.getLogger(ApplyCommand.class);
    private TrialManager trialManager = new TrialManager();

    /**
     * {@inheritDoc}
     */
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String mobilephone = request.getParameter("mobilephone");

        if (!CommandHelper.isValid(email) || !CommandHelper.isValid(fullName)
                || !CommandHelper.isValid(mobilephone)) {
            request.setAttribute("message", "你的输入有问题，似乎你不是从网页发的请求！");
            LOG.warn("Wrong data input.");
            return;
        }

        Date updateTime = new Date();
        String ipAddress = request.getRemoteAddr();

        try {
            trialManager.addApplicant(new Applicant(email, fullName,
                    mobilephone, updateTime, ipAddress));
            request.setAttribute("message", "Y");

        } catch (Exception e) {
            request.setAttribute("message", "服务器错误，请稍候重试。");
            LOG.error(e.getMessage());
        }
    }

    /**
     * @param trialManager
     *            the trialManager to set.
     */
    public void setTrialManager(TrialManager trialManager) {
        this.trialManager = trialManager;
    }
}
