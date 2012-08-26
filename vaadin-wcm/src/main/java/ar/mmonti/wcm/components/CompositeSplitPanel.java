package ar.mmonti.wcm.components;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;

/**
 * @author: mmonti
 */
public interface CompositeSplitPanel extends ComponentContainer {

    /**
     *
     * @param placement
     * @param component
     */
    void setComponent(CompositeSplitPanelImpl.Placement placement, Component component);

    /**
     *
     * @param placement
     * @return
     */
    Component getComponentAt(CompositeSplitPanelImpl.Placement placement);

    /**
     *
     * @param placement
     * @return
     */
    ComponentContainer getComponentContainerAt(CompositeSplitPanelImpl.Placement placement);

    /**
     *
     * @param placement
     */
    void removeComponentAt(CompositeSplitPanelImpl.Placement placement);

    /**
     *
     * @param placement
     */
    void show(CompositeSplitPanelImpl.Placement placement);

    /**
     *
     * @param placement
     */
    void hide(CompositeSplitPanelImpl.Placement placement);

    /**
     *
     * @param placement
     */
    void lock(CompositeSplitPanelImpl.Placement placement);

    /**
     *
     * @param placement
     */
    void unlock(CompositeSplitPanelImpl.Placement placement);

    /**
     *
     * @param placement
     * @return
     */
    Boolean isLocked(CompositeSplitPanelImpl.Placement placement);

    /**
     *
     * @param placement
     * @return
     */
    Boolean isVisible(CompositeSplitPanelImpl.Placement placement);

}
