package ar.mmonti.wcm.events;

import com.vaadin.ui.Window;

/**
 * @author: mmonti
 */
public class WindowEvent extends Event {

    private Class<? extends Window>[] invalidateClasses;

    protected WindowEvent(Class<? extends Window> ... invalidateClasses) {
        this.invalidateClasses = invalidateClasses;
    }

    public Class<? extends Window>[] getInvalidateClasses() {
        return invalidateClasses;
    }
}
