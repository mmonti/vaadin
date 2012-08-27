package ar.mmonti.wcm.views;

import ar.mmonti.wcm.support.Dimensions;
import ar.mmonti.wcm.ui.layouts.DockLayout;
import ar.mmonti.wcm.ui.layouts.Region;
import ar.mmonti.wcm.ui.views.AbstractView;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author mmonti
 */
public abstract class AbstractApplicationView extends AbstractView {

    private ComponentContainer viewHeader;
    private ComponentContainer viewWorkspace;
    private ComponentContainer viewStatus;

    @Override
    public void initializeLayout() {
        setSizeFull();
        setWidth(Dimensions.VALUE_100, Sizeable.UNITS_PERCENTAGE);
        setHeight(Dimensions.VALUE_100, Sizeable.UNITS_PERCENTAGE);

        ComponentContainer layout = new DockLayout();
        layout.setSizeFull();

        setLayout(layout);
    }

    @Override
    public void setContent(ComponentContainer container) {
        this.viewHeader = getViewHeader();
        this.viewWorkspace = getViewWorkspace();
        this.viewStatus = getViewStatus();

        setWorkspaceContent(viewWorkspace);

        ((DockLayout) container).addComponent(viewHeader, Region.TOP);
        ((DockLayout) container).addComponent(viewWorkspace, Region.CENTER);
        ((DockLayout) container).addComponent(viewStatus, Region.BOTTOM);
    }

    public ComponentContainer getViewHeader() {
        ComponentContainer viewHeader = new HorizontalLayout();
        viewHeader.setHeight(Dimensions.VALUE_80, Sizeable.UNITS_PIXELS);
        viewHeader.addComponent(new Label("HEADER"));

        return viewHeader;
    }

    public ComponentContainer getViewWorkspace() {
        ComponentContainer viewWorkspace = new HorizontalLayout();
        viewWorkspace.setSizeFull();
        viewWorkspace.setHeight(Dimensions.VALUE_100, Sizeable.UNITS_PERCENTAGE);

        return viewWorkspace;
    }

    public ComponentContainer getViewStatus() {
        ComponentContainer viewStatus = new HorizontalLayout();
        viewStatus.setHeight(Dimensions.VALUE_40, Sizeable.UNITS_PIXELS);
        viewStatus.addComponent(new Label("STATUS"));

        return viewStatus;
    }

    public void setWorkspaceContent(ComponentContainer viewWorkspace) {}

}
