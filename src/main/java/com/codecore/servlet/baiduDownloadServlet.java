package com.codecore.servlet;

import com.codecore.entity.SendMail;
import com.codecore.entity.baiduofURL;
import com.codecore.tools.httpsGet;
import com.codecore.tools.repStr;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;

@WebServlet(name = "baiduDownloadServlet",urlPatterns = {"/baiduDownloadServlet"})
public class baiduDownloadServlet extends HttpServlet {
    private SendMail SendMailAcceUtils;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String access_token = request.getParameter("access_token");
        String fsid = request.getParameter("fsid");
        String filename = request.getParameter("filename");
        String mailname = request.getParameter("name");

        baiduofURL URL = new baiduofURL();
        httpsGet hg = new httpsGet();
        repStr rs = new repStr();
        SendMail sendmail = new SendMail();

        String down = URL.getDownload(access_token,fsid);
        String downRes = hg.getURLContent(down);
        JsonObject returnData = new JsonParser().parse(downRes).getAsJsonObject();

        JsonArray fileList = returnData.getAsJsonArray("list");
        JsonObject f = rs.convertjson(fileList.toString(),"[","]","","");
        String path = this.getServletContext().getRealPath("down/");

        String url = f.get("dlink").toString();
        url = rs.convertToStr(url,"\"","");
        url = url.replaceFirst("d.pcs.baidu.com","yqall02.baidupcs.com");
        hg.downLoadFromUrl(url,filename,path);
        path = path+filename;
        String receive=mailname;
        String subject =filename;
        String msg ="";
        try {
            SendMailAcceUtils.sendMail(receive, subject, msg, path);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
