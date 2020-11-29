<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%
response.setContentType("text/html;charset=UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@page import="collect.*"%>
<jsp:useBean id="u" class="book.bean.CollectBean"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  

<title>刪除頁面</title>
</head>
<body>

<%
String bk_id=request.getParameter("bk_id");
String mb_id=request.getParameter("mb_id");
int newone=BookDAO.delete(Integer.parseInt(bk_id), Integer.parseInt(mb_id));
response.sendRedirect("Collect.jsp");  
%>



</body>
</html>