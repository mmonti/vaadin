package ar.mmonti.wcm.ui;

import ar.mmonti.wcm.events.ChangeWindowEvent;
import ar.mmonti.wcm.events.InvalidateWindowEvent;

/**
 * @author: mmonti
 */
public interface WindowManagerEventHandler {

    /**
     *
     * @param changeWindowEvent
     */
    void changeWindowEventHandler(ChangeWindowEvent changeWindowEvent);

    /**
     *
     * @param invalidateWindowEvent
     */
    void invalidateWindowEventHandler(InvalidateWindowEvent invalidateWindowEvent);

}
