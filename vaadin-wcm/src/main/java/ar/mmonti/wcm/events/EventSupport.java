package ar.mmonti.wcm.events;

/**
 * @author: mmonti
 */
public interface EventSupport {

    /**
     *
     * @param object
     */
    void notifyEvent(Object object);

    /**
     *
     * @param eventHandler
     */
    void registerEventHandler(Object eventHandler);

    /**
     *
     * @param eventHandler
     */
    void unregisterEventHandler(Object eventHandler);

}