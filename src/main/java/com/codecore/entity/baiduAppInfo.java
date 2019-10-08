package com.codecore.entity;

public class baiduAppInfo {
    private static String API_Key = "12fvzXPHDpMqRfYnamEIfY89";
    private static String Secret_Key = "6RWXc6IsRSTd0SKLqwXI9OqAQhZqBd7q";
    private static int App_id = 17200805;
    private static String uri = "http://www.haoqingna521.top/baiduServlet";

    public static String getUri() {
        return uri;
    }

    public static void setUri(String uri) {
        baiduAppInfo.uri = uri;
    }

    public String getAPI_Key() {
        return API_Key;
    }

    public void setAPI_Key(String API_Key) {
        this.API_Key = API_Key;
    }

    public String getSecret_Key() {
        return Secret_Key;
    }

    public void setSecret_Key(String secret_Key) {
        Secret_Key = secret_Key;
    }

    public int getApp_id() {
        return App_id;
    }

    public void setApp_id(int app_id) {
        App_id = app_id;
    }
}
