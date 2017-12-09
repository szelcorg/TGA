package fit;

import org.jxmapviewer.viewer.GeoPosition;

import java.util.List;

public interface MainListener {
    void finishLoadPoint(List<GeoPosition> routePoint, List<GeoPosition> wayPoint);
}
