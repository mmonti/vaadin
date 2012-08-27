package ar.mmonti.wcm.views;

import ar.mmonti.wcm.events.ChangeWindowEvent;
import ar.mmonti.wcm.ui.views.AbstractView;
import ar.mmonti.wcm.ui.views.DefaultViewImpl;
import ar.mmonti.wcm.windows.SecondWindow;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * @author mmonti
 */
public class LoginView extends AbstractView {

    @Override
    public void initializeLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        setLayout(verticalLayout);
    }

    @Override
    public void setContent(ComponentContainer container) {
        Button button = new Button("Button");
        button.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getEventSupport().notifyEvent(new ChangeWindowEvent(SecondWindow.class));
            }
        });

        container.addComponent(button);
    }

}
