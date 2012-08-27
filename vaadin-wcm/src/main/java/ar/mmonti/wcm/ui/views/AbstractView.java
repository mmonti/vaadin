package ar.mmonti.wcm.ui.views;

import ar.mmonti.wcm.components.AbstractCustomComponent;
import ar.mmonti.wcm.events.EventSupport;
import ar.mmonti.wcm.events.EventSupportAware;
import ar.mmonti.wcm.support.Dimensions;
import ar.mmonti.wcm.support.Initializable;
import com.google.common.base.Preconditions;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mmonti
 */
public abstract class AbstractView extends AbstractCustomComponent implements View, ViewLifecycle {

    private static final Logger logger = LoggerFactory.getLogger(AbstractView.class);

    private ComponentContainer layout;

    @Override
    public void initializeLayout() {
        logger.debug("Initializing Layout=[{}]", this);
        if (this.layout == null) {
            this.layout = new VerticalLayout();
        }

        this.setSizeFull();
        this.setWidth(Dimensions.VALUE_100, Sizeable.UNITS_PERCENTAGE);
        this.setHeight(Dimensions.VALUE_100, Sizeable.UNITS_PERCENTAGE);
    }

    @Override
    public void setContent(ComponentContainer container) {
        logger.debug("Setting content in the view=[{}]", this);
    }

    @Override
    public void onViewReady() {
        logger.debug("Setting root object=[{}]", this);

        Preconditions.checkState(this.layout != null, "Layout cannot be null.");
        this.setCompositionRoot(this.layout);
    }

    public ComponentContainer getLayout() {
        return layout;
    }

    public void setLayout(ComponentContainer layout) {
        this.layout = layout;
    }
}
