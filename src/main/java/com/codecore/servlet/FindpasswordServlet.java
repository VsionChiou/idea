package com.codecore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.codecore.dao.UserDao;
import com.codecore.entity.UserInfo;
@WebServlet(name = "FindpasswordServlet",urlPatterns = {"/FindpasswordServlet"})
public class FindpasswordServlet extends HttpServlet {

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 7437955871310285611L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	 doPost(request,response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
			String u_mail=request.getParameter("email");
	        String u_question=request.getParameter("question");
	        UserDao userDao=new UserDao();
	        UserInfo userInfo=(UserInfo)userDao.findPassword(u_mail, u_question);
	        if(userInfo!=null){
	        	SimpleEmail email = new SimpleEmail();
	    		email.setHostName("smtp.163.com");
	    		try {
	    			email.addTo(userInfo.getU_mail(),userInfo.getU_account());
	    			email.setFrom("CodecoreBlog@163.com", "Codecore");
	    			email.setAuthentication("CodecoreBlog", "codecore");
	    			email.setSubject("Codecore");
	    			email.setMsg("abc"+userInfo.getU_account()+"Codecore"+userInfo.getU_password()+"abc");
	    			email.send();
	    			response.sendRedirect("/findpassword.jsp?msg=10");
	    		} catch (EmailException e) {
	    			// TODO Auto-generated catch block
	    			response.sendRedirect("/findpassword.jsp?msg=7");
	    		}
	        }
	        else{
	        	response.sendRedirect("/findpassword.jsp?msg=7");
	        }
	}

}
