package ar.mmonti.wcm.app;

import ar.mmonti.wcm.application.AbstractApplication;
import ar.mmonti.wcm.windows.FirstWindow;

/**
 * @author: mmonti
 */
public class WCMApplication extends AbstractApplication {

    @Override
    public void init() {
        super.init();
        getWindowManager().switchWindow(FirstWindow.class);
    }
}
