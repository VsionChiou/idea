package com.codecore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codecore.dao.AttentionDao;
import com.codecore.dao.MyBlogDao;
import com.codecore.entity.Blog;
@WebServlet(name = "DeleteBlogServlet",urlPatterns = {"/DeleteBlogServlet"})

public class DeleteBlogServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4281028282262615973L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		int bid=Integer.parseInt(request.getParameter("bid"));
		int uid=Integer.parseInt(session.getAttribute("userId").toString());
		AttentionDao attentionDao=new AttentionDao();
		attentionDao.deleteBlog(uid, bid);
		MyBlogDao myBlogDao=new MyBlogDao();
	 	int pageNumber = 0;  
	 	if (request.getParameter("pageNumber")!=null) {
	 		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}else
			pageNumber=1;
	    int pageSize = 3;
	    int totalPosts = (int)attentionDao.accountBlogs(uid);
	    int totalPages = (int)totalPosts/pageSize + ((totalPosts%pageSize)>0?1:0);
	    session.setAttribute("p_pageSize", pageSize);
	    session.setAttribute("p_totalPosts", totalPosts);
	    session.setAttribute("p_pageNumber", pageNumber);
	    session.setAttribute("p_totalPages", totalPages);
	    List<Blog> mybloglist  = myBlogDao.getMyBlogByUid(uid,pageSize, pageNumber);
	 	session.setAttribute("blogList", mybloglist);
	 	session.setAttribute("curBlogs", totalPosts);
		session.setAttribute("userId", uid);
		response.sendRedirect("/profile.jsp");
	}
}
