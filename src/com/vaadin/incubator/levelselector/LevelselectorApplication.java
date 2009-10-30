package com.vaadin.incubator.levelselector;

import com.vaadin.Application;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class LevelselectorApplication extends Application implements
        ValueChangeListener {

    private static final long serialVersionUID = -7899086985308658844L;
    Label label = new Label("Click on the level selector to choose a value");

    @Override
    public void init() {
        setTheme("example");
        Window mainWindow = new Window("Components Application");
        setMainWindow(mainWindow);

        Label description = new Label(
                "<b>This application demonstrates the LevelSelector component. "
                        + "Note that all the three different components on this page are instances of "
                        + "the LevelSelector component. The only thing that is different between them is "
                        + "the CSS styling.</b>", Label.CONTENT_XHTML);

        mainWindow.addComponent(description);

        final LevelSelector selector = new LevelSelector();
        selector.setCaption("Select volume level");
        selector.setMaxValue(25);
        selector.setValue(3);
        selector.setMinValue(2);
        selector.setHeight("15px");
        selector.setBlockSize(8);
        selector.addListener(this);
        selector.setImmediate(true);
        mainWindow.addComponent(selector);

        final TextField maxValue = new TextField("Max value");
        maxValue.setValue(selector.getMaxValue());
        final TextField minValue = new TextField("Min value");
        minValue.setValue(selector.getMinValue());

        final TextField value = new TextField("Value");
        value.setValue(selector.getValue());

        Button submit = new Button("Submit", new ClickListener() {
            private static final long serialVersionUID = 3360312609193862981L;

            public void buttonClick(ClickEvent event) {
                selector.setMaxValue(Integer.valueOf(maxValue.getValue()
                        .toString()));
                selector.setMinValue(Integer.valueOf(minValue.getValue()
                        .toString()));
                selector.setValue(Integer.valueOf(value.getValue().toString()));
            }
        });

        mainWindow.addComponent(maxValue);
        mainWindow.addComponent(minValue);
        mainWindow.addComponent(value);
        mainWindow.addComponent(submit);
        mainWindow.addComponent(label);

        final LevelSelector selector2 = new LevelSelector();
        selector2
                .setCaption("It's funny what you can do with just a little bit of CSS");
        selector2.setMaxValue(10);
        selector2.setValue(5);
        selector2.setMinValue(3);
        selector2.setHeight("32px");
        selector2.setBlockSize(32);
        selector2.addListener(this);
        selector2.setImmediate(true);
        selector2.setStyleName("stars");
        mainWindow.addComponent(selector2);

        final LevelSelector selector3 = new LevelSelector();
        selector3.setCaption("More CSS trickery");
        selector3.setMaxValue(100);
        selector3.setValue(1);
        selector3.setMinValue(1);
        selector3.setHeight("40px");
        selector3.setBlockSize(3);
        selector3.addListener(this);
        selector3.setImmediate(true);
        selector3.setStyleName("volume");
        mainWindow.addComponent(selector3);

    }

    public void valueChange(ValueChangeEvent event) {
        label.setValue("Selection got the value "
                + event.getProperty().getValue());
    }

}
