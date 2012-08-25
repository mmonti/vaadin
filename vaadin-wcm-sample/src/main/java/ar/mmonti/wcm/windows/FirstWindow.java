package ar.mmonti.wcm.windows;

import ar.mmonti.wcm.events.ChangeWindowEvent;
import ar.mmonti.wcm.ui.windows.AbstractWindow;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;

/**
 * @author: mmonti
 */
public class FirstWindow extends AbstractWindow {

    @Override
    public void instantiated() {
        setCaption("First Window");

        Button button = new Button("Show next window");
        button.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getEventSupport().notifyEvent(new ChangeWindowEvent(SecondWindow.class));
            }
        });

        addComponent(new Label("First Window."));
        addComponent(button);
    }
}
