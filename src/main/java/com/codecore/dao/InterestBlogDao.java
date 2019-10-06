package com.codecore.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.codecore.dbutil.DBConn;
import com.codecore.entity.Blog;
/**
 * 
 * @author Vincent
 */

public class InterestBlogDao {

	public List<Blog> getInterestBlogByUid(final int uid){
		List<Blog> interestbloglist = new ArrayList<Blog>();
		String strSQL = "SELECT * from blog where u_id=? limit 0,5";
		DBConn dbConn = new DBConn();
		ResultSet rs = dbConn.execQuery(strSQL, new Object[]{uid});
		try {
		
			while(rs.next()) {
				Blog interestblog=new Blog();
				interestblog.setB_content(rs.getString("b_content"));
				interestblog.setB_time(rs.getDate("b_time"));
				interestblog.setU_id(rs.getInt("u_id"));
				interestblog.setB_img(rs.getString("b_img"));
				interestblog.setB_degree(rs.getInt("b_degree"));
				interestblog.setB_id(rs.getInt("b_id"));
				interestblog.setB_date(rs.getTime("b_time"));
				interestbloglist.add(interestblog);
			}
		   	return interestbloglist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			dbConn.closeConn();
		}
		
	}

}
