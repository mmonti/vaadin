package ar.mmonti.wcm.events;

import com.vaadin.ui.Window;

import java.io.Serializable;

/**
 * @author: mmonti
 */
public class ChangeWindowEvent extends WindowEvent {

    private Class<? extends Window> windowClass;

    /**
     *
     * @param windowClass
     */
    public ChangeWindowEvent(Class<? extends Window> windowClass, Class<? extends Window> ... invalidateClasses) {
        super(invalidateClasses);
        this.windowClass = windowClass;
    }

    public Class<? extends Window> getWindowClass() {
        return windowClass;
    }

}
