package ar.mmonti.wcm.ui.impl;

import com.google.common.base.Preconditions;
import com.google.common.eventbus.EventBus;
import com.vaadin.Application;
import com.vaadin.ui.Window;
import ar.mmonti.wcm.events.EventSupport;
import ar.mmonti.wcm.events.EventSupportImpl;
import ar.mmonti.wcm.spring.ComponentFactoryBean;
import ar.mmonti.wcm.spring.EventSupportBeanPostProcessor;
import ar.mmonti.wcm.ui.WindowManager;
import ar.mmonti.wcm.ui.contents.Content;
import ar.mmonti.wcm.ui.windows.WindowLifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: mmonti
 */
public class WindowManagerImpl implements WindowManager {

    private static final Logger logger = LoggerFactory.getLogger(WindowManagerImpl.class);

    private Application application;
    private ComponentFactoryBean componentFactoryBean;

    private Class<? extends Window> currentWindowClassRef;

    private Map<Class<? extends Window>, Window> registeredWindows;
    private Map<Class<? extends Content>, Content> registeredWorkspaces;

    private EventSupport eventSupport;

    /**
     *
     * @param application
     */
    public void init(Application application) {
        this.application = application;

        this.eventSupport = new EventSupportImpl(new EventBus());
        this.eventSupport.registerEventHandler(new WindowManagerEventHandlerImpl(this));

        this.componentFactoryBean.registerPostProcessor(new EventSupportBeanPostProcessor(this.eventSupport));

        this.registeredWindows = new ConcurrentHashMap<Class<? extends Window>, Window>();
        this.registeredWorkspaces = new ConcurrentHashMap<Class<? extends Content>, Content>();
    }

    /**
     *
     * @param windowClassRef
     * @return
     */
    private Window getWindowInstance(Class<? extends Window> windowClassRef) {
        Preconditions.checkNotNull(windowClassRef);

        final Boolean existent = this.registeredWindows.containsKey(windowClassRef);
        Window windowInstance = null;
        if (existent) {
            windowInstance = this.registeredWindows.get(windowClassRef);

            ((WindowLifecycle) windowInstance).loaded();

        } else {
            windowInstance = componentFactoryBean.getInstance(windowClassRef);

            if (windowInstance != null) {
                this.registeredWindows.put(windowClassRef, windowInstance);
            }

            ((WindowLifecycle) windowInstance).instantiated();
        }
        return windowInstance;
    }

    /**
     *
     * @param windowInstance
     */
    private void setWindow(Window windowInstance) {
        if (this.application.getMainWindow() != null) {
            this.application.removeWindow(this.application.getMainWindow());
        }
        this.application.setMainWindow(windowInstance);
        this.currentWindowClassRef = windowInstance.getClass();
    }

    /**
     *
     * @param windowClassRef
     */
    @Override
    public void switchWindow(Class<? extends Window> windowClassRef) {
        Preconditions.checkNotNull(windowClassRef);

        final Window windowInstance = getWindowInstance(windowClassRef);
        setWindow(windowInstance);
    }

    /**
     *
     * @param windowClassRefToInvalidate
     */
    @Override
    public void invalidate(Class<? extends Window> ... windowClassRefToInvalidate) {
        Preconditions.checkNotNull(windowClassRefToInvalidate);

        for (final Class<? extends Window> currentWindowRef : windowClassRefToInvalidate) {
            this.registeredWindows.remove(currentWindowRef);
        }
    }

    /**
     *
     * @param componentFactoryBean
     */
    public void setComponentFactoryBean(ComponentFactoryBean componentFactoryBean) {
        this.componentFactoryBean = componentFactoryBean;
    }
}
