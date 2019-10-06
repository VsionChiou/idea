package com.codecore.dao;

import com.codecore.dbutil.DBConn;

import java.sql.ResultSet;

public class SumData {
    public int getSum(String table){
        int sum = 0;
        String StrSQL = "select count(*) from userinfo";
        DBConn dbConn = new DBConn();
        ResultSet rs = dbConn.execQuery(StrSQL,new Object[]{});
        try{
            while(rs.next()){
                sum = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sum;
    }
    public static void main(String []args){
        SumData sumData = new SumData();
        System.out.println(sumData.getSum("userinfo"));
    }
}
