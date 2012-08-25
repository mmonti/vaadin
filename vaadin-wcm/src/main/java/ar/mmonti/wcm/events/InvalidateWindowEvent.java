package ar.mmonti.wcm.events;

import com.vaadin.ui.Window;

import java.io.Serializable;

/**
 * @author: mmonti
 */
public class InvalidateWindowEvent implements Serializable {

    private static final long serialVersionUID = 8661185996846109139L;

    private Class<? extends Window>[] classesToInvalidate;

    /**
     * Invalidate the Window class received as parameter.
     *
     * @param classesToInvalidate
     */
    public InvalidateWindowEvent(Class<? extends Window> ... classesToInvalidate) {
        this.classesToInvalidate = classesToInvalidate;
    }

    public Class<? extends Window>[] getClassesToInvalidate() {
        return classesToInvalidate;
    }
}
