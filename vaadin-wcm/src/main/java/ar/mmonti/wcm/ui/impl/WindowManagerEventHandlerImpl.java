package ar.mmonti.wcm.ui.impl;

import com.google.common.eventbus.Subscribe;
import ar.mmonti.wcm.events.ChangeWindowEvent;
import ar.mmonti.wcm.events.InvalidateWindowEvent;
import ar.mmonti.wcm.ui.WindowManager;
import ar.mmonti.wcm.ui.WindowManagerEventHandler;

/**
 * @author: mmonti
 */
public class WindowManagerEventHandlerImpl implements WindowManagerEventHandler {

    /**
     * Window Manager Reference.
     */
    private WindowManager windowManager;

    /**
     *
     * @param windowManager
     */
    public WindowManagerEventHandlerImpl(WindowManager windowManager) {
        this.windowManager = windowManager;
    }

    @Override
    @Subscribe
    public void changeWindowEventHandler(ChangeWindowEvent changeWindowEvent) {
        this.windowManager.switchWindow(changeWindowEvent.getWindowClass());
    }

    @Override
    @Subscribe
    public void invalidateWindowEventHandler(InvalidateWindowEvent invalidateWindowEvent) {
        this.windowManager.invalidate(invalidateWindowEvent.getClassesToInvalidate());
    }
}
