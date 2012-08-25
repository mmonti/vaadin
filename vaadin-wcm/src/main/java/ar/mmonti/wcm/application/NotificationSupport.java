package ar.mmonti.wcm.application;

/**
 * @author: mmonti
 */
public interface NotificationSupport {

    /**
     *
     * @param caption
     */
    void showNotification(String caption);

    /**
     *
     * @param caption
     * @param type
     */
    void showNotification(String caption, int type);

}
