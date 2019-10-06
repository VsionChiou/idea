package com.codecore.tools;


import com.google.common.primitives.UnsignedLong;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class repStr {
    public String[] convertStr(String str){
        String[] arrStr = str.split("");
        return arrStr;
    }
    public String convertToStr(String str,String feature,String replaced){
        String[] arr = convertStr(str);
        String afterStr = "";
        for (int i=0;i<arr.length;i++){
            if (arr[i].equals(feature)){
                arr[i]=replaced;
            }
            afterStr = afterStr+(arr[i]);
        }
        return afterStr;

    }
    public JsonObject convertTojson(String str,String feature1,String feature2){
        String [] arr = convertStr(str);
        String afterStr = "";
        for (int i=0;i<arr.length;i++){
            if (arr[i].equals(feature1)){
                arr[i]=":";
            }else if(arr[i].equals(feature2)){
                arr[i]=",";
            }

            afterStr = afterStr+(arr[i]);
        }
        afterStr = "{"+afterStr+"}";
        JsonObject valueJson = new JsonParser().parse(afterStr).getAsJsonObject();
        return valueJson;
    }
    public JsonObject convertjson(String str,String feature1,String feature2,String replaced1,String replaced2){
        String [] arr = convertStr(str);
        String afterStr = "";
        for (int i=0;i<arr.length;i++){
            if (arr[i].equals(feature1)){
                arr[i]=replaced1;
            }else if(arr[i].equals(feature2)){
                arr[i]=replaced2;
            }

            afterStr = afterStr+(arr[i]);
        }
        JsonObject valueJson = new JsonParser().parse(afterStr).getAsJsonObject();
        return valueJson;
    }
    public static String toUtf8String(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = String.valueOf(c).getBytes("utf-8");
                } catch (Exception ex) {
                    System.out.println(ex);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0)
                        k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }
    public String toUint64String(long longValue) {
        final String binaryString = Long.toBinaryString(longValue);
        final UnsignedLong unsignedLong = UnsignedLong.valueOf(binaryString, 2);
        return unsignedLong.toString();
    }
/*    public static void main(String[]args){
        repStr rs = new repStr();
        String str = "https://d.pcs.baidu.com/file/dd2885fe517447e85e84a6517a131bd0?fid=3476001706-250528-229644038608058&rt=pr&sign=FDtAER-DCb740ccc5511e5e8fedcff06b081203-VY1dW8fsDxNX7J3dm%2B%2Fz%2F1gKe0s%3D&expires=8h&chkbd=0&chkv=0&dp-logid=2183657506301212034&dp-callid=0&dstime=1569145187&r=508853278";
        String newStr = str.replaceFirst("d.pcs.baidu.com","yqall02.baidupcs.com");
        System.out.println(newStr);


    }*/
}
