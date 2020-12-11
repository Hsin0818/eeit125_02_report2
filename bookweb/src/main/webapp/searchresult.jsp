<!-- 查詢結果＆修改、刪除按鈕 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search result</title>
<style type="text/css">
*{
font-size:20px;
}
div{
text-align:center; 
margin-top:20px;
}
td{
width:200px;
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
	<div>
		<h1>查詢 ${param.keyword} 的結果為</h1>
	</div>	
	
	<sql:setDataSource var="db" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"  
     url="jdbc:sqlserver://eeit125g2.ddns.net:1433;DatabaseName=BookDB"  
     user="book"  password="qaq"/>  
	
	<sql:query var="result" scope="request" dataSource="${db}">                
                SELECT * FROM NOVEL_ARTICLE WHERE Title like N'%${param.keyword}%' or Content like N'%${param.keyword}%'
    </sql:query>
   
<table align="center">
<thead>
     	<tr align="center">
     		<td style="display:none">id</td>
     		<td>貼文標題</td>
     		<td>貼文內容</td>
     		<td>修改</td>
     		<td>刪除</td>
     	</tr>
</thead>
<tbody>
	<!-- 迴圈列出查詢結果 -->
	<c:forEach var="row" items="${result.rows}">
     	<tr align="center">
     		<td> <c:out value="${row.Title}"/> </td>
     		<td> <c:out value="${row.Content}"/> </td>
     		<td>
     			<!-- 傳送使用者選取貼文的ID至editpage.jsp --> 
     			<c:url value="editpage.jsp" var="go_editpage">
     			<c:param name="sendID" value="${row.ID}"/>
     			</c:url>
     			<form action="${go_editpage}" method="post">
					<button type="submit">修改貼文</button>
				</form>
			</td>
     		<td>
     			<!-- 傳送使用者許取貼文的ID至Servlet -->
     			<c:url value="./Controller" var="go_delete">
     			<c:param name="sendID" value="${row.ID}"/>
     			</c:url>
     			<form action="${go_delete}" method="post">
     				<button type="submit" name="deletearticle">刪除貼文</button> 
     			</form>
     		</td>
     	</tr>
     </c:forEach>
</tbody>
</table> 

</body>
</html>