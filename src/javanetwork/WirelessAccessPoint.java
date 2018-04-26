/*
 * Description: The WAPs have a MAC address and an IP address (static).  
 * Allow laptops and mobile devices to be connected to them.  WAPs must be 
 * connected to a switch, and they must maintain a list of MAC addresses  of 
 * devices (currently) attached.
 * Laptops and mobile devices CANNOT connect to the network if WAPs are offline
 * 
 * Author: David McRae
 * Date: 18-Jan-2018
 */
package javanetwork;
//
/**
 *
 * @author dmcra
 */
public class WirelessAccessPoint extends DeviceController
{
    public static void WAPComeOnline(DeviceArray SelectAll)
    {
        String WAP = "WAP";
        
        ComeOnline(WAP);
    }
}
