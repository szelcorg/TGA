package org.szelc.map;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;
import org.szelc.map.painter.RoutePainter;
import org.szelc.map.waypoint.FancyWaypointRenderer;
import org.szelc.map.waypoint.MyWaypoint;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.painter.Painter;


public class Map {



    public JPanel finishLoadPoint(List<GeoPosition> routePoint, List<GeoPosition> wayPoint){
        JXMapViewer mapViewer = new JXMapViewer();


        // Display the viewer in a JFrame



        // Create a TileFactoryInfo for OpenStreetMap
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        tileFactory.setThreadPoolSize(8);
        mapViewer.setTileFactory(tileFactory);

        /**
         GeoPosition frankfurt = new GeoPosition(50,  7, 0, 8, 41, 0);
         GeoPosition wiesbaden = new GeoPosition(50,  5, 0, 8, 14, 0);
         GeoPosition mainz     = new GeoPosition(50,  0, 0, 8, 16, 0);
         GeoPosition darmstadt = new GeoPosition(49, 52, 0, 8, 39, 0);
         GeoPosition offenbach = new GeoPosition(50,  6, 0, 8, 46, 0);

         GeoPosition krosno = new GeoPosition(49.2, 21.7);
         */
        // Create a track from the geo-positions
        //List<GeoPosition> track = Arrays.asList(frankfurt, wiesbaden, mainz, darmstadt, offenbach);
        RoutePainter routePainter = new RoutePainter(routePoint);

        //  List<GeoPosition> all = Arrays.asList(frankfurt, wiesbaden, mainz, darmstadt, offenbach, krosno);


        // Create waypoints from the geo-positions
        Set<MyWaypoint> waypoints = new HashSet<MyWaypoint>();
        /**
         Arrays.asList(
         new DefaultWaypoint(frankfurt),
         new DefaultWaypoint(wiesbaden),
         new DefaultWaypoint(mainz),
         new DefaultWaypoint(darmstadt),
         new DefaultWaypoint(offenbach),
         new DefaultWaypoint(krosno)

         ));*/
        int i = 1;

        waypoints.add(new MyWaypoint("S", Color.GREEN, routePoint.get(0)));
        for(GeoPosition g : wayPoint){
            System.out.println("WayPoint ");
            String label = null;
            Color c = Color.ORANGE;
            if(i==wayPoint.size()){
                label = "M";
                c = Color.RED;
            }
            else {
                label = ""+i++;
            }

            //waypoints.add(new DefaultWaypoint(g));
            waypoints.add(new MyWaypoint(label, c, g));
        }



        // Set the focus
        mapViewer.zoomToBestFit(new HashSet<GeoPosition>(routePoint), 1);

        // Create a waypoint painter that takes all the waypoints
        //WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<Waypoint>();
        //waypointPainter.setWaypoints(waypoints);


        WaypointPainter<MyWaypoint> waypointPainter = new WaypointPainter<MyWaypoint>();
        waypointPainter.setWaypoints(waypoints);
        waypointPainter.setRenderer(new FancyWaypointRenderer());

        // Create a compound painter that uses both the route-painter and the waypoint-painter
        List<Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
        painters.add(routePainter);
        painters.add(waypointPainter);

        CompoundPainter<JXMapViewer> painter = new CompoundPainter<>(painters);
        mapViewer.setOverlayPainter(painter);

        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);

        mapViewer.addMouseListener(new CenterMapListener(mapViewer));

        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));

        mapViewer.addKeyListener(new PanKeyListener(mapViewer));

        mapViewer.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent me) {
                Point2D gp_pt = null;

                int km = 0;
                for (GeoPosition waypoint : wayPoint) {
                    km++;
                    //convert to world bitmap
                    gp_pt = mapViewer.getTileFactory().geoToPixel(waypoint, mapViewer.getZoom());

                    //convert to screen
                    Rectangle rect = mapViewer.getViewportBounds();
                    Point converted_gp_pt = new Point((int) gp_pt.getX() - rect.x,
                            (int) gp_pt.getY() - rect.y);
                    //check if near the mouse
                    if (converted_gp_pt.distance(me.getPoint()) < 40) {
                        System.out.println("mapViewer mouse click has been detected within 10 pixels of a waypoint "+km);
                    } else {
                        //System.out.println("mapViewer mouse click has been dected but NOT with 10 pixels of a waypoint ");
                    }
                    mapViewer.getGraphics().drawRect(me.getX()+20, me.getY(), 50, 20);
                    mapViewer.getGraphics().drawString("3'43,12", me.getX()+22, me.getY()+12);
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        mapViewer.setZoom(10);

        return mapViewer;
    }

}
