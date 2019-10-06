package com.codecore.entity;

import com.codecore.tools.repStr;

public class baiduofURL {

    repStr rs = new repStr();
    public String getCode(String API_Key,String uri){
        String url = "https://openapi.baidu.com/oauth/2.0/authorize?response_type=code&client_id="+API_Key+"&redirect_uri="+uri+"&scope=basic,netdisk&state=STATE";
        url = rs.convertToStr(url,"\"","");
        return url;
    }
    public String getAccess_token(String code,String API_Key,String SECRET_KEY,String uri){
        String url = "https://openapi.baidu.com/oauth/2.0/token?grant_type=authorization_code&code=".concat(code)+"&client_id="+API_Key+"&client_secret="+SECRET_KEY+"&redirect_uri="+uri;
        url = rs.convertToStr(url,"\"","");
        return url;
    }
    public String refreshAccess_token(String REFRESH_TOKEN,String API_KEY,String SECRET_KEY){
        String url = "https://openapi.baidu.com/oauth/2.0/token?grant_type=refresh_token&refresh_token="+REFRESH_TOKEN+" &client_id="+API_KEY+"&client_secret="+SECRET_KEY;
        url = rs.convertToStr(url,"\"","");
        return url;
    }
    public String getUinfo(String access_token){
        String url = "https://pan.baidu.com/rest/2.0/xpan/nas?method=uinfo&access_token="+access_token;
        url = rs.convertToStr(url,"\"","");
        return url;
    }
    public String getList(String access_token,String dir){
        String url = "https://pan.baidu.com/rest/2.0/xpan/file?method=list&access_token="+access_token+"&dir="+dir+"&start=0&&web=web";
        url = rs.convertToStr(url,"\"","");
        return url;
    }
    public String getDownload(String access_token,String fsid){
        String url = "https://pan.baidu.com/rest/2.0/xpan/multimedia?method=filemetas&dlink=1&access_token="+access_token+"&fsids=["+fsid+"]";
        url = rs.convertToStr(url,"\"","");
        return url;
    }




}
