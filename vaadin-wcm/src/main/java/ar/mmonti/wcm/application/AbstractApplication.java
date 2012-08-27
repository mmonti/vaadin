package ar.mmonti.wcm.application;

import com.vaadin.Application;
import ar.mmonti.wcm.ui.WindowManager;
import ar.mmonti.wcm.ui.impl.WindowManagerImpl;

/**
 * @author: mmonti
 */
public abstract class AbstractApplication extends Application {

    private WindowManager windowManager;

    @Override
    public void init() {
        ((WindowManagerImpl) this.windowManager).init(this);
    }

    public void setWindowManager(WindowManager windowManager) {
        this.windowManager = windowManager;
    }

    public WindowManager getWindowManager() {
        return windowManager;
    }

}
