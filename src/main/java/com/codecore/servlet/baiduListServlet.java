package com.codecore.servlet;

import com.codecore.entity.File;
import com.codecore.entity.access_token;
import com.codecore.entity.baiduofURL;
import com.codecore.tools.httpsGet;
import com.codecore.tools.repStr;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "baiduListServlet",urlPatterns = {"/baiduListServlet"})
public class baiduListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String access_token = (String) request.getAttribute("access_token");
        if (access_token==null){
            access_token = request.getParameter("access_token");
        }
        String dir = request.getParameter("dir");





        httpsGet hg = new httpsGet();
        Gson gson = new Gson();
        baiduofURL URL = new baiduofURL();
        repStr rs = new repStr();

        String flag = null;
        String getListURL = null;


        if (dir==null){
            getListURL = URL.getList(access_token,"/");
        }else {
            getListURL = URL.getList(access_token,dir);
            getListURL = rs.toUtf8String(getListURL);
        }

        String list = hg.getURLContent(getListURL);
        JsonObject listJson = new JsonParser().parse(list).getAsJsonObject();
        if (listJson != null&&listJson.get("errno").getAsInt()==0){
            JsonArray fileList = listJson.getAsJsonArray("list");
            List<File> filelist = gson.fromJson(fileList, new TypeToken<List<File>>(){}.getType());
            request.setAttribute("flag",flag);
            request.setAttribute("access_token",access_token);
            request.setAttribute("filelist",filelist);
        }else if (listJson != null&&listJson.get("errno").getAsInt()==-7){
            flag = "文件或目录名错误或无权访问\n";
            request.setAttribute("flag",flag);
        }else if (listJson != null&&listJson.get("errno").getAsInt()==-9){
            flag = "文件或目录不存在\n";
            request.setAttribute("flag",flag);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/baiduRequest.jsp");
        rd.forward(request,response);

    }
}
