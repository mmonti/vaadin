package ar.mmonti.wcm.windows;

import ar.mmonti.wcm.components.CompositeSplitPanel;
import ar.mmonti.wcm.components.CompositeSplitPanelImpl;
import ar.mmonti.wcm.support.Dimensions;
import ar.mmonti.wcm.ui.windows.AbstractWindow;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;

/**
 * @author: mmonti
 */
public class CompositeSplitPanelWindow extends AbstractWindow {

    @Override
    public void initializeWindow() {
        final Layout leftContent = new VerticalLayout();
        leftContent.addComponent(new Label("Left Component"));
        leftContent.setWidth(Dimensions.VALUE_250, Sizeable.UNITS_PIXELS);

        final Layout leftContentNoSize = new VerticalLayout();
        leftContentNoSize.addComponent(new Label("Left Component No Size"));

        final Layout rightContent = new VerticalLayout();
        rightContent.addComponent(new Label("Right Component"));
        rightContent.setWidth(Dimensions.VALUE_250, Sizeable.UNITS_PIXELS);

        final Layout rightContentNoSize = new VerticalLayout();
        rightContentNoSize.addComponent(new Label("Right Component No Size"));

        final Layout layout = new VerticalLayout();

        final CompositeSplitPanel compositeSplitPanelImpl = new CompositeSplitPanelImpl();
        compositeSplitPanelImpl.setSizeFull();
//      2  compositeSplitPanelImpl.setLeftComponent(leftContent);
//        compositeSplitPanelImpl.setRightComponent(rightContent);

        Button closeRight = new Button("Close Right");
        closeRight.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.hide(CompositeSplitPanelImpl.Placement.RIGHT);
            }
        });

        Button closeLeft = new Button("Close Left");
        closeLeft.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.hide(CompositeSplitPanelImpl.Placement.LEFT);
            }
        });

        Button openRight = new Button("Open Right");
        openRight.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.show(CompositeSplitPanelImpl.Placement.RIGHT);
            }
        });

        Button openLeft = new Button("Open Left");
        openLeft.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.show(CompositeSplitPanelImpl.Placement.LEFT);
            }
        });

        Button lockRightTrue = new Button("lock Right");
        lockRightTrue.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.lock(CompositeSplitPanelImpl.Placement.RIGHT);
            }
        });

        Button lockRightFalse = new Button("unlock Right");
        lockRightFalse.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.unlock(CompositeSplitPanelImpl.Placement.RIGHT);
            }
        });

        Button lockLeftTrue = new Button("lock Left");
        lockLeftTrue.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.lock(CompositeSplitPanelImpl.Placement.LEFT);
            }
        });

        Button lockLeftFalse = new Button("unlock Left");
        lockLeftFalse.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.unlock(CompositeSplitPanelImpl.Placement.LEFT);
            }
        });

        Button setLeftToNull = new Button("Set Left NULL");
        setLeftToNull.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.setComponent(CompositeSplitPanelImpl.Placement.LEFT, null);
            }
        });

        Button setRightToNull = new Button("Set Right NULL");
        setRightToNull.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.setComponent(CompositeSplitPanelImpl.Placement.RIGHT, null);
            }
        });

        Button setRightContent = new Button("Set Right Content");
        setRightContent.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.setComponent(CompositeSplitPanelImpl.Placement.RIGHT, rightContent);
            }
        });

        Button setLeftContent = new Button("Set Left Content");
        setLeftContent.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.setComponent(CompositeSplitPanelImpl.Placement.LEFT, leftContent);
            }
        });

        Button setRightContentNoSize = new Button("Set Right Content No Size");
        setRightContentNoSize.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.setComponent(CompositeSplitPanelImpl.Placement.RIGHT, rightContentNoSize);
            }
        });

        Button setLeftContentNoSize = new Button("Set Left Content No Size");
        setLeftContentNoSize.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.setComponent(CompositeSplitPanelImpl.Placement.LEFT, leftContentNoSize);
            }
        });

        Button setCenterNullContent = new Button("Set Center To Null");
        setCenterNullContent.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.setComponent(CompositeSplitPanelImpl.Placement.CENTER, null);
            }
        });

        Button setCenterContent = new Button("Set Center Content");
        setCenterContent.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                compositeSplitPanelImpl.setComponent(CompositeSplitPanelImpl.Placement.CENTER, layout);
            }
        });

        layout.addComponent(openLeft);
        layout.addComponent(closeLeft);
        layout.addComponent(openRight);
        layout.addComponent(closeRight);

        layout.addComponent(lockLeftFalse);
        layout.addComponent(lockLeftTrue);
        layout.addComponent(lockRightFalse);
        layout.addComponent(lockRightTrue);

        layout.addComponent(setLeftToNull);
        layout.addComponent(setRightToNull);

        layout.addComponent(setLeftContent);
        layout.addComponent(setRightContent);

        layout.addComponent(setLeftContentNoSize);
        layout.addComponent(setRightContentNoSize);

        leftContent.addComponent(setCenterContent);
        leftContent.addComponent(setCenterNullContent);

        layout.setMargin(Boolean.TRUE);

        Panel panel = new Panel("This is a Panel");
        panel.setSizeFull();

        layout.addComponent(panel);

        compositeSplitPanelImpl.setComponent(CompositeSplitPanelImpl.Placement.CENTER, layout);

        setContent(compositeSplitPanelImpl);
    }

}
