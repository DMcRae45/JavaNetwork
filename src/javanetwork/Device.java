/*
 * Description:
 * 
 * Author: David McRae
 * Date: 18-Jan-2018
 */
package javanetwork;

import javanetwork.DeviceController;

public class Device
{
    // refactor, encapsulate fields
    private int id;
    private String macaddress;
    private String ipaddress;
    private String addressmode;
    private String nodetype;
    private String nodename;
    private boolean online;

    public Device()
    {
         id = 0;
         macaddress = "";
         ipaddress = "";
         addressmode = "";
         nodetype = "";
         nodename = "";
         online = false;
    }
    
    public Device(Device turnMeOn)
    {
        this.id = turnMeOn.id;
        this.macaddress = turnMeOn.macaddress;
        this.ipaddress = turnMeOn.ipaddress;
        this.addressmode = turnMeOn.addressmode;
        this.nodetype = turnMeOn.nodetype;
        this.nodename = turnMeOn.nodename;
        this.online = turnMeOn.online;
    }

    public boolean setOnline()
    {
        online = true;
        return online;
    }
    
    public boolean turnMeOn() {
        this.online = true;
        return online;
    }

    public boolean turnMeOff() {
        this.online = false;
        return online;
    }

    @Override
    public String toString()
    {
        String status = "" ;
        if (this.online)
            status = "online" ;
        else 
            status = "offline";
        return this.id + " "
                + this.macaddress + " "
                + this.ipaddress + " "
                + this.addressmode + " "
                + this.nodetype + " "
                + this.nodename + " "
                + status;
    }   
}
