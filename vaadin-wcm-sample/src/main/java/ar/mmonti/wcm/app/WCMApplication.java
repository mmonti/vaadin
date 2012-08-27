package ar.mmonti.wcm.app;

import ar.mmonti.wcm.application.AbstractApplication;
import ar.mmonti.wcm.views.LoginView;
import ar.mmonti.wcm.windows.FirstWindow;
import ar.mmonti.wcm.windows.LoginWindow;

/**
 * @author: mmonti
 */
public class WCMApplication extends AbstractApplication {

    @Override
    public void init() {
        super.init();
        getWindowManager().switchWindow(LoginWindow.class);
    }
}
