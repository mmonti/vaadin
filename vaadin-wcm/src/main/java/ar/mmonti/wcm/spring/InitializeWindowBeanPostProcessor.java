package ar.mmonti.wcm.spring;

import ar.mmonti.wcm.ui.windows.WindowLifecycle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author mmonti
 */
public class InitializeWindowBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof WindowLifecycle) {
            ((WindowLifecycle) bean).initializeWindow();
        }
        return bean;
    }

}
