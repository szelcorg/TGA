package org.szelc.tga.app;

import fit.MainListener;
import org.jxmapviewer.viewer.GeoPosition;

import java.util.List;

public class MainListenerImpl implements MainListener {

    Main m;
    public MainListenerImpl(Main m) {
        this.m = m;
    }

    @Override
    public void finishLoadPoint(List<GeoPosition> routePoint, List<GeoPosition> wayPoint) {
        m.finishLoadPoint(routePoint, wayPoint);
    }
}
