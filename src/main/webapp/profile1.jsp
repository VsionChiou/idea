<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.codecore.entity.Blog"%>
<%@page import="com.codecore.dao.MyBlogDao"%>
<%@page import="com.codecore.dbutil.DBConn"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" type="text/css" href="css/profile.css" />
<title>微博 - ${userInfo.u_nick}的微博</title>
<script type="text/javascript" src="script/profile.js"></script>
<script type="text/javascript" src="script/page.js"></script>
<script type="text/javascript" src="script/imgchange.js"></script>
</head>
<body>
<!-- header开始-->
<table id="header" align="center" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="20%" align="center"><span style="width: 178px;height: 62px;font-size: 50px;">idea</span></td>
    <td width="55%" align="right">
      <table border="0" align="right" cellpadding="0" cellspacing="0" id="daohang">
        <tr>
          <td width="20%"><a href="<%=request.getContextPath()%>/ShowAttentionBlogServlet?curUid=${userInfo.u_id}">我的首页</font></a></td>
          <td width="20%"><a href="<%=request.getContextPath()%>/PageServlet?curUid=${userInfo.u_id}">我的博客</a></td>
          <td width="20%"><a href="/ShowFriendsServlet?u_id=${userInfo.u_id}">我的好友</a></td>
          <td width="20%"><a href="user.jsp">随便看看</a></td>
        </tr>
      </table>
    </td>
    <td width="25%" align="right">
      <table id="welcome" border="0" cellspacing="0" cellpadding="0">
        <tr>          
          <td width="30" height="30" rowspan="2" class="userface_bg"><img src="${userInfo.u_img}" border="0" width="20" height="20" /></td>
          <td>欢迎您，${userInfo.u_nick}！</td>
        </tr>
        <tr>
          <td><a href="index.jsp">[ 退出 ]</a></td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<!-- header结束-->
<!-- container 开始-->
<table border="0" align="center" cellpadding="0" cellspacing="0" id="container">
  <tr>
    <td width="670" height="600" valign="top"><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" id="curruser">
      <tr>
        <td width="24%"><img src="${userInfo.u_img}" width="120" height="120" class="userphoto" /></td>
        <td width="76%" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" id="curruserdetail">
          <tr>
            <td class="title">${userInfo.u_nick}</td>
          </tr>
          <tr>
            <td><p><a href="<%=request.getContextPath()%>/ShowAttentionBlogServlet?curUid=${userInfo.u_id}">${userInfo.u_url}<br />
              </a>${userInfo.u_addr}<a href="#">
              </a><br />
            签名：${userInfo.u_sign}<br />
            <a href="myface.jsp">修改头像</a> | <a href="userinfo.jsp">修改签名</a></p></td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="menu">
          <tr>
            <td width="33%" align="center"><table width="165" border="0" align="center" cellpadding="0" cellspacing="0">
            </table></td>
            <td width="18%" align="right">&nbsp;</td>
            <td width="49%" align="center"><form id="form1" name="form1" method="post" action="/SearchProfileServlet">
              <input name="textfield2" type="text" class="input" id="textfield2" />
              <input name="button" type="submit" class="btnsearch" id="button" value="搜索" />
            </form></td>
          </tr>
      </table>
        <!-- weibo 开始-->
   <%
          int uid=Integer.parseInt(request.getSession().getAttribute("userId").toString());
	      List<Blog> mybloglist=null;
	      if(session.getAttribute("list")!=null){
	      		mybloglist  = (List<Blog>) session.getAttribute("list");	
	      		
	      }else{
	      		MyBlogDao myBlogDao=new MyBlogDao();
	      		mybloglist  = myBlogDao.getMyBlogByUid(uid,3, 1);
	      }
	      Iterator it=mybloglist.iterator();
	      while(it.hasNext()){
	      		Blog blog=new Blog();
	      		blog=(Blog)it.next();
	      		pageContext.setAttribute("myblog",blog);
	      %>
	      <table id="weibo" width="90%" border="0" align="center" cellpadding="3" cellspacing="0" >
          <tr>
            <td width="88%" class="content">${myblog.b_content}</td>
          </tr>
          <tr>
            <td><%
            	if(blog.getB_img()!=null){%>
            		<img src="${myblog.b_img}" width="89" height="120" name="image1" id="imgid${myblog.b_id}" style="cursor:url(mouse/0001.ani)" onclick="bigsmall(${myblog.b_id})"/>
            	<%}
             %></td>
          </tr>
          <tr>
            <td height="25"><table width="100%" border="0" cellpadding="0" cellspacing="0" id="weibo_status" >
              <tr>
                <td>${myblog.b_time}&nbsp;${myblog.b_date}</td>
                <td align="right" ><a href="<%=request.getContextPath()%>/DeleteBlogServlet?bid=${myblog.b_id}" style="text-decoration: none">删除</a>
                 &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/AddCollectServlet?bid=${myblog.b_id}&type=profile" style="text-decoration: none">收藏</a>
                </td>
              </tr>
            </table></td>
          </tr>
    </table>
<%} %>     
<!-- 分页开始 -->
<table align="center" id="page">
	<form action="/PageServlet?pageNumber=1" id="navigatorForm">
      <tr>
        <td align="right"><a style="text-decoration: none" href="<%=request.getContextPath()%>/PageServlet?pageNumber=1">首页</a>&nbsp;
        	第 <select name="pageNumber" onchange="gotoSelectedPage()">
        			  <c:forEach begin="1" end="${p_totalPages}" step="1" var="pageIndex">  
       					 <c:choose>  
            				<c:when test="${pageIndex eq p_pageNumber}">  
               					 <option value="${pageIndex}" selected="selected">${pageIndex}</option>  
            				</c:when>  
           				 <c:otherwise>  
                			<option value="${pageIndex}">${pageIndex}</option>  
            			 </c:otherwise>  
       					</c:choose>  
    				</c:forEach>  
				  </select>&nbsp;页
           &nbsp;<a style="text-decoration: none" href="<%=request.getContextPath()%>/PageServlet?pageNumber=${p_pageNumber+1}">下一页</a>
	   </td>
      </tr>
      </form>
    </table>
  <!-- weibo 结束-->
    </td>
	    <td width="280" align="center" valign="top" class="pageright">
        <!-- userinfo 开始-->
        <table align="center" id="userinfo">
          <tr>
            <td width="75%" align="left"><table width="80%" border="0" align="left" cellpadding="3" cellspacing="0">
              <tr>
                <td align="center" class="split2"><a href="/ShowFollowingServlet?u_id=${userInfo.u_id}">关注</a><br>${attention}</td>
                <td align="center" class="split2"><a href="/ShowFansServlet?u_id=${userInfo.u_id}">粉丝</a><br>${fans}
                </td>
                <td align="center"><a href="<%=request.getContextPath()%>/PageServlet?curUid=${userInfo.u_id}">微博</a><br>
                ${curBlogs}</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td class="split1"><a href="userinfo.jsp">个人账户设置</a></td>
          </tr>
           <tr>
            <td colspan="2" class="split1"><a href="<%=request.getContextPath()%>/ShowCollectServlet?curUid=${userInfo.u_id}"> 我的收藏</a></td>
          </tr> 
        </table>
        <table border="0" align="center" cellpadding="0" cellspacing="0" id="userlist">
          <tr>
            <td class="title" height="29">可能感兴趣的人</td>
            <td align="right" class="title"></td>
          </tr>
           <%
            int intPageSize=5;
            int intPageCount;
            int intRowCount;
            int intPage;
            int i;
            String strPage;
            strPage = request.getParameter("page");
            if(strPage==null){
            intPage=1;
            }else{
            intPage=Integer.parseInt(strPage);
            if(intPage<1) intPage = 1;
            }
             	String strSQL = "SELECT * FROM userinfo where u_id!=? and u_id not in" +
				" (select f_gid from friends where f_state=1 and f_uid=?) and u_id not in " +
				"(select f_gid from friends where f_state=2 and f_uid=?) and u_id not in " +
				"(select f_uid from friends where f_state=2 and f_gid=?) limit 0,1000";
			DBConn dbConn = new DBConn();
			ResultSet rs = dbConn.execQuery(strSQL, new Object[]{uid,uid,uid,uid});
			rs.last();
			intRowCount= rs.getRow();
			intPageCount = (intRowCount+intPageSize-1)/intPageSize;
			if(intPage>intPageCount)
			      intPage = intPageCount;
			if(intPageCount>0){
			      rs.absolute((intPage-1)*intPageSize+1);
			      i=0;
			      while(i<intPageSize&&!rs.isAfterLast()){%>      	
                  
       
          <tr>
            <td colspan="2"><table border="0" cellpadding="0" cellspacing="0" class="userdetail">
              <tr>
                <td width="26%"><a href="user.jsp"><img src="<%=rs.getString("u_img")%>" width="50" height="50" border="0" /></a></td>
                <td width="74%"><a href="user.jsp"><%=rs.getString("u_nick")%></a> 
                <a href="<%=request.getContextPath()%>/AddAttentionServlet?goal_uid=<%=rs.getInt("u_id")%>&flag=profile" class="btnguanzhu">+关注</a>
                <br />
                <%=rs.getString("u_addr")%><br />生日：<%=rs.getString("u_date")%></td>
              </tr>
            
            </table></td>
            
              <%
              rs.next();
              i++;
              }
              }
               %>
          </tr>
                 
        </table>
            <table class="userdetail">  <tr><td > <%
                if(intPage<intPageCount){
                
              %>
                 <center> <a  href="profile.jsp?page=<%=intPage+1%>">[换一换]</a> </center><%} %>
             </td>
             </tr> 
          </table>
         
        <!-- userinfo 结束--></td>
          
  </tr>
    
	</table>
<!-- container 结束-->

<!--footer开始-->
<table id="footer" border="0" align="center" cellpadding="3" cellspacing="0">
    <tr>
    <td width="534" align="left"><a href="http://help.sina.com.cn/p/i_12.html">帮助</a>&nbsp;&nbsp; <a href="http://weibo.com/signup/signup.php?c=&type=&inviteCode=&code=&spe=&lang=">意见反馈</a>&nbsp;&nbsp; 
    <a href="http://weibo.com/login.php?url=http%3A%2F%2Fweibo.com%2Fpub%2Fverified">微博认证及合作</a>&nbsp;&nbsp;
     <a href="http://open.weibo.com/">开放平台</a>&nbsp;&nbsp; <a href="http://hr.t.sina.com.cn/">微博招聘</a>&nbsp;&nbsp;
      <a href="http://news.sina.com.cn/guide/">微博导航</a></td>        
    <td width="447" align="right">Copyright: 2011-2015<a href="http://corp.sina.com.cn/chn/copyright.html"> 微博系统 版权所有</a></td>
  </tr>
  <tr>
    <td align="left">客服电话：400 123 12345（按当地市话标准收费）</td>
    <td align="right">语言：
      <select name="select" id="select">
        <option>中文(简体)</option>
        <option>中文(繁体)</option>
    </select></td>
  </tr>        
</table>
<!--footer结束-->
<%if(request.getParameter("msg")!=null){
    int res=Integer.parseInt(request.getParameter("msg"));
      if(res==1){
      out.print("<script>alert('收藏成功！');</script>");
     }else{
      out.print("<script>alert('收藏失败！');</script>");
     }
    }
     %>  
</body>
</html>
</html>