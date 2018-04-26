/*

    Description: 

    Author: dmcra
    Date: 15-Feb-2018

 */
package javanetwork;

public class DeviceRecord {

    // refactor, encapsulate fields
    private int id;
    private String macaddress;
    private String ipaddress;
    private String addressmode;
    private String nodetype;
    private String nodename;
    private boolean online;

    public DeviceRecord() {
        this.id = 0;
        this.macaddress = "";
        this.ipaddress = "";
        this.addressmode = "";
        this.nodetype = "";
        this.nodename = "";
        this.online = false;
    }

    public DeviceRecord(DeviceRecord turnMeOn) {
        this.id = turnMeOn.id;
        this.macaddress = turnMeOn.macaddress;
        this.ipaddress = turnMeOn.ipaddress;
        this.addressmode = turnMeOn.addressmode;
        this.nodetype = turnMeOn.nodetype;
        this.nodename = turnMeOn.nodename;
        this.online = turnMeOn.online;
    }

    @Override
    public String toString() {
        String status = "";
        if (this.online) {
            status = "online";
        } else {
            status = "offline";
        }
        return this.id + " "
                + this.macaddress + " "
                + this.ipaddress + " "
                + this.addressmode + " "
                + this.nodetype + " "
                + this.nodename + " "
                + status;
    }

    public boolean turnMeOn() {
        this.online = true;
        return online;
    }

    public boolean turnMeOff() {
        this.online = false;
        return online;
    }

    // accessors/mutators omitted
    public void setId(int id) {
        this.id = id;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public void setAddressmode(String addressmode) {
        this.addressmode = addressmode;
    }

    public void setNodetype(String nodetype) {
        this.nodetype = nodetype;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public int getId() {
        return id;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public String getAddressmode() {
        return addressmode;
    }

    public String getNodetype() {
        return nodetype;
    }

    public String getNodename() {
        return nodename;
    }

    public boolean isOnline() {
        return online;
    }

}
