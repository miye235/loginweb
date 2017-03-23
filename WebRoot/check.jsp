<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<jsp:useBean id="user" class="com.mi.pojo.User" scope="session"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>验证用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <!--  设置user属性，判断是否合法
    合法跳转成功，否则跳转到登录页面 -->
    <jsp:setProperty property="*" name="user"/>
    <%
    	if(user.isValidate()) {
     %>
     <jsp:forward page="success.jsp"/>
     <%
     	} else {
      %>
      <jsp:forward page="index.jsp"/>
      <%} %>
  </body>
</html>
