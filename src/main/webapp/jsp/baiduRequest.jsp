<%--
  Created by IntelliJ IDEA.
  User: Vsion
  Date: 2019/7/27
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" import="com.codecore.dao.*" import="com.codecore.entity.*"  pageEncoding="utf-8"%>
<%@ page import="com.google.gson.JsonArray" %>
<%@ page import="com.codecore.tools.repStr" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!
    public String filetype(int category,int isdir){
        String type = null;
        if (category==1){
            type = "<span class='label label-default'>视频</span>";
        }
        else if (category==2){
            type = "<span class='label label-default'>音频</span>";
        }
        else if (category==3){
            type = "<span class='label label-primary'>图片</span>";
        }
        else if (category==4){
            type = "<span class='label label-info'>文档</span>";
        }
        else if (category==5){
            type = "<span class='label label-default'>安装文件</span>";
        }
        else if (category==6&&isdir==1){
            type = "<span class='label label-danger'>文件夹</span>";
        }
        else if (category==6&&isdir==0){
            type = "<span class='label label-success'>文件</span>";
        }
        else if (category==7){
            type = "<span class='label label-warning'>种子</span>";
        }
        return type;
    }
%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>百度网盘</title>

    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script>
        window.onload=function(){
            var oLis=document.getElementsByClassName("mail");
            for(var index=0;index<oLis.length;index++){
                oLis[index].onclick=function(){
                    var b = prom();
                    var c = this.getAttribute("href");
                    console.log(c);
                    var d = c+"&name="+b;
                    this.setAttribute("href",d);
                    var e = this.getAttribute("href");
                    console.log(e);
                }
            }
        }
        function prom() {

            var name = prompt("请输入你要推送的邮箱地址：", "");
            return name;
        }
    </script>

    <style>
        body {
            padding-top: 70px;
            padding-bottom: 30px;
        }

        .theme-dropdown .dropdown-menu {
            position: static;
            display: block;
            margin-bottom: 20px;
        }

        .theme-showcase > p > .btn {
            margin: 5px 0;
        }

        .theme-showcase .navbar .container {
            width: auto;
        }

        #download_url
        {
            white-space:normal;
            word-break:break-all;
            word-wrap:break-word;
        }
    </style>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body role="document">
<div class="container">
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#">网盘</a></li>
        <li role="presentation"><a href="#">离线下载</a></li>
        <li role="presentation"><a data-toggle="modal" href="#about" data-target="#about">关于</a></li>
    </ul>

</div>

<!-- main -->
<div class="container">

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    剩余空间
                    <div class="progress">
                        <div class="progress-bar progress-bar-striped" role="progressbar" aria-valuemin="0" aria-valuemax="100" ><span class="sr-only">$quota_ratio Complete</span> </div>
                    </div>
                    <div class="panel-body">
<%--                        当前目录文件数目: <span class="label label-primary">$len(pcs)</span>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>文件名</th>
                    <th>类型</th>
                    <th>大小</th>
                    <th>修改日期</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><a href="../" class="button">../</a></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                    <%
                        baiduofURL URL = new baiduofURL();
                        String flag = (String) request.getAttribute("flag");
                        repStr rs = new repStr();
                        if (flag==null){
                            List<File> lf = (List<File>)request.getAttribute("filelist");
                            String access_token =  (String) request.getAttribute("access_token");
                            for (File file:lf){
                                if (file.getCategory()==4||file.getCategory()==6&&file.getIsdir()==0){
                                    out.print("<tr><td><a class='mail' href='/baiduDownloadServlet?access_token="+access_token+"&fsid="+file.getFs_id()+"&filename="+file.getServer_filename()+"'>"+file.getServer_filename()+"</a></td>");

                                }else {
                                    out.print("<tr><td><a href='/baiduListServlet?dir="+file.getPath()+"&access_token="+access_token+"'>"+file.getServer_filename()+"</a></td>");
                                }
                                out.print("<td>"+filetype(file.getCategory(),file.getIsdir())+"</td>");
                                out.print("<td>"+file.getSize()+"</td>");
                                out.print("<td>"+file.getLocal_ctime()+"</td></tr>");
                            }

                        }else{
                            out.print(flag);
                        }
                    %>

                </tbody>
            </table>
        </div>
    </div>
</div>
</div> <!-- /container -->

<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script>
    function get_real_url(path)
    {
        $$("#file_url").html("正在获取, 请稍后.");
        $$.ajax(
            {
                url: ("/download/" + path + "/").annotationEncoding='uft-8',
                type: "GET",
                success: function(ajax) {
                    $$("#file_url").html(ajax);
                },
                error: function(ajax) {
                    $$("#file_url").html("获取失败,请重试");
                }
            });

        $$("#download_url").attr("style", "display: block;");

    }
    $$(".url_link").click(function()
    {
        get_real_url($$(this).attr("path"));
    })
    $$('#url_close').click(function()
    {
        $$("#download_url").attr("style", "display: none;");
    })
</script>
</body>
</html>
</html>