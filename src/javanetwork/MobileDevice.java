/*

    Description: 

    Author: David McRae
    Date: 26-Apr-2018

 */

package javanetwork;
//
public class MobileDevice extends DeviceController
{
    
    public static void MobileDeviceComeOnline(DeviceArray SelectAll)
    {
        // Bring devices online using "Nodename"
        // This allows to bring on specific devices rather than all PC's
        // Mobile Devices can also be a laptop.
        // mobile devices must connect through the WAP
        
        if (CheckOnline("WAP") == true)
        {
            HostOnline("laptop101");
            HostOnline("mobile_device151");
        }
    }
}
