package com.hozom.server.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hozom.server.web.action.Command;

/**
 * Dispatch Servlet, dispatch all requests of *.html.
 * 
 * @author tony
 */
public class HozomTrialServlet extends javax.servlet.http.HttpServlet implements
        javax.servlet.Servlet {
    private static final Logger LOG = Logger.getLogger(HozomTrialServlet.class);
    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 8601612699991989280L;

    /**
     * Initial properties of the servlet, from web.xml.
     */
    private Properties initProps = new Properties();

    /**
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public HozomTrialServlet() {
        super();
    }

    /**
     * @see javax.servlet.Servlet#destroy()
     */
    public void destroy() {
        super.destroy();
    }

    /**
     * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
     *      HttpServletResponse response)
     */
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String uri = request.getRequestURI();
        String action = null;
        // 1-normal action, 2-ajax action.
        int actionType = 1;
        int i = uri.lastIndexOf('/');
        if (uri.endsWith("html")) {
            action = uri.substring(i + 1, uri.length() - 5);
        } else if (uri.endsWith("rmt")) {
            action = uri.substring(i + 1, uri.length() - 4);
            actionType = 2;
        }

        if (action == null || action.length() == 0) {
            action = "default";
            actionType = 1;
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("Action is " + action);
        }

        // Execute the command
        String strCommand = initProps.getProperty(action + "Command");
        if (strCommand != null) {
            try {
                Class claCommand = Class.forName(strCommand);
                Command command = (Command) claCommand.newInstance();
                command.execute(request, response);
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
        }

        if (actionType == 1) {
            String pageKey = action + "Page";
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
                pageKey = action + "ErrorPage";
            }
            String strPage = initProps.getProperty(pageKey);

            if (strPage != null) {
                RequestDispatcher dispatcher = getServletContext()
                        .getRequestDispatcher(strPage);
                dispatcher.forward(request, response);
            }
        } else if (actionType == 2) {
            String message = (String) request.getAttribute("message");
            if (message != null && message.trim().length() > 0) {
                PrintWriter out = null;
                try {
                    out = response.getWriter();
                    out.print(message);
                } catch (IOException e) {
                    LOG.error(e.getMessage());
                } finally {
                    if (out != null) {
                        out.close();
                    }
                }
            }
        }
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
     *      HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * @see javax.servlet.GenericServlet#init()
     */
    @SuppressWarnings("unchecked")
    public void init() throws ServletException {
        super.init();
        for (Enumeration en = getInitParameterNames(); en.hasMoreElements();) {
            String name = (String) en.nextElement();
            initProps.put(name, getInitParameter(name));
        }
    }
}
