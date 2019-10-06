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

import com.codecore.dao.CollectDao;
import com.codecore.entity.Collect;
import com.codecore.entity.UserInfo;
@WebServlet(name = "ShowCollectServlet",urlPatterns = {"/ShowCollectServlet"})
public class ShowCollectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 	
		HttpSession session=request.getSession();
		int uid=0;
	 	if (request.getParameter("curUid")!=null) {
	 		uid=Integer.parseInt(request.getParameter("curUid"));
		}else{
			UserInfo userInfo=(UserInfo)session.getAttribute("userInfo");
			uid=userInfo.getU_id();
		}	 		
	 	int pageNumber = 0;
	 	if (request.getParameter("pageNumber")!=null) {
	 		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}else
			pageNumber=1;
	    int pageSize = 3;
	    CollectDao collectDao=new CollectDao();
	    int totalPosts = collectDao.allCollects(uid);
	    int totalPages = (int)totalPosts/pageSize + ((totalPosts%pageSize)>0?1:0);
	    session.setAttribute("pageSize", pageSize);  
	    session.setAttribute("totalPosts", totalPosts);  
	    session.setAttribute("pageNumber", pageNumber);  
	    session.setAttribute("totalPages", totalPages);
	    List<Collect> listAll=new ArrayList<Collect>();	 
	    listAll=collectDao.getCollect(uid, pageSize, pageNumber);
	 	session.setAttribute("listAllCollect", listAll);	
	 	response.sendRedirect("/collect.jsp");
	}
}
