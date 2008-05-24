package com.hozom.server.util;

/**
 * @author Tony
 * 
 */
public class HozomException extends Exception {
    private static final long serialVersionUID = 1970050176303742159L;

    public HozomException() {
        super();
    }

    public HozomException(String message) {
        super(message);
    }

    public HozomException(String message, Throwable cause) {
        super(message, cause);
    }

    public HozomException(Throwable cause) {
        super(cause);
    }
}
