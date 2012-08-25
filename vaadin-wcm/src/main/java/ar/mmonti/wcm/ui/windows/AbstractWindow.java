package ar.mmonti.wcm.ui.windows;

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

    @Override
    public void instantiated() {
        logger.debug("Window Instantiated=[{}]", this.getClass());
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
}
