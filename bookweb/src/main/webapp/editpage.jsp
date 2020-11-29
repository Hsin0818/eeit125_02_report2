<!-- 修改頁面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>   
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>edit page</title>
	<style type="text/css">
		*{
		font-size:20px;
		}
		div{
		text-align:center; 
		margin-top:20px;
		}
	</style>
</head>

<body>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
%>

	<div>
		<button onclick="javascript:location.href='insertpage.jsp'">新增貼文</button> 
		<button onclick="javascript:location.href='searchpage.jsp'">查詢貼文</button>
	</div>
	<br>
	
	<!-- 根據使用者選取的ID取值 -->
	<sql:query var="result" scope="request" dataSource="jdbc/BookDB">                
                SELECT * FROM NOVEL_ARTICLE WHERE ID=${param.sendID};
    </sql:query>	
    
	<div>
		<!-- 用迴圈列出值 -->
		<c:forEach var="row" items="${result.rows}">
		<c:url value="Controller" var="go_editServlet">
		<c:param name="ID" value="${row.ID}"/>
		</c:url>
		<form action="${go_editServlet}" method="post">				
			<label style="vertical-align:top;">貼文標題：</label>
			<!-- 以article_title作為Servlet裡參數名稱 -->
			<input name="article_title" type="text" style="width:8cm; height:20px;" value="${row.Title}">
			<br>
			<label style="vertical-align:top;">貼文內容：</label>
			<!-- 以article_content作為Servlet裡參數名稱 -->
			<textarea name="article_content" style="margin-top:5px; width:8cm; height:5cm;">${row.Content}</textarea>
			<br>		
			<button type="submit" name="editarticle">送出修改內容</button>
		</form>
		</c:forEach>
	</div>
</body>
</html>