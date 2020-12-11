<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="java.util.List"%>
<%@ page import="model.BookBean"%>
<sql:setDataSource var="db" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"  
     url="jdbc:sqlserver://eeit125g2.ddns.net:1433;DatabaseName=BookDB"  
     user="book"  password="qaq"/>  
<sql:query
	sql="select b.BKS_ID as bkid, a.bk_Name as bkname, a.bk_Author as bkwriter, a.bk_Publish as bkpublish, b.BS_price as bkprice, b.BS_Num as bknum from book a, BOOK_STORE b where a.bk_ID = b.BK_ID"
	dataSource="${db}" var="rs" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<header class="blog-header py-3">
			<div
				class="row flex-nowrap justify-content-between align-items-center">

				<div class="col-4 text-center">
					<a class="blog-header-logo text-dark" href="#">圖書資訊網</a>
				</div>
				<div class="col-4 d-flex justify-content-end align-items-center">
					<a class="btn btn-sm btn-outline-secondary" href="#">登入</a>
				</div>
			</div>
		</header>

		<div class="nav-scroller py-1 mb-2">
			<nav class="nav d-flex justify-content-between">
				<a class="nav-link dropdown-toggle text-muted" href="#"
					id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> 圖書漂流瓶 </a>
				<div class="dropdown-menu text-muted"
					aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item text-muted" href="#">Action</a> <a
						class="dropdown-item text-muted" href="#">Another action</a> <a
						class="dropdown-item text-muted" href="#">Something else here</a>
				</div>
				<a class="p-2 text-muted" href="qaq.html">二手書交易系統</a> <a
					class="p-2 text-muted" href="#">共讀趣／閱讀沙龍</a> <a
					class="p-2 text-muted" href="#">討論區</a> <a
					class="nav-link dropdown-toggle text-muted" href="#"
					id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> 閱讀履歷 </a>
				<div class="dropdown-menu text-muted"
					aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item text-muted" href="#">Action</a> <a
						class="dropdown-item text-muted" href="#">Another action</a> <a
						class="dropdown-item text-muted" href="#">Something else here</a>
				</div>
			</nav>
		</div>
		<!--  -->
		<form action="./BookServlet1" method="post">
			<div>
				<input class="search-bar" type="text" name="searchbk" id="search"
					placeholder="輸入名稱">
				<button class="search-btn">搜尋</button>

			</div>
		</form>

		<%
			if (request.getParameter("searchbk") != null) {
		%>
		<p>
			<%!List<BookBean> list;%>
			<%!BookBean data;%>
			<%
				data = new BookBean();
			list = (List) request.getSession(true).getAttribute("qaqget");
			%>
		
		<form action="./BookServlet1" method="post">
			<%
				for (BookBean data : list) {
			%>
			<table border="2" width="50%">
				<tr>
					<th>編號</th>
					<th>書名</th>
					<th>作者</th>
					<th>出版社</th>
					<th>二手價</th>
					<th>數量</th>
					<th>&nbsp;</th>
				</tr>
				<tr>
					<td><%=data.getBk_ID()%></td>
					<td><%=data.getBk_Name()%></td>
					<td><%=data.getBk_Author()%></td>
					<td><%=data.getBk_Publish()%></td>
					<td><INPUT TYPE="TEXT" NAME="<%=data.getBk_ID()%>price"></td>
					<td><INPUT TYPE="TEXT" NAME="<%=data.getBk_ID()%>qty"></td>
					<td><button type="submit" value=<%=data.getBk_ID()%>
							name="setbk">刊登</button></td>
				</tr>
			</table>
			<%
				}
			%>
		</form>
		<%
			}
		%>
		<!--  -->

		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
			integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
			integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
			crossorigin="anonymous"></script>
	</div>
	<!--  -->

</body>
</html>