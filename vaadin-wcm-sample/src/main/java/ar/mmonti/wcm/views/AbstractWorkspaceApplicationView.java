package ar.mmonti.wcm.views;

import ar.mmonti.wcm.components.CompositeSplitPanel;
import ar.mmonti.wcm.components.CompositeSplitPanelImpl;
import ar.mmonti.wcm.support.Dimensions;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.VerticalLayout;

/**
 * @author mmonti
 */
public abstract class AbstractWorkspaceApplicationView extends AbstractApplicationView {

    ComponentContainer workspaceView;
    ComponentContainer leftContent;
    ComponentContainer centerContent;
    ComponentContainer rightContent;

    @Override
    public ComponentContainer getViewWorkspace() {
        this.workspaceView = new CompositeSplitPanelImpl();
        this.workspaceView.setSizeFull();

        this.leftContent = getLeftContent();
        this.centerContent = getCenterContent();
        this.leftContent = getRightContent();

        ((CompositeSplitPanel) this.workspaceView).setComponent(CompositeSplitPanelImpl.Placement.LEFT, this.getLeftContent());
        ((CompositeSplitPanel) this.workspaceView).setComponent(CompositeSplitPanelImpl.Placement.CENTER, this.getCenterContent());
        ((CompositeSplitPanel) this.workspaceView).setComponent(CompositeSplitPanelImpl.Placement.RIGHT, this.getRightContent());

        return this.workspaceView;
    }

    public ComponentContainer getLeftContent() {
        return leftContent;
    }

    public ComponentContainer getCenterContent() {
        return centerContent;
    }

    public ComponentContainer getRightContent() {
        return rightContent;
    }
}
