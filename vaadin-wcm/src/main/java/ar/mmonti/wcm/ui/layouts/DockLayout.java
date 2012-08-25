package ar.mmonti.wcm.ui.layouts;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import ar.mmonti.wcm.support.Dimensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

/**
 * @author: mmonti
 */
public class DockLayout extends VerticalLayout {

    private static final Logger logger = LoggerFactory.getLogger(DockLayout.class);

    private static final String BLANK = "";
    private static final String DEFAULT_MINIMUM_HEIGHT = Dimensions.getSize(Dimensions.VALUE_50, Sizeable.UNITS_PIXELS);

    private String minimumNorthHeight = DEFAULT_MINIMUM_HEIGHT;
    private String minimumSouthHeight = DEFAULT_MINIMUM_HEIGHT;
    private String minimumWestWidth = DEFAULT_MINIMUM_HEIGHT;
    private String minimumEastWidth = DEFAULT_MINIMUM_HEIGHT;

    private VerticalLayout mainLayout;
    private HorizontalLayout centerLayout;

    protected Component north = new Label(BLANK);
    protected Component west = new Label(BLANK);
    protected Component center = new Label(BLANK);
    protected Component east = new Label(BLANK);
    protected Component south = new Label(BLANK);

    /**
     * Create a layout structure that mimics the traditional
     * {@link java.awt.BorderLayout}.
     */
    public DockLayout() {
        centerLayout = new HorizontalLayout();
        centerLayout.addComponent(west);
        centerLayout.addComponent(center);
        centerLayout.addComponent(east);
        centerLayout.setSizeFull();

        mainLayout = new VerticalLayout();
        mainLayout.addComponent(north);
        mainLayout.addComponent(centerLayout);
        mainLayout.addComponent(south);
        mainLayout.setExpandRatio(centerLayout, 1);

        super.setWidth(Dimensions.VALUE_100, UNITS_PERCENTAGE);
        super.addComponent(mainLayout);
    }

    @Override
    public void setWidth(String width) {
        if (mainLayout == null) {
            return;
        }
        mainLayout.setWidth(width);
        centerLayout.setExpandRatio(center, 1);
        requestRepaint();
    }

    @Override
    public void setHeight(String height) {
        mainLayout.setHeight(height);
        west.setHeight(Dimensions.VALUE_100, UNITS_PERCENTAGE);
        center.setHeight(Dimensions.VALUE_100, UNITS_PERCENTAGE);
        east.setHeight(Dimensions.VALUE_100, UNITS_PERCENTAGE);
        centerLayout.setExpandRatio(center, 1);
        requestRepaint();
    }

    @Override
    public void setSizeFull() {
        super.setSizeFull();
        mainLayout.setSizeFull();
        centerLayout.setExpandRatio(center, 1);
        requestRepaint();
    }

    @Override
    public void setMargin(boolean margin) {
        mainLayout.setMargin(margin);
        requestRepaint();
    }

    @Override
    public void setSpacing(boolean spacing) {
        mainLayout.setSpacing(spacing);
        centerLayout.setSpacing(spacing);
        requestRepaint();
    }

    @Override
    public boolean isSpacing() {
        return (mainLayout.isSpacing() && centerLayout.isSpacing());
    }

    @Override
    public void removeComponent(Component c) {
        replaceComponent(c, new Label(""));
    }

    /**
     * Add component into borderlayout
     *
     * @param component
     *            component to be added into layout
     * @param region
     *            place of the component (have to be on of DockLayout.NORTH,
     *            DockLayout.WEST, DockLayout.CENTER, DockLayout.EAST, or
     *            DockLayout.SOUTH
     */
    public void addComponent(Component component, Region region) {
        if (region == Region.TOP) {
            mainLayout.replaceComponent(north, component);
            north = component;

            if (north.getHeight() < 0 || north.getHeightUnits() == UNITS_PERCENTAGE) {
                north.setHeight(minimumNorthHeight);
            }

        } else if (region == Region.LEFT) {
            centerLayout.replaceComponent(west, component);
            west = component;

            if (west.getWidth() < 0 || west.getWidthUnits() == UNITS_PERCENTAGE) {
                west.setWidth(minimumWestWidth);
            }

        } else if (region == Region.CENTER) {
            centerLayout.replaceComponent(center, component);
            center = component;
            center.setHeight(centerLayout.getHeight(), centerLayout.getHeightUnits());
            center.setWidth(Dimensions.VALUE_100, UNITS_PERCENTAGE);
            centerLayout.setExpandRatio(center, 1);

        } else if (region == Region.RIGHT) {
            centerLayout.replaceComponent(east, component);
            east = component;
            if (east.getWidth() < 0 || east.getWidthUnits() == UNITS_PERCENTAGE) {
                east.setWidth(minimumEastWidth);
            }

        } else if (region == Region.BOTTOM) {
            mainLayout.replaceComponent(south, component);
            south = component;
            if (south.getHeight() < 0 || south.getHeightUnits() == UNITS_PERCENTAGE) {
                south.setHeight(minimumSouthHeight);
            }

        } else {
            throw new IllegalArgumentException("Invalid DockLayout constraint.");
        }
        centerLayout.setExpandRatio(center, 1);
        requestRepaint();
    }

    @Override
    public void addComponent(Component c) {
        throw new IllegalArgumentException("Component constraint have to be specified");
    }

    @Override
    public void replaceComponent(Component oldComponent, Component newComponent) {
        if (oldComponent == north) {
            mainLayout.replaceComponent(north, newComponent);
            north = newComponent;

        } else if (oldComponent == west) {
            centerLayout.replaceComponent(west, newComponent);
            west = newComponent;

        } else if (oldComponent == center) {
            centerLayout.replaceComponent(center, newComponent);
            centerLayout.setExpandRatio(newComponent, 1);
            center = newComponent;

        } else if (oldComponent == east) {
            centerLayout.replaceComponent(east, newComponent);
            east = newComponent;

        } else if (oldComponent == south) {
            mainLayout.replaceComponent(south, newComponent);
            south = newComponent;
        }

        centerLayout.setExpandRatio(center, 1);
        requestRepaint();
    }

    /**
     * Set minimum height of the component in the DockLayout.NORTH
     *
     * @param minimumNorthHeight
     */
    public void setMinimumNorthHeight(String minimumNorthHeight) {
        this.minimumNorthHeight = minimumNorthHeight;
    }

    /**
     * Get minimum height of the component in the DockLayout.NORTH
     */
    public String getMinimumNorthHeight() {
        return minimumNorthHeight;
    }

    /**
     * Set minimum height of the component in the DockLayout.SOUTH
     *
     * @param minimumSouthHeight
     */
    public void setMinimumSouthHeight(String minimumSouthHeight) {
        this.minimumSouthHeight = minimumSouthHeight;
    }

    /**
     * Get minimum height of the component in the DockLayout.SOUTH
     */
    public String getMinimumSouthHeight() {
        return minimumSouthHeight;
    }

    /**
     * Set minimum height of the component in the DockLayout.WEST
     *
     * @param minimumWestWidth
     */
    public void setMinimumWestWidth(String minimumWestWidth) {
        this.minimumWestWidth = minimumWestWidth;
    }

    /**
     * Get minimum height of the component in the DockLayout.WEST
     */
    public String getMinimumWestWidth() {
        return minimumWestWidth;
    }

    /**
     * Set minimum height of the component in the DockLayout.EAST
     *
     * @param minimumEastWidth
     */
    public void setMinimumEastWidth(String minimumEastWidth) {
        this.minimumEastWidth = minimumEastWidth;
    }

    /**
     * Get minimum height of the component in the DockLayout.EAST
     */
    public String getMinimumEastWidth() {
        return minimumEastWidth;
    }

    /**
     * Return component from specific position
     *
     * @param region
     * @return
     */
    public Component getComponent(Region region) {
        if (region == Region.TOP) {
            return north;
        } else if (region == Region.LEFT) {
            return west;
        } else if (region == Region.CENTER) {
            return center;
        } else if (region == Region.RIGHT) {
            return east;
        } else if (region == Region.BOTTOM) {
            return south;
        } else {
            throw new IllegalArgumentException("Invalid DockLayout constraint.");
        }
    }

    @Override
    public void addListener(ComponentDetachListener listener) {
        this.mainLayout.addListener(listener);
        this.centerLayout.addListener(listener);
    }

    @Override
    public void addListener(ComponentAttachListener listener) {
        this.mainLayout.addListener(listener);
        this.centerLayout.addListener(listener);
    }

    public DockLayoutIterator<Component> getDockLayoutComponentIterator() {
        return new DockLayoutIterator<Component>(mainLayout.getComponentIterator(), centerLayout.getComponentIterator());
    }

    /**
     * Iterate through the components of the docklayout
     *
     * TODO: Determine if the end user need to iterate components added into
     * N/S/E/W locations??
     *
     * @param <Component>
     */
    @SuppressWarnings("hiding")
    public class DockLayoutIterator<Component> implements Iterator<Component> {
        Iterator<Component> mainLayoutIter;
        Iterator<Component> centerLayoutIter;

        DockLayoutIterator(Iterator<Component> mainLayoutIter, Iterator<Component> centerLayoutIter) {
            this.mainLayoutIter = mainLayoutIter;
            this.centerLayoutIter = centerLayoutIter;
        }

        public boolean hasNext() {
            return (mainLayoutIter.hasNext() || centerLayoutIter.hasNext());
        }

        public Component next() {
            if (mainLayoutIter.hasNext()) {
                return mainLayoutIter.next();
            } else {
                return centerLayoutIter.next();
            }
        }

        public void remove() {
            if (mainLayoutIter.hasNext()) {
                mainLayoutIter.remove();
            } else {
                centerLayoutIter.remove();
            }
        }
    }
}
