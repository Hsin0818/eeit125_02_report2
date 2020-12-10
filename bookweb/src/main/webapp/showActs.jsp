<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>活動資料</title>
</head>
<body>
	<p>&nbsp;</p>
	<hr>
	<div class='center'>
		<h1>活動資料</h1>
		<c:if test='${empty allActs}'>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		查無活動資料<br>
		</c:if>
		<c:if test='${not empty allActs}'>
			<%-- 			<c:if test ='${vs.first }'> --%>
			<%-- 				<c:out value="<table border='1'>" escapeXml='false'/> --%>
			<%-- 				<c:out value="<tr> --%>
			<table border='1'>
				<tr>
					<td>會員帳號</td>
					<td>活動編號</td>
					<td>活動圖片</td>
					<td>活動名稱</td>
					<td>活動主題</td>
					<td>活動日期</td>
					<td>活動簡介</td>
					<td>活動地點</td>
					<td>活動嘉賓</td>
					<td>活動人數</td>
					<td>活動規則</td>
					<td>活動標籤</td>
					<td>活動場所</td>
				</tr>
				<!-- 				</tr>" escapeXml='false'/> -->
				<%-- 			</c:if> --%>
				<c:forEach var='act' varStatus='vs' items='${allActs}'>
					<%-- 			${act.ACT_Image} --%>
					<tr>
						<%-- 				<td><a href='/FindActServlet?key=${act.ACT_Name}'></a></td> --%>
						<td>${act.MB_ID}</td>
						<td><a href='./FindActServlet?key=${act.ACT_ID}'>${act.ACT_ID}</a></td>
						<td>${act.ACT_Image}</td>
						<td>${act.ACT_Name}</td>
						<td>${act.ACT_Theme}</td>
						<td>${act.ACT_Date}</td>
						<td>${act.ACT_Loc}</td>
						<td>${act.ACT_Intro}</td>
						<td>${act.ACT_Guest}</td>
						<td>${act.ACT_Pax}</td>
						<td>${act.ACT_Rule}</td>
						<td>${act.ACT_Tag}</td>
						<td>${act.ACT_Place}</td>
					</tr>
				</c:forEach>
			</table>
			<%-- 			<c:if test ='${vs.last }'> --%>
			<%-- 				<c:out value="</table>" escapeXml='false'/> --%>
			<%-- 			</c:if> --%>
		</c:if>
		<p />
		<a href='${pageContext.request.contextPath}/ActHomepage.jsp'>回到活動管理</a>
	</div>
</body>
</html>