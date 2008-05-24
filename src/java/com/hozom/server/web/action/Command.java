package com.hozom.server.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command interface.
 * 
 * @author Tony
 */
public interface Command {
    /**
     * Command interface, the request can be configured to invoke the
     * corresponding method
     * <code>execute(HttpServletRequest, HttpServletResponse)</code> in
     * <code>web.xml</code>. The automatic invoking logic is implemented in
     * <code>DispatchServlet</code>.
     * 
     * @param request
     *            Http request object.
     * @param response
     *            Http response object.
     * @throws ServletException
     *             Servlet Exception.
     * @throws IOException
     *             IO Exception.
     */
    void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
