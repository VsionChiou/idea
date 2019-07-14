package com.codecore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codecore.dao.AttentionDao;
import com.codecore.dao.RegisterDao;
import com.codecore.entity.Blog;
import com.codecore.entity.UserInfo;
@WebServlet(name = "RegisterServlet",urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

	/**
	 * ע����֤
	 */
	private static final long serialVersionUID = -478052340582521550L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mail=request.getParameter("email");
		String nick=request.getParameter("nickname");
		String pwd=request.getParameter("npassword");
		String rpwd=request.getParameter("rpassword");
		String sex=request.getParameter("sex");
		String addr=request.getParameter("city");
		String jsEmail=request.getParameter("jsemail");
		RegisterDao registerDao=new RegisterDao();
		UserInfo userInfo=new UserInfo();
		userInfo.setU_mail(mail);
		userInfo.setU_password(rpwd);
		userInfo.setU_nick(nick);
		userInfo.setU_addr(addr);
		userInfo.setU_sex(sex);
		userInfo.setU_account(mail);
		userInfo.setU_img("/CodecoreMicroblog/face/NoName.jpg");
		boolean flag=registerDao.addUser(userInfo);
		if (flag) {
			HttpSession session=request.getSession();
			userInfo=registerDao.getInfoByAccount(mail);
			AttentionDao attentionDao=new AttentionDao();
			ArrayList<Blog> listAll=new ArrayList<Blog>();
    	 	String pageNumberStr = request.getParameter("pageNumber");
    	    int pageNumber = 1;  
    	    if(pageNumberStr!=null && !pageNumberStr.isEmpty())  
    	    {  
    	        pageNumber = Integer.parseInt(pageNumberStr);  
    	    }  
    	    int pageSize = 3;
    	    int totalPosts = attentionDao.allBlogs(userInfo.getU_id());
    	    //int totalPosts = attentionDao.allBlogs(65);
    	    int totalPages = (int)totalPosts/pageSize + ((totalPosts%pageSize)>0?1:0);
    	    session.setAttribute("pageSize", pageSize);  
    	    session.setAttribute("totalPosts", totalPosts);  
    	    session.setAttribute("pageNumber", pageNumber);  
    	    session.setAttribute("totalPages", totalPages);  
    	 	listAll=attentionDao.getBlog(userInfo.getU_id(), pageSize, pageNumber);
    	 	
    	 	session.setAttribute("listAll", listAll);
			
			session.setAttribute("userId", userInfo.getU_id());
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}else{
		response.sendRedirect("/register.jsp?msg=6");
		}
	}

}
