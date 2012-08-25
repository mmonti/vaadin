package ar.mmonti.wcm.ui.contents;

import com.vaadin.ui.CustomComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: mmonti
 */
public class AbstractContent extends CustomComponent implements Content, ContentLifecycle {

    private static final Logger logger = LoggerFactory.getLogger(AbstractContent.class);

    @Override
    public void instantiated() {
        logger.debug("Workspace Instantiated=[{}]", this.getClass());
    }
}
