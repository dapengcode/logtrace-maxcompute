package com.manmanbuy.odps.udf;
import com.aliyun.odps.udf.UDF;
public class TitleContainClassName extends UDF {
    // TODO define parameters and return type, e.g:  public String evaluate(String a, String b)
    public Boolean evaluate(String title,String classname) {
        if(title==null || title.isEmpty())return false;
        if(classname==null || classname.isEmpty())return false;
        String[] classNameArray=classname.split("/");
        for (String s:classNameArray){
            if(title.contains(s))return true;
        }
        return false;
    }
}