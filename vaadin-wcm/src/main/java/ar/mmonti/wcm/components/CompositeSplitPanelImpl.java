package ar.mmonti.wcm.components;

import ar.mmonti.wcm.support.Dimensions;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;


/**
 * @author: mmonti
 */
public class CompositeSplitPanelImpl extends CustomComponent implements CompositeSplitPanel {

    private static final float DEFAULT_LEFT_SPLIT_POSITION = 200f;
    private static final float DEFAULT_RIGHT_SPLIT_POSITION = 200f;

    protected HorizontalSplitPanel outerSplitPanel;
    protected HorizontalSplitPanel innerSplitPanel;

    private ComponentContainer leftComponent;
    private ComponentContainer centerComponent;
    private ComponentContainer rightComponent;

    private Float defaultLeftSplitPosition;
    private Float defaultRightSplitPosition;

    /**
     *
     */
    public CompositeSplitPanelImpl() {
        this(DEFAULT_LEFT_SPLIT_POSITION, DEFAULT_RIGHT_SPLIT_POSITION);
    }

    /**
     *
     * @param defaultLeftSplitPosition
     * @param defaultRightSplitPosition
     */
    public CompositeSplitPanelImpl(Float defaultLeftSplitPosition, Float defaultRightSplitPosition) {
        this.defaultLeftSplitPosition = defaultLeftSplitPosition;
        this.defaultRightSplitPosition = defaultRightSplitPosition;

        this.outerSplitPanel = new HorizontalSplitPanel();
        this.innerSplitPanel = new HorizontalSplitPanel();

        outerSplitPanel.setSizeFull();
        innerSplitPanel.setSizeFull();

        outerSplitPanel.setHeight(Dimensions.VALUE_100, Sizeable.UNITS_PERCENTAGE);
        innerSplitPanel.setHeight(Dimensions.VALUE_100, Sizeable.UNITS_PERCENTAGE);

        outerSplitPanel.setSecondComponent(innerSplitPanel);

        outerSplitPanel.setMinSplitPosition(Dimensions.VALUE_0, Sizeable.UNITS_PIXELS);
        innerSplitPanel.setMinSplitPosition(Dimensions.VALUE_0, Sizeable.UNITS_PIXELS);

        calculateSplitPosition(outerSplitPanel, null, Boolean.FALSE, defaultLeftSplitPosition);
        lockLeftComponent();

        calculateSplitPosition(innerSplitPanel, null, Boolean.TRUE, defaultRightSplitPosition);
        lockRightComponent();

        setCompositionRoot(outerSplitPanel);
    }

    @Override
    public void setComponent(Placement placement, Component component) {
        if (Placement.LEFT.equals(placement)) {
            this.setLeftComponent(component);
        }
        if (Placement.CENTER.equals(placement)) {
            this.setCenterComponent(component);
        }
        if (Placement.RIGHT.equals(placement)) {
            this.setRightComponent(component);
        }
    }

    @Override
    public Component getComponentAt(Placement placement) {
        if (Placement.LEFT.equals(placement)) {
            return this.leftComponent.getComponentIterator().next();
        }
        if (Placement.CENTER.equals(placement)) {
            return this.centerComponent.getComponentIterator().next();
        }
        if (Placement.RIGHT.equals(placement)) {
            return this.rightComponent.getComponentIterator().next();
        }
        return null;
    }

    @Override
    public ComponentContainer getComponentContainerAt(Placement placement) {
        if (Placement.LEFT.equals(placement)) {
            return this.leftComponent;
        }
        if (Placement.CENTER.equals(placement)) {
            return this.centerComponent;
        }
        if (Placement.RIGHT.equals(placement)) {
            return this.rightComponent;
        }
        return null;
    }

    @Override
    public void removeComponentAt(Placement placement) {
        setComponent(placement, null);
    }

    private void setLeftComponent(Component component) {
        this.leftComponent= new VerticalLayout();
        this.leftComponent.setSizeFull();

        if (component == null) {
            if (this.outerSplitPanel.getFirstComponent() != null) {
                this.outerSplitPanel.removeComponent(this.outerSplitPanel.getFirstComponent());
                this.outerSplitPanel.setSplitPosition(Dimensions.VALUE_0, Sizeable.UNITS_PIXELS);
                lockLeftComponent();
            }
        } else {
            this.leftComponent.setWidth(Dimensions.VALUE_100, Sizeable.UNITS_PERCENTAGE);
            this.leftComponent.addComponent(component);

            this.outerSplitPanel.setFirstComponent(this.leftComponent);

            calculateSplitPosition(this.outerSplitPanel, component, Boolean.FALSE, defaultLeftSplitPosition);
            unlockLeftComponent();
        }
        this.requestRepaintAll();
    }

    private void setCenterComponent(Component component) {
        this.centerComponent = new VerticalLayout();
        this.centerComponent.setSizeFull();

        if (component == null) {
            if (this.innerSplitPanel.getFirstComponent() != null) {
                this.innerSplitPanel.removeComponent(this.innerSplitPanel.getFirstComponent());
            }
        } else {
            this.centerComponent.setWidth(Dimensions.VALUE_100, Sizeable.UNITS_PERCENTAGE);
            this.centerComponent.addComponent(component);
            this.innerSplitPanel.setFirstComponent(this.centerComponent);
        }
        this.requestRepaintAll();
    }

    private void setRightComponent(Component component) {
        this.rightComponent = new VerticalLayout();
        this.rightComponent.setSizeFull();

        if (component == null) {
            if (this.innerSplitPanel.getSecondComponent() != null) {
                this.innerSplitPanel.removeComponent(this.innerSplitPanel.getSecondComponent());
                this.innerSplitPanel.setSplitPosition(Dimensions.VALUE_0, Sizeable.UNITS_PIXELS, Boolean.TRUE);

                lockRightComponent();
            }
        } else {
            this.rightComponent.setWidth(Dimensions.VALUE_100, Sizeable.UNITS_PERCENTAGE);
            this.rightComponent.addComponent(component);

            this.innerSplitPanel.setSecondComponent(this.rightComponent);

            calculateSplitPosition(this.innerSplitPanel, component, Boolean.TRUE, defaultRightSplitPosition);
            unlockRightComponent();
        }
        this.requestRepaintAll();
    }

    private void calculateSplitPosition(HorizontalSplitPanel splitPanel, Component component, Boolean reverse, Float defaultPosition) {
        Float splitPosition = null;
        Integer splitPositionUnit = null;

        if (component != null) {
            splitPosition = component.getWidth();
            splitPositionUnit = component.getWidthUnits();
        } else {
            splitPosition = Dimensions.VALUE_0;
            splitPositionUnit = Sizeable.UNITS_PIXELS;
        }

        if (component != null && (Sizeable.UNITS_PERCENTAGE == splitPositionUnit)) {
            splitPosition = defaultPosition;
            splitPositionUnit = Sizeable.UNITS_PIXELS;
        }

        splitPanel.setSplitPosition(splitPosition, splitPositionUnit, reverse);
    }

    @Override
    public void show(Placement placement) {
        if (Placement.LEFT.equals(placement)) {
            openLeftComponent();
        }
        if (Placement.RIGHT.equals(placement)) {
            openRightComponent();
        }
    }

    @Override
    public void hide(Placement placement) {
        if (Placement.LEFT.equals(placement)) {
            closeLeftComponent();
        }
        if (Placement.RIGHT.equals(placement)) {
            closeRightComponent();
        }
    }

    @Override
    public void lock(Placement placement) {
        if (Placement.LEFT.equals(placement)) {
            lockLeftComponent();
        }
        if (Placement.RIGHT.equals(placement)) {
            lockRightComponent();
        }
    }

    @Override
    public void unlock(Placement placement) {
        if (Placement.LEFT.equals(placement)) {
            unlockLeftComponent();
        }
        if (Placement.RIGHT.equals(placement)) {
            unlockRightComponent();
        }
    }

    @Override
    public Boolean isLocked(Placement placement) {
        if (Placement.LEFT.equals(placement)) {
            return isLeftLocked();
        }
        if (Placement.RIGHT.equals(placement)) {
            return isRigthLocked();
        }
        return null;
    }

    @Override
    public Boolean isVisible(Placement placement) {
        if (Placement.LEFT.equals(placement)) {
            return isLeftVisible();
        }
        if (Placement.RIGHT.equals(placement)) {
            return isRigthVisible();
        }
        return null;
    }

    private void openLeftComponent() {
        this.outerSplitPanel.setSplitPosition(this.defaultLeftSplitPosition, Sizeable.UNITS_PIXELS);
    }

    private void closeLeftComponent() {
        this.outerSplitPanel.setSplitPosition(Dimensions.VALUE_0, Sizeable.UNITS_PIXELS);
    }

    private void openRightComponent() {
        this.innerSplitPanel.setSplitPosition(this.defaultRightSplitPosition, Sizeable.UNITS_PIXELS, Boolean.TRUE);
    }

    private void closeRightComponent() {
        this.innerSplitPanel.setSplitPosition(Dimensions.VALUE_0, Sizeable.UNITS_PIXELS, Boolean.TRUE);
    }

    private void lockLeftComponent() {
        this.outerSplitPanel.setLocked(Boolean.TRUE);
    }

    private void unlockLeftComponent() {
        this.outerSplitPanel.setLocked(Boolean.FALSE);
    }

    private void lockRightComponent() {
        this.innerSplitPanel.setLocked(Boolean.TRUE);
    }

    private void unlockRightComponent() {
        this.innerSplitPanel.setLocked(Boolean.FALSE);
    }

    private Boolean isLeftLocked() {
        return this.outerSplitPanel.isLocked();
    }

    private Boolean isLeftVisible() {
        return this.outerSplitPanel.isVisible();
    }

    private Boolean isRigthLocked() {
        return this.innerSplitPanel.isLocked();
    }

    private Boolean isRigthVisible() {
        return this.innerSplitPanel.isVisible();
    }

    public enum Placement {
        LEFT, CENTER, RIGHT;
    }
}
