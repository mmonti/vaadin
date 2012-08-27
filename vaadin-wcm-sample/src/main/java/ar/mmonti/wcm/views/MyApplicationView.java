package ar.mmonti.wcm.views;

import ar.mmonti.wcm.components.CompositeSplitPanel;
import ar.mmonti.wcm.components.CompositeSplitPanelImpl;
import ar.mmonti.wcm.support.Dimensions;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;

/**
 * @author mmonti
 */
public class MyApplicationView extends AbstractWorkspaceApplicationView {

    @Override
    public ComponentContainer getLeftContent() {
        ComponentContainer layout = new VerticalLayout();
        layout.setWidth(Dimensions.VALUE_250, Sizeable.UNITS_PIXELS);

        Button showRight = new Button("ShowRight");
        showRight.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                System.out.println("showing right");
            }
        });
        layout.addComponent(showRight);

        return layout;
    }

    @Override
    public ComponentContainer getCenterContent() {
        Panel panel = new Panel("Content");
        panel.setSizeFull();

        ComponentContainer layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.addComponent(panel);

        return layout;
    }
}
