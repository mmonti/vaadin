package ar.mmonti.wcm.exceptions;

/**
 * @author: mmonti
 */
public class CannotSwitchWindowException extends RuntimeException {

    private static final long serialVersionUID = 5106346264578886837L;

    /**
     *
     * @param message
     */
    public CannotSwitchWindowException(String message) {
        super(message);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public CannotSwitchWindowException(String message, Throwable cause) {
        super(message, cause);
    }

}
