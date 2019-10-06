package com.codecore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codecore.dao.RegisterDao;
@WebServlet(name = "CheckMailServlet",urlPatterns = {"/CheckMailServlet"})

public class CheckMailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String jsEmail=request.getParameter("jsemail");
		RegisterDao registerDao=new RegisterDao();
		String requestContext="false";
		if (registerDao.checkMail(jsEmail)) {
			requestContext="true";
		}
		out.print(requestContext);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
