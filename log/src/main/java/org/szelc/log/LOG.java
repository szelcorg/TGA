package org.szelc.log;


import org.apache.log4j.Logger;

/**
 * @author by marcin.szelc on 2017-12-08.
 */
public class LOG {

    private static Logger log = Logger.getLogger(LOG.class);

    public static void i(String msg){
        log.info(msg);
    }

    public static void d(String msg){
        log.debug(msg);
    }
}
