package ar.mmonti.wcm.windows;

import ar.mmonti.wcm.ui.windows.AbstractWindow;
import com.vaadin.ui.Label;

/**
 * @author: mmonti
 */
public class SecondWindow extends AbstractWindow {

    @Override
    public void instantiated() {
        setCaption("Second Window");
        addComponent(new Label("Second Window."));
    }

}
