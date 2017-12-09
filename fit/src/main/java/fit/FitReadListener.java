package fit;

import com.garmin.fit.Field;
import com.garmin.fit.Mesg;
import com.garmin.fit.MesgListener;
import org.jxmapviewer.viewer.GeoPosition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FitReadListener implements MesgListener {
    double mnoznik = 180/Math.pow(2,31);
    List<GeoPosition> routePoint = new ArrayList<>();
    List<GeoPosition> wayPoint = new ArrayList<>();

    MainListener s;
    /**
     lap
     end_position_lat
     end_position_long

     record
     position_lat
     position_long
     */
    public FitReadListener(MainListener s) {
        this.s = s;
    }

    List<String> names = new LinkedList();

    double heartRate = 0;
    long countHeartRate = 0;
    @Override
    public void onMesg(Mesg mesg) {
        if(heartRate>2){
            // return;
        }
        p("NAME "+mesg.getName());
        if("activity".equals(mesg.getName())){
            p("HEART RATE AVG ["+heartRate/countHeartRate);

            s.finishLoadPoint(routePoint, wayPoint);
        }
        p("----------------------"+mesg.toString());
        Iterator<Field> it = mesg.getFields().iterator();

        double endPositionLat=0d;
        double endPositionLong = 0d;
        double positionLat=0d;
        double positionLong = 0d;
        while(it.hasNext()){
            FitField f = new FitField(it.next());
            if(f.getName().equals("end_position_lat")){
                endPositionLat = mnoznik  * (int)f.getValue();
            }
            if(f.getName().equals("end_position_long")){
                endPositionLong = mnoznik  * (int)f.getValue();
                GeoPosition g = new GeoPosition(endPositionLat, endPositionLong);
                wayPoint.add(g);
            }

            if(f.getName().equals("position_lat")){
                positionLat = mnoznik  * (int)f.getValue();
            }
            if(f.getName().equals("position_long")){
                positionLong = mnoznik  * (int)f.getValue();
                GeoPosition g = new GeoPosition(positionLat, positionLong);
                routePoint.add(g);
            }



            if(f.getName().equals("heart_rate")){
                heartRate+= (f.getValue() instanceof Long) ? (long)f.getValue() : (short)f.getValue();
                countHeartRate++;
            }

            if(f.getName().equals("position_long")){
                double result = ((int)f.getValue()) * (180 / Math.pow(2, 31));

                p("LONGITUDE ["+result+"]");
            }
            if(f.getName().equals("position_lat")){
                double result = ((int)f.getValue()) * (180 / Math.pow(2, 31));
                p("LATITUDE ["+result+"]");
            }


            if(!names.contains(f.getName())){
                //names.add(f.getName());
            }

            p("TYPE ["+f.getType()+"] num ["+f.getNum()+"] "+f.getNumValues()+" "+f.getName()+
                    " "+ f.getValue()+" raw ");


        }


    }


    private void p(String msg){
        System.out.println(msg);
    }}
