package com.myclass.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

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
}
