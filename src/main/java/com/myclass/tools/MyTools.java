package com.myclass.tools;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * MyTools
 *
 * @author joe
 */
public class MyTools {

    /**
     * 格式化Date类型数据为
     * yyyy-MM-dd HH:mm:ss 格式
     * @param date
     * @return
     */
    public static String registerDateFormat(Date date) {
        if (date != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.format(date);
        }
        return null;
    }

    /**
     * 功能描述:
     * 〈获取主机ip地址〉
     *
     * @return java.lang.String
     * @author 蜀山剑仙
     * @date 2019/7/31 下午4:17
     */
    private static String getHostIP(){
        String tempIP = "127.0.0.1";
        try {
            tempIP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }
        System.out.println(tempIP);
        try{
            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            Enumeration<InetAddress> addrs;
            while (networks.hasMoreElements())
            {
                addrs = networks.nextElement().getInetAddresses();
                while (addrs.hasMoreElements())
                {
                    ip = addrs.nextElement();
                    if (ip != null
                            && ip instanceof Inet4Address
                            && ip.isSiteLocalAddress()
                            && !ip.getHostAddress().equals(tempIP))
                    {
                        return ip.getHostAddress();
                    }
                }
            }
            return tempIP;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
