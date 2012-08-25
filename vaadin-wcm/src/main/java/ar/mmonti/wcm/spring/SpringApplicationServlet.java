package ar.mmonti.wcm.spring;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * @author mauro.monti
 */
public class SpringApplicationServlet extends AbstractApplicationServlet {

    private static final long serialVersionUID = 2804211527780248792L;

    private static final Logger logger = LoggerFactory.getLogger(SpringApplicationServlet.class);

    private static final String DEFAULT_APPLICATION_BEAN_NAME = "application";
    private static final String INIT_PARAM = "applicationBeanName";
    private String name;
    private WebApplicationContext applicationContext;

    /**
     * @param servletConfig
     * @throws javax.servlet.ServletException
     */
    @Override
    public void init(final ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        final String name = servletConfig.getInitParameter(INIT_PARAM);
        this.name = (name == null) ? DEFAULT_APPLICATION_BEAN_NAME : name;

        final ServletContext servletContext = servletConfig.getServletContext();
        final WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        if (applicationContext == null) {
            throw new ServletException("Cannot initialize WebApplicationContext");
        } else {
            this.applicationContext = applicationContext;
        }
    }

    /**
     * @param request
     * @return
     * @throws javax.servlet.ServletException
     */
    @Override
    protected Application getNewApplication(final HttpServletRequest request) throws ServletException {
        final Object bean = this.applicationContext.getBean(name);
        if (!(bean instanceof Application)) {
            throw new ServletException("Bean " + name + " is not of expected class Application");
        }
        return (Application) bean;
    }

    /**
     * @return
     * @throws ClassNotFoundException
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
        final Object bean = applicationContext.getBean(name);
        if (bean == null) {
            throw new ClassNotFoundException("No application bean found under name " + name);
        }
        return (Class) bean.getClass();
    }
}