/*

    Description: 

    Author: dmcra
    Date: 08-Feb-2018

 */

package javanetwork;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DeviceArray
{
    // Max Connections is 48 x the number of online switches
    public static int MaxConnections = 240; // 48 x 5
    public static int CurrentConnections = 0;
    
    public static ArrayList <DeviceRecord> rnd;

    public DeviceArray() throws ClassNotFoundException, SQLException
    {
        try
        {
            // if we get a problem here ("driver does not exist"): 
            // Click  the project icon / Properties / Libraries -> add (the path to) ojdbc7_g.jar
                
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        }
        catch (ClassNotFoundException c_)
        {
            System.out.println(c_.getMessage());
        }

        rnd = new ArrayList<>() ;
        
        try
        {
            // CAUTION: the connection string needs your ACTUAL user name for connecting to the database!
            
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@//10.1.9.106:1521/sw2", "david", "password");
            java.sql.Statement s = c.createStatement();
            ResultSet rset = s.executeQuery("select * from nwdevices2018 order by id");
            while (rset.next()) {
                DeviceRecord dr = new DeviceRecord();
                dr.setId(rset.getInt(1));
                dr.setMacaddress(rset.getString(2));
                dr.setIpaddress(rset.getString(3));
                dr.setAddressmode(rset.getString(4));
                dr.setNodetype(rset.getString(5));
                dr.setNodename(rset.getString(6));
                rnd.add(dr);
            }
        }
        catch (SQLException s_)
        {
            System.out.println("Error code: " + s_.getErrorCode());
        }
    }
    
    public static void displayDeviceRecords()
    {
        for (DeviceRecord dr : rnd)
        {
            System.out.println(dr.toString());
        }
    }
    
    public static String FindMacAddress(String AMacAddress)
    {
        System.out.println("Find Mac-Address");
        for(DeviceRecord dr : rnd)
        {        
            if(AMacAddress.equals(dr.getMacaddress()))
            {
               System.out.println(dr.toString());
            }
        }
        return AMacAddress;
    }
    
    public static String FindIpAddress(String IpAddress)
    {
        System.out.println("Find IpAddress");
        for(DeviceRecord dr : rnd)
        {        
            if(IpAddress.equals(dr.getIpaddress()))
            {
               System.out.println(dr.toString());
            }
        }
        return IpAddress;
    }
    
    // This method is used for finding "Static" AND "dhcp" Modes
    public static String FindAddressMode(String AddressMode)
    {
        System.out.println("Find Address Mode");
        for(DeviceRecord dr : rnd)
        {        
            if(AddressMode.equals(dr.getAddressmode()))
            {
               System.out.println(dr.toString());
            }
        }
        return AddressMode;
    }
    
    // This Method is used to find node type or device type such as Switch, Router, PC
    public static String FindNodeType(String NodeType)
    {
        System.out.println("--- Find Node Type ---");
        for(DeviceRecord dr : rnd)
        {
            if(NodeType.equals(dr.getNodetype()))
            {
                System.out.println(dr.toString());
            }
        }
        
        return NodeType;
    }
    
    // This Method is used to find node type and display it in a "cleaner" way than 
    // the "FindNodeType" Method
    public static String FindNodeInfo(String NodeType)
    {
        for(DeviceRecord dr : rnd)
        {
            if(NodeType.equals(dr.getNodetype()))
            {
                System.out.println("-------------------------------------------------");
                System.out.println(dr.toString()); 
            }
        }
        
        return NodeType;
    }
    
    public static String FindHostInfo(String NodeName)
    {
        for(DeviceRecord dr : rnd)
        {
            if(NodeName.equals(dr.getNodename()))
            {
                System.out.println(dr.toString()); 
            }
        }
        
        return NodeName;
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
//                    System.out.println(dr.getNodename());
                }
            }
        
        return false;
    }
    
//    public static boolean CheckOnline(String NodeType)
//    {
//        //System.out.println("--- Check Online ---");
//        
//        for(DeviceRecord dr : rnd)
//        {
//            if(NodeType.equals(dr.getNodetype()))
//            {
//                //System.out.println(dr.toString() + " --- CHECK");
//                return dr.isOnline();
//            }
//        }
//        return false;
//    }
//    
//    public static boolean HostOnline(String NodeName)
//    {
//        System.out.println("--- Host Come Online ---");
//        
//        for(DeviceRecord dr : rnd)
//        {
//            if(CurrentConnections < MaxConnections); 
//            {
//                if(NodeName.equals(dr.getNodename()))
//                {
//                    dr.setOnline(true);
//                    System.out.println(dr.toString());
//                    CurrentConnections++;
//                    System.out.println("");
//                }
//            }
//        }
//        return false;
//    }

}

        
    