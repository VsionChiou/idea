package com.codecore.servlet;

import com.codecore.entity.access_token;
import com.codecore.entity.baiduAppInfo;
import com.codecore.entity.baiduofURL;
import com.codecore.tools.httpsGet;
import com.codecore.tools.repStr;
import com.google.gson.Gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "baiduServlet",urlPatterns = {"/baiduServlet"})
public class baiduServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String codeStr = request.getQueryString();

        repStr rs = new repStr();
        baiduAppInfo appInfo = new baiduAppInfo();
        httpsGet hg = new httpsGet();
        Gson gson = new Gson();
        baiduofURL URL = new baiduofURL();
        access_token at = null;

        String code = "";
        if (codeStr!=null){
            JsonObject json = rs.convertTojson(codeStr,"=","&");
            code = json.get("code").toString();
        }


        String access_tokenUrl = URL.getAccess_token(code,appInfo.getAPI_Key(),appInfo.getSecret_Key(),appInfo.getUri());
        if (access_tokenUrl!=null){//access_token获取
            String access_tokenRes = hg.getURLContent(access_tokenUrl);
            JsonObject returnData = new JsonParser().parse(access_tokenRes).getAsJsonObject();
            if (returnData.get("error")==null){
                at = gson.fromJson(access_tokenRes,access_token.class);
                String access_token = at.getAccess_token();
                request.setAttribute("access_token",access_token);
                RequestDispatcher rd = request.getRequestDispatcher("/baiduListServlet");
                rd.forward(request,response);
            }

        }

    }
}
