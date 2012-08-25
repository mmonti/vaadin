package ar.mmonti.wcm.spring;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author: mmonti
 */
public class ComponentFactoryBean implements BeanFactoryAware {

    private static final Logger logger = LoggerFactory.getLogger(ComponentFactoryBean.class);

    private BeanFactory beanFactory;

    /**
     *
     * @param beanFactory
     * @throws org.springframework.beans.BeansException
     */
    @Override
    public void setBeanFactory(final BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     *
     * @param beanClass
     * @param <T>
     * @return
     */
    public <T> T getInstance(final Class<? extends T> beanClass) {
        final T beanInstance = this.beanFactory.getBean(beanClass);
        return beanInstance;
    }

    /**
     *
     * @param beanPostProcessor
     */
    public void registerPostProcessor(BeanPostProcessor beanPostProcessor) {
        Preconditions.checkNotNull(beanPostProcessor);
        ((ConfigurableListableBeanFactory) this.beanFactory).addBeanPostProcessor(beanPostProcessor);
    }

}
