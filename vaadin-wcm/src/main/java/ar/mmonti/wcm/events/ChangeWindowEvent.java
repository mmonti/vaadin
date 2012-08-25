package ar.mmonti.wcm.events;

import com.vaadin.ui.Window;

import java.io.Serializable;

/**
 * @author: mmonti
 */
public class ChangeWindowEvent implements Serializable {

    private static final long serialVersionUID = -2890919100757579891L;

    private Class<? extends Window> windowClass;
    private Class<? extends Window>[] invalidateClasses;

    /**
     *
     * @param windowClass
     */
    public ChangeWindowEvent(Class<? extends Window> windowClass, Class<? extends Window> ... invalidateClasses) {
        this.windowClass = windowClass;
        this.invalidateClasses = invalidateClasses;
    }

    public Class<? extends Window> getWindowClass() {
        return windowClass;
    }

    public Class<? extends Window>[] getInvalidateClasses() {
        return invalidateClasses;
    }
}
