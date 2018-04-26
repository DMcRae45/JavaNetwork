/*
 * Description: Each host must have a MAC address, an IP address and a name.  
 * Types of hosts are: 
 * PCs, with dynamic IP addresses (assume that they are “reserved” addresses, 
 * collected on a DHCP server). 
 * Laptops and Mobile Devices, also with dynamic “reserved” IP addresses. 
 * Servers, which have static IP addresses AND open port numbers for services as follows:
 * 
 * (1) Domain controller – open ports:   67, 68 (DHCP), and 53 (DNS). 
 * (2) File server - open ports: 137-139, 445 (SMB). 
 * (3) Database server - open ports: 1521 (Oracle), 3306 (MySQL), 5432(PostgreSQL). 
 * (4) Web server – open ports: 80 (http), 443(https). 
 * (5) Network printers - open ports: 631, 9100 
 * (6) Gateway – assume that there are no defined open ports. However, a gateway
 *     must have 2 IP    addresses (inside/outside interface).
 * 
 * Author: David McRae
 * Date: 18-Jan-2018
 */
package javanetwork;
//

import static javanetwork.DeviceArray.CurrentConnections;
import static javanetwork.DeviceArray.MaxConnections;
import static javanetwork.DeviceArray.rnd;

/**
 *
 * @author dmcra
 */
public class DeviceController
{   
    public static void DisplayNetworkInfo()
    {
        int RemainingConnections = DeviceArray.MaxConnections - DeviceArray.CurrentConnections;
        
        System.out.println("--- Network Information ---");
        System.out.println("-------------------------------------------------");
        System.out.println("Maximum connections: " + DeviceArray.MaxConnections);
        System.out.println("Current Connections: " + DeviceArray.CurrentConnections);
        System.out.println("Remaining Connections: " + RemainingConnections);
        
        System.out.println(DeviceArray.FindNodeInfo("router"));
        System.out.println(DeviceArray.FindNodeInfo("switch"));
        System.out.println(DeviceArray.FindNodeInfo("domaincontroller"));
        System.out.println(DeviceArray.FindNodeInfo("databaseserver"));
        System.out.println(DeviceArray.FindNodeInfo("webserver"));
        System.out.println(DeviceArray.FindNodeInfo("fileserver"));
        System.out.println(DeviceArray.FindNodeInfo("WAP"));
        System.out.println("-------------------------------------------------");
    }
    
    public static void DisplayNetworkConnections()
    {    
        int RemainingConnections = DeviceArray.MaxConnections - DeviceArray.CurrentConnections;
        
        System.out.println("--- Connection Information ---");
        System.out.println("-------------------------------------------------");
        System.out.println("Maximum connections: " + DeviceArray.MaxConnections);
        System.out.println("Current Connections: " + DeviceArray.CurrentConnections);
        System.out.println("Remaining Connections: " + RemainingConnections);
        System.out.println("-------------------------------------------------");
        
        DeviceArray.FindHostInfo("pc1");
        DeviceArray.FindHostInfo("pc2");
        DeviceArray.FindHostInfo("pc3");

        DeviceArray.FindHostInfo("mobile_device151");
        System.out.println("-------------------------------------------------");
    }
    
    public static boolean ComeOnline(String NodeName)
    {
        System.out.println("--- Come Online ---");
        
        for(DeviceRecord dr : rnd)
        {
            if(CurrentConnections < MaxConnections && NodeName.equals(dr.getNodename()))
            {
                DeviceRecord temp = new DeviceRecord(dr);
                temp.turnMeOn();
                rnd.remove(dr);
                rnd.add(temp);
                CurrentConnections++;
                return true;
                
//                    dr.setOnline(true);
//                    System.out.println(dr.toString());
//                    CurrentConnections++;
//                    System.out.println("");
            }
        }
        return false;
    }
    
    public static boolean CheckOnline(String NodeType)
    {
        //System.out.println("--- Check Online ---");
        
        for(DeviceRecord dr : rnd)
        {
            if(NodeType.equals(dr.getNodetype()))
            {
                //System.out.println(dr.toString() + " --- CHECK");
                return dr.isOnline();
            }
        }
        return false;
    }
    
    public static boolean HostOnline(String NodeName)
    {
        System.out.println("--- Host Come Online ---");
        
        for(DeviceRecord dr : rnd)
        {
            if(CurrentConnections < MaxConnections); 
            {
                if(NodeName.equals(dr.getNodename()))
                {
                    dr.setOnline(true);
                    System.out.println(dr.toString());
                    CurrentConnections++;
                    System.out.println("");
                }
            }
        }
        return false;
    }
}
