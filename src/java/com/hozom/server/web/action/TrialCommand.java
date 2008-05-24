package com.hozom.server.web.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hozom.server.domain.Trial;
import com.hozom.server.manager.TrialManager;

/**
 * Command class for try hozom trial. It only saves the data, and no other
 * action.
 * 
 * @author tony
 */
public class TrialCommand implements Command {
    private static final Logger LOG = Logger.getLogger(TrialCommand.class);
    private TrialManager trialManager = new TrialManager();

    /**
     * {@inheritDoc}
     */
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mobilephone = request.getParameter("tryMobilephone");

        if (!CommandHelper.isValid(mobilephone)) {
            request.setAttribute("message", "你的输入有问题，似乎你不是从网页发的请求！");
            LOG.warn("Wrong data input.");
            return;
        }

        Date updateTime = new Date();
        String ipAddress = request.getRemoteAddr();

        try {
            trialManager
                    .addTrial(new Trial(mobilephone, updateTime, ipAddress));
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
