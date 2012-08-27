package ar.mmonti.wcm.ui.windows;

import ar.mmonti.wcm.support.Dimensions;
import ar.mmonti.wcm.support.Initializable;
import ar.mmonti.wcm.ui.views.AbstractView;
import ar.mmonti.wcm.ui.views.DefaultViewImpl;
import ar.mmonti.wcm.ui.views.View;
import ar.mmonti.wcm.ui.views.ViewLifecycle;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Window;
import ar.mmonti.wcm.events.EventSupport;
import ar.mmonti.wcm.events.EventSupportAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author: mmonti
 */
public abstract class AbstractWindow extends Window implements WindowLifecycle, EventSupportAware {

    private static final Logger logger = LoggerFactory.getLogger(AbstractWindow.class);

    private EventSupport eventSupport;
    private View view;

    @Override
    public void initializeWindow() {
        logger.debug("Initializing Window=[{}]", this);
        if (this.view == null) {
            this.view = new DefaultViewImpl();
        }

        this.setSizeFull();
        this.setWidth(Dimensions.VALUE_100, Sizeable.UNITS_PERCENTAGE);
        this.setHeight(Dimensions.VALUE_100, Sizeable.UNITS_PERCENTAGE);

        this.setContent(this.view);
    }

    @Override
    public void initializeView() {
        logger.debug("Initializing View=[{}]", this.getView());

        ((ViewLifecycle) this.getView()).initializeLayout();

        ComponentContainer viewLayout = ((AbstractView) this.getView()).getLayout();
        ((ViewLifecycle) this.getView()).setContent(viewLayout);

        ((ViewLifecycle) this.getView()).onViewReady();
    }

    @Override
    public void loaded() {
        logger.debug("Window Loaded=[{}]", this.getClass());
    }

    @Override
    public void setEventSupport(EventSupport eventSupport) {
        this.eventSupport = eventSupport;
    }

    public EventSupport getEventSupport() {
        return eventSupport;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
