package org.szelc.fit.garmin;

import com.garmin.fit.*;
import org.szelc.fit.controller.FitLoaderListener;
import org.szelc.fit.listener.MainListener;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

public class FitParser implements MonitoringMesgListener {
    String rootPath = "C:\\ProgramData\\Garmin\\GarminConnect\\Forerunner 910XT-3896405506\\FIT_TYPE_4\\";
    String filename = rootPath+"636485422120000000388.fit";
       // String filename = rootPath+"636478914480000000382.fit";
        public FitParser(FitReadListener fitListener){
            try (FileInputStream fis = new FileInputStream(new java.io.File(filename))) {
                new Decode().read(fis, fitListener);

            } catch (IOException ioe) {
                ioe.printStackTrace();
                //throw new EVException("Failed to read FIT file '" + filename + "'...", ioe);
            }
        }

        public FitParser(int xs){
            p("FitParser");
            Decode decode;
            MonitoringReader monitoringReader;
            MesgBroadcaster mesgBroadcaster;
            FileInputStream inputStream;

            Collection<byte[]> files;
            int fileNum;

            String inputFile = "C:\\ProgramData\\Garmin\\GarminConnect\\Forerunner 910XT-3896405506\\FIT_TYPE_4\\636478914480000000382.fit";

            try {
                inputStream = new FileInputStream(inputFile);
                files = FileUtil.split(inputStream);
                files = FileUtil.prepend(files, File.SETTINGS, File.MONITORING_B);
                inputStream.close();
            } catch (java.io.IOException e) {
                throw new RuntimeException("Error opening file " + inputFile);
            }

            for(byte[] file : files) {
                p("DECODE");
                ByteArrayInputStream fileStream = new ByteArrayInputStream(file);

                decode = new Decode();
                mesgBroadcaster = new MesgBroadcaster(decode);
                monitoringReader = new MonitoringReader(1);
                // if (dailyTotals)
                //   monitoringReader.outputDailyTotals();
                mesgBroadcaster.addListener((MonitoringInfoMesgListener) monitoringReader);
                mesgBroadcaster.addListener((MonitoringMesgListener) monitoringReader);
                mesgBroadcaster.addListener((DeviceSettingsMesgListener) monitoringReader);
                monitoringReader.addListener(this);

                mesgBroadcaster.run(fileStream); // Run decoder.
                monitoringReader.broadcast(); // E
            }
        }


   /* public static void main(String args[] ){
        new FitParser(this);

    }*/

        @Override
        public void onMesg(MonitoringMesg monitoringMesg) {
            //mesgWriter.onMesg(mesg);
        }

        private void p(String msg){
            System.out.println(msg);
        }
}
