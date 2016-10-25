package com.example.goku.swe_main;

/**
 * Created by goku on 24/10/16.
 */

public class Message {
    private String information_msg;
    private String alert_msg;

    public String getAlert_msg() {
        return alert_msg;
    }

    public void setAlert_msg(String alert_msg) {
        this.alert_msg = alert_msg;
    }

    public String getInformation_msg() {
        return information_msg;
    }

    public void setInformation_msg(String information_msg) {
        this.information_msg = information_msg;
    }
}
