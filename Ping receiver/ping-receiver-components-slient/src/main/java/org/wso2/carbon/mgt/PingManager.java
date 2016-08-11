package org.wso2.carbon.mgt;

/**
 * Created by Dinanjana on 03/08/2016.
 */
public class PingManager {

    private final String MESSAGE;

    public PingManager() {
        MESSAGE = "Ping received";
    }

    public String getMESSAGE() {
        return MESSAGE;
    }
}
