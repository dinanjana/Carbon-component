package org.wso2.carbon.pingReceiver.mgt;

import java.util.Vector;

/**
 * Created by Dinanjana on 03/08/2016.
 */
public class PingManager {

    private final String MESSAGE;

    public PingManager() {
        MESSAGE = "Ping received";
    }

    public String getMESSAGE() {
//        Vector v = new Vector();
//        int i = 0;
//        while (i < 100000000)
//        {
//            byte b[] = new byte[1048576];
//            v.add(b);
//            Runtime rt = Runtime.getRuntime();
//            System.out.println( "free memory: " + rt.freeMemory() );
//            i++;
//        }
        return MESSAGE;
    }
}
