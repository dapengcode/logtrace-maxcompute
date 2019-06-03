package com.manmanbuy.odps.udf;

import com.aliyun.odps.udf.UDF;

import java.lang.reflect.Array;
import java.rmi.ConnectIOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTmallSaleCount extends UDF {
    // TODO define parameters and return type, e.g:  public String evaluate(String a, String b)
    public Integer evaluate(String dailySold,String day) throws ParseException {
        if(dailySold==null || day==null)return 0;
        String[] dailyCountArray = dailySold.split(",");
        if(dailyCountArray.length==0)return 0;
        for (int i=0;i<dailyCountArray.length;i++){
            String dc=dailyCountArray[i];
            if(!dc.startsWith(day))continue;
            return Integer.parseInt(dc.replace(day+'|',""));
        }
        return 0;
    }
}