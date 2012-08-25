package ar.mmonti.wcm.events;

import com.google.common.eventbus.EventBus;

/**
 * @author: mmonti
 */
public class EventSupportImpl implements EventSupport {

    private EventBus eventBus;

    /**
     *
     * @param eventBus
     */
    public EventSupportImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    /**
     *
     * @param object
     */
    @Override
    public void notifyEvent(Object object) {
        this.eventBus.post(object);
    }

    /**
     *
     * @param eventHandler
     */
    @Override
    public void registerEventHandler(Object eventHandler) {
        this.eventBus.register(eventHandler);
    }

    /**
     *
     * @param eventHandler
     */
    @Override
    public void unregisterEventHandler(Object eventHandler) {
        this.eventBus.unregister(eventHandler);
    }
}
