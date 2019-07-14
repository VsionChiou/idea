package com.codecore.dbutil;

import java.sql.*;

import static java.time.ZoneOffset.UTC;


public class DBConn {
    public static final String CLASS_NAME="com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_URL="jdbc:mysql";
    public static final String SERVER_IP="localhost";
    public static final String SERVER_PORT="3306";
    public static final String DATABASE_SID="codecore";
    public static final String USERNAME="root";
    public static final String PASSWORD="12345666";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private void getConntion(){
		try {
			Class.forName(CLASS_NAME);
			String url = DATABASE_URL+"://"+SERVER_IP+":"+SERVER_PORT+"/"+DATABASE_SID+"?serverTimezone=UTC&useSSL=false";
			conn = DriverManager.getConnection(url,USERNAME,PASSWORD);
//			System.out.println("....");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
	

	public void closeConn(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public int execOther(final String strSQL,final Object[] params ){
		getConntion();
		try {
			pstmt = conn.prepareStatement(strSQL);
			for(int i=0; i< params.length ;i++){
				pstmt.setObject(i+1, params[i]);
			}
			int affectedRows = pstmt.executeUpdate();
			return affectedRows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	public ResultSet execQuery(final String strSQL,final Object[] params){
		getConntion();
		try {
			pstmt = conn.prepareStatement(strSQL);
			for(int i=0; i< params.length ;i++){
				pstmt.setObject(i+1, params[i]);
			}		
			rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


/*	public static void main(String []args){
		DBConn dbConn = new DBConn();
		dbConn.getConntion();
	}*/
}
