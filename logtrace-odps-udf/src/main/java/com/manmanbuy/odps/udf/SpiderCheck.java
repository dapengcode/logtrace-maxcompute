package com.manmanbuy.odps.udf;

import com.aliyun.odps.udf.UDF;

/*

 */
public class SpiderCheck extends UDF {
    public Boolean evaluate(String s) {
        if(null==s || s.isEmpty())return false;
        String[] logArray=s.split("%0D%0A");
        if(null == logArray ||  logArray.length==0)return false;
        for(String agent:logArray){
            if(!agent.startsWith("UserAgent"))continue;
            if(agent.contains("Baiduspider"))return true; //排除百度爬虫
            if(agent.contains("Sogou web spider"))return true; //排除搜狗爬虫
            if(agent.contains("bingbot"))return true; //排除bing搜索
            if(agent.contains("YisouSpider"))return true; //易搜
            if(agent.contains("AhrefsBot"))return true;//Ahrefs
            if(agent.contains("Googlebot"))return true;//google
        }
        return false;
    }
}