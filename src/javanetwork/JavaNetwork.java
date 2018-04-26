/*
 * Description: 2017/2018 OOP Assessment Networking in java
 * 
 * Author: David McRae
 * Date: 18-Jan-2018
 */
// REFER to file:///E:/s.binder/10_OOP/__project2018__/OOP_assessment_2018.pdf
// --- GOALS ---
// Develop a program (in Java) that will allow the user to keep track of devices 
// connected to a company computer network.  Assume that the network 
// uses private IPv4 addressing (with 32 bit addresses).
//NETWORK CONVERGENCE
//When the network converges, the switches and the routers 
//boot up first.  Then, the servers and network printers come "online".  After 
//that, PCs, laptops, and mobile devices can connect/disconnect to/from the network 
//randomly. 
//Whenever one of the hosts with a static IP address connects to the network, the 
//(central) network switch must register/update its MAC address table.   
//Whenever a mobile (wireless) device connects to the network, its MAC address 
//gets registered on a WAP. 
//When a host disconnects from the network, their MAC entries must be removed by 
//the responsible devices (switches and WAPs). 
package javanetwork;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javanetwork.DeviceController.CheckOnline;
import static javanetwork.DeviceController.ComeOnline;

public class JavaNetwork
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        
        DeviceArray SelectAll = new DeviceArray();
        
        //DeviceArray.displayDeviceRecords();
        
        routerComeOnline();
        switchComeOnline();
        
        DeviceController.DisplayNetworkInfo();
             
//          switchComeOnline();
//          serversComeOnline();

    }
    public static void routerComeOnline()
    {
        Device router = new Device();
        
        DeviceController.ComeOnline("router");
        router.setOnline();
        System.out.println("Router: " + router.toString());
    }
    
    public static void switchComeOnline()
    {
        // --- switch can come online IF the router is online ---
        
        if (CheckOnline("router"))
        {
            Device networkSwitch = new Device();
            
            DeviceController.ComeOnline("switch_1");
            networkSwitch.setOnline();
            System.out.println("Switch: " + networkSwitch.toString());
        }
    }
        
    public static void serversComeOnline() 
    {
        //Set servers to online IF Router & Switch are online.
        // --- switch will not be online unless router is online ---
        
        if (CheckOnline("switch") == true)
        {
            Server server = new Server();        

            ComeOnline("domaincontroller");
            ComeOnline("databaseserver");
            ComeOnline("webserver");
            ComeOnline("fileserver"); 
        }

    }

    public static void DisplayAllRows(DeviceArray SelectAll)
    {
        SelectAll.displayDeviceRecords();
    }

    public static void DisplaySingleMacAddress()
    {
        try
        {
            DeviceArray SelectMac = new DeviceArray();
            String AMacAddress = "8a:22:99:bd:ab:8e";
            SelectMac.FindMacAddress(AMacAddress);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaNetwork.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JavaNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void DisplaySingleIpAddress()
    {
        try
        {
            DeviceArray SelectIp = new DeviceArray();
            String IpAddress = "10.1.1.200";
            SelectIp.FindIpAddress(IpAddress);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaNetwork.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JavaNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void DisplayAllAddressModeStatic()
    {
        try
        {
            DeviceArray SelectStatic = new DeviceArray();
            String AddressMode = "static";
            SelectStatic.FindAddressMode(AddressMode);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaNetwork.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JavaNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void DisplayAllAddressModeDhcp()
    {
        try
        {
            DeviceArray SelectDhcp = new DeviceArray();
            String AddressMode = "dhcp";
            SelectDhcp.FindAddressMode(AddressMode);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaNetwork.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JavaNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void DisplayNodeType(DeviceArray SelectAll)
    {
        try
        {
            DeviceArray SelectNodeType = new DeviceArray();
            
            String Switch = "switch";
            
            SelectNodeType.FindNodeType(Switch);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaNetwork.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JavaNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void MobileDeviceComeOnline(DeviceArray SelectAll)
    {
        // Bring devices online using "Nodename"
        // This allows to bring on specific devices rather than all PC's
        // Mobile Devices can also be a laptop.
        // mobile devices must connect through the WAP
        
        if (DeviceController.CheckOnline("WAP") == true)
        {
            DeviceController.HostOnline("mobile_device151");
        }
    }

}
