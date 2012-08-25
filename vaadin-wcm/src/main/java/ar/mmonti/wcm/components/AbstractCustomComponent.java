package ar.mmonti.wcm.components;

import com.vaadin.ui.CustomComponent;
import ar.mmonti.wcm.application.NotificationSupport;
import ar.mmonti.wcm.events.EventSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: mmonti
 */
public class AbstractCustomComponent extends CustomComponent {

    private static final Logger logger = LoggerFactory.getLogger(AbstractCustomComponent.class);

    @Autowired
    private EventSupport eventSupport;

    @Autowired
    private NotificationSupport notificationSupport;

    public EventSupport getEventSupport() {
        return eventSupport;
    }

    public NotificationSupport getNotificationSupport() {
        return notificationSupport;
    }
}
