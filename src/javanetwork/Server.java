/*

    Description: hosts or Pc's will be accessing the server as it acts like a hard 
    drive that other people are trying to access.

    Author: David McRae
    Date: 01-Feb-2018

 */
package javanetwork;

public class Server extends DeviceController
{
    // refactor, encapsulate fields
    private int id;
    private String macaddress;
    private String ipaddress;
    private String addressmode;
    private String nodetype;
    private String nodename;
    private boolean online;
    
    public Server()
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

