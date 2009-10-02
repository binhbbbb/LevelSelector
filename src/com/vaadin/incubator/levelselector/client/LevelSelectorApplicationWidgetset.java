package com.vaadin.incubator.levelselector.client;

import com.vaadin.incubator.levelselector.client.ui.VLevelSelector;
import com.vaadin.terminal.gwt.client.DefaultWidgetSet;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;

public class LevelSelectorApplicationWidgetset extends DefaultWidgetSet {

    /** Creates a widget according to its class name. */
    @Override
    public Paintable createWidget(UIDL uidl) {
        final Class<?> classType = resolveWidgetType(uidl);

        Paintable p = createWidgetByClass(classType);
        if (p == null) {
            // Let the DefaultWidgetSet handle creation of default widgets
            p = super.createWidget(uidl);
        }

        return p;
    }

    /** Resolves UIDL tag name to class . */
    @Override
    protected Class<?> resolveWidgetType(UIDL uidl) {
        final String tag = uidl.getTag();

        Class<?> c = resolveWidgetByTag(tag);

        if (c == null) {
            c = super.resolveWidgetType(uidl);
        }

        // Let the DefaultWidgetSet handle resolution of default widgets
        return c;
    }

    // This method gets AUTOGENERATED by Vaadin plugin
    private Paintable createWidgetByClass(Class<?> classType) {
        if (classType == VLevelSelector.class) {
            return new VLevelSelector();
            // } else if (classType == VSortableHorizontalLayout.class) {
            // return new VSortableHorizontalLayout();
        } else {
            return null;
        }
    }

    // This method gets AUTOGENERATED by Vaadin plugin
    private Class<?> resolveWidgetByTag(final String tag) {
        if (VLevelSelector.TAGNAME.equals(tag)) {
            return VLevelSelector.class;
        } else {
            return null;
        }
    }

}