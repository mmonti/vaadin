package ar.mmonti.wcm.components;

import ar.mmonti.wcm.events.EventSupportAware;
import com.vaadin.ui.CustomComponent;
import ar.mmonti.wcm.application.NotificationSupport;
import ar.mmonti.wcm.events.EventSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: mmonti
 */
public class AbstractCustomComponent extends CustomComponent implements EventSupportAware {

    private static final Logger logger = LoggerFactory.getLogger(AbstractCustomComponent.class);

    private EventSupport eventSupport;

    public EventSupport getEventSupport() {
        return eventSupport;
    }

    @Override
    public void setEventSupport(EventSupport eventSupport) {
        this.eventSupport = eventSupport;
    }
}
