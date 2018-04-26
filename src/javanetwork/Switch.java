/*
 * Description: Responsible for registering the MAC addresses (12 hex digits) 
 * of devices connected to the network. Maximum amount of ports: 48
 * 
 * Author: David McRae
 * Date: 18-Jan-2018
 */
package javanetwork;


public class Switch extends DeviceController
{  
    // refactor, encapsulate fields
    private int id;
    private String macaddress;
    private String ipaddress;
    private String addressmode;
    private String nodetype;
    private String nodename;
    private boolean online;
    
    public Switch()
    {
         id = 0;
         macaddress = "";
         ipaddress = "";
         addressmode = "";
         nodetype = "";
         nodename = "";
         online = false;
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
