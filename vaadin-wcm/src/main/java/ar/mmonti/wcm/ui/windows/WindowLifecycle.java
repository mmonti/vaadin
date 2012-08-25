package ar.mmonti.wcm.ui.windows;

/**
 * @author: mmonti
 */
public interface WindowLifecycle {

    /**
     * * Called each time that a Window is retrieved from the WindowManager registry.
     */
    void loaded();

    /**
     * Called each time that a Window is retrieved using the bean factory (new instance created).
     */
    void instantiated();

}
