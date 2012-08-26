package ar.mmonti.wcm.components;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;

/**
 * @author: mmonti
 */
public class CompositeSplitPanelAdapter extends AbstractCustomComponent implements CompositeSplitPanel {

    private CompositeSplitPanel compositeSplitPanel;

    /**
     *
     * @param compositeSplitPanel
     */
    public CompositeSplitPanelAdapter(CompositeSplitPanel compositeSplitPanel) {
        this.compositeSplitPanel = compositeSplitPanel;
    }

    @Override
    public void setComponent(CompositeSplitPanelImpl.Placement placement, Component component) {
        this.compositeSplitPanel.setComponent(placement,component);
    }

    @Override
    public Component getComponentAt(CompositeSplitPanelImpl.Placement placement) {
        return this.compositeSplitPanel.getComponentAt(placement);
    }

    @Override
    public ComponentContainer getComponentContainerAt(CompositeSplitPanelImpl.Placement placement) {
        return this.compositeSplitPanel.getComponentContainerAt(placement);
    }

    @Override
    public void removeComponentAt(CompositeSplitPanelImpl.Placement placement) {
        this.compositeSplitPanel.removeComponentAt(placement);
    }

    @Override
    public void show(CompositeSplitPanelImpl.Placement placement) {
        this.compositeSplitPanel.show(placement);
    }

    @Override
    public void hide(CompositeSplitPanelImpl.Placement placement) {
        this.compositeSplitPanel.hide(placement);
    }

    @Override
    public void lock(CompositeSplitPanelImpl.Placement placement) {
        this.compositeSplitPanel.lock(placement);
    }

    @Override
    public void unlock(CompositeSplitPanelImpl.Placement placement) {
        this.compositeSplitPanel.unlock(placement);
    }

    @Override
    public Boolean isLocked(CompositeSplitPanelImpl.Placement placement) {
        return this.compositeSplitPanel.isLocked(placement);
    }

    @Override
    public Boolean isVisible(CompositeSplitPanelImpl.Placement placement) {
        return this.compositeSplitPanel.isVisible(placement);
    }
}
