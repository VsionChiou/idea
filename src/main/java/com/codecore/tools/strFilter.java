package com.codecore.tools;

import java.lang.reflect.Array;

public class strFilter {
    public String getStr(String str){
        String quStr=str.substring(str.indexOf("(")+1,str.indexOf(")"));
        /*if(StringUtil.isEmpty(quStr)){
            return 0;
        }*/
        return quStr;
    }
    public String[] strToarr(String str){
        String[] strArray = null;
        strArray = convertStrToArray(str);
        return strArray;
    }
    public String[] convertStrToArray(String str){
        String[] strArray = null;
        strArray = str.split(","); //拆分字符为"," ,然后把结果交给数组strArray
        return strArray;
    }
/*    public static void main(String [] args){
//        String json = "jsonpgz({\"fundcode\":\"519983\",\"name\":\"长信量化先锋混合A\",\"jzrq\":\"2019-07-15\",\"dwjz\":\"1.3010\",\"gsz\":\"1.3035\",\"gszzl\":\"0.19\",\"gztime\":\"2019-07-16 15:00\"})";
        strFilter strFilter = new strFilter();
        System.out.println(strFilter.strToarr("a,b,c,d")[0]);
    }*/
}
