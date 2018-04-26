/*

    Description: 

    Author: David McRae
    Date: 22-Mar-2018

 */

package javanetwork;
//

public class PC extends DeviceController
{
    
    
    public static void PCComeOnline(DeviceArray SelectAll)
    {
        // Bring devices online using "Nodename"
        // This allows to bring on specific devices rather than all PC's 
        
        if (CheckOnline("switch") == true)
        {
            HostOnline("pc1");
            HostOnline("pc2");
            HostOnline("pc3");
        }
    }
}
