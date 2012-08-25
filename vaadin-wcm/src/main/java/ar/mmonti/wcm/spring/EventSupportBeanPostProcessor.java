package ar.mmonti.wcm.spring;

import ar.mmonti.wcm.events.EventSupport;
import ar.mmonti.wcm.events.EventSupportAware;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: mmonti
 */
public class EventSupportBeanPostProcessor implements BeanPostProcessor {

    private EventSupport eventSupport;

    /**
     *
     * @param eventSupport
     */
    public EventSupportBeanPostProcessor(EventSupport eventSupport) {
        this.eventSupport = eventSupport;
    }

    /**
     *
     * @param bean
     * @param beanName
     * @return
     * @throws org.springframework.beans.BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (this.eventSupport != null && bean instanceof EventSupportAware) {
            ((EventSupportAware) bean).setEventSupport(this.eventSupport);
        }
        return bean;
    }

    /**
     *
     * @param bean
     * @param beanName
     * @return
     * @throws org.springframework.beans.BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
