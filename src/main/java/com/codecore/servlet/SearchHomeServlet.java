 package com.codecore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codecore.dao.AttentionDao;
import com.codecore.dao.SearchDao;
import com.codecore.entity.Blog;
import com.codecore.entity.UserInfo;
@WebServlet(name = "SearchHomeServlet",urlPatterns = {"/SearchHomeServlet"})
public class SearchHomeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");				 	
	 	String b_content=request.getParameter("textfield1").trim();
	 	HttpSession session=request.getSession();
	 	UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
		int uid=userInfo.getU_id();
	 	int pageNumber = 0;
	 	if (request.getParameter("pageNumber")!=null) {
	 		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}else
			pageNumber=1;
	    int pageSize = 3;
	    SearchDao searchDao=new SearchDao();	
	    int totalPosts = searchDao.allSearchBlogs(b_content,uid);
	    int totalPages = (int)totalPosts/pageSize + ((totalPosts%pageSize)>0?1:0);
	    session.setAttribute("pageSize", pageSize);  
	    session.setAttribute("totalPosts", totalPosts);  
	    session.setAttribute("pageNumber", pageNumber);  
	    session.setAttribute("totalPages", totalPages);
	 	List<Blog> list =new ArrayList<Blog>();
		list =searchDao.searchHome(b_content,uid,pageSize, pageNumber); 	
		session.setAttribute("list", list);
	 	request.getRequestDispatcher("/home1.jsp").forward(request, response);
	}
}
