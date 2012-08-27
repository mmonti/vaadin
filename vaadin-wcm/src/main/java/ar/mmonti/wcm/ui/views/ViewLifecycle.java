package ar.mmonti.wcm.ui.views;

import com.vaadin.ui.ComponentContainer;

/**
 * @author mmonti
 */
public interface ViewLifecycle {

    /**
     *
     */
    void initializeLayout();

    /**
     *
     * @param container
     */
    void setContent(ComponentContainer container);

    /**
     *
     */
    void onViewReady();

}
