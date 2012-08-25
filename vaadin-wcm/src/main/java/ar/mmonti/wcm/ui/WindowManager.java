package ar.mmonti.wcm.ui;

import com.vaadin.ui.Window;

/**
 * @author: mmonti
 */
public interface WindowManager {

    /**
     * Change the current Window by the one passed as parameter.
     *
     * @param windowClassRef
     */
    void switchWindow(Class<? extends Window> windowClassRef);

    /**
     * Removes from the Window Register, the classes received as parameter.
     *
     * @param classesToInvalidate
     */
    void invalidate(Class<? extends Window>... classesToInvalidate);

}
