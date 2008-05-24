package com.hozom.server.web.action;

/**
 * @author tony
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class CommandHelper {
    /**
     * @param s
     * @return
     */
    public static boolean isValid(final String s) {
        return (s != null && s.trim().length() > 0);
    }
}
