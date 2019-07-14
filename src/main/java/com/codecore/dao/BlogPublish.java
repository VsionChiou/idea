package com.codecore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.codecore.dbutil.DBConn;
import com.codecore.entity.Blog;

/**
 * @version1.0
 * @author Vincent
 */
public class BlogPublish {
	
	public boolean blogpublish(Blog blog){
		
		//�����װ��������ԣ���֯SQL���
		String b_content = blog.getB_content();
		String b_img = blog.getB_img();
		Date b_time =  new Date(System.currentTimeMillis());
		int u_id=blog.getU_id();
		String strSQL = "insert into blog (b_content, b_img, b_time, u_id) values(?,?,?,?)";
		DBConn dbConn = new DBConn();
		int affectedRows = dbConn.execOther(strSQL, new Object[]{b_content,b_img, b_time, u_id});
		dbConn.closeConn();
		return affectedRows >0?true:false;
	}
	public boolean blogpublish(Blog blog, int uid){
		
		String b_content = blog.getB_content();
		String b_img = blog.getB_img();
		Date b_time =  new Date(System.currentTimeMillis());
		String strSQL = "insert into blog (b_content, b_img, b_time, u_id) values(?,?,?,?)";
		DBConn dbConn = new DBConn();
		int affectedRows = dbConn.execOther(strSQL, new Object[]{b_content,b_img, b_time, uid});
		dbConn.closeConn();
		return affectedRows >0?true:false;
	}
	public boolean dispatchBlog(Blog blog, int old, int uid){
		DBConn dbConn=new DBConn();
		String sqlOld="update blog set b_degree=? where b_content=?";
		blogpublish(blog,uid);
		int row=dbConn.execOther(sqlOld, new Object[]{old+1, blog.getB_content()});
		dbConn.closeConn();
		return row>0?true:false;
	}

	public int accountDispatch(final int bid){
		DBConn dbConn=new DBConn();
		String sql="select b_degree from blog where b_id=?";
		ResultSet rs=dbConn.execQuery(sql, new Object[]{bid});
		int result=0;
		try {
			while (rs.next()) {
				result =rs.getInt("b_degree");
			}
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
		}finally{
			dbConn.closeConn();
		}
	}
	public Blog getBlogById(final int bid){
		DBConn dbConn=new DBConn();
		String sql="select * from blog where b_id=?";
		ResultSet rs=dbConn.execQuery(sql, new Object[]{bid});
		Blog blog=new Blog();
		try {
			while (rs.next()) {
				blog.setB_content(rs.getString("b_content"));
				blog.setB_img(rs.getString("b_img"));
				blog.setB_time(rs.getDate("b_time"));
				blog.setU_id(rs.getInt("u_id"));
				blog.setB_degree(rs.getInt("b_degree"));
				blog.setB_id(rs.getInt("b_id"));
				blog.setB_date(rs.getTime("b_time"));
			}
			return blog;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}finally{
			dbConn.closeConn();
		}
	}
}
