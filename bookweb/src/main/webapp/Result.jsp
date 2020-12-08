
<%@page import="model.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html;charset=UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">


<title>書適圈</title>
<link rel="stylesheet" href="bottle.css">
</head>
<body>
		<form action="./SearchServlet" method="post">

<jsp:useBean id="searchlist" class="model.BookBean" />
	<div class="container">
		<header class="blog-header py-3">
			<div class="row flex-nowrap justify-content-between align-items-center">
			  <div class="col-4 text-center">
				<a class="blog-header-logo text-dark" href="#">書適圈</a>
			  </div>
			  <div class="col-4 d-flex justify-content-end align-items-center">
				<form action=".\login.jsp">
				  <button type="submit" class="btn btn-sm btn-outline-secondary">登入</button>
				</form>
			  </div>
			</div>
			  </header>
			
			  <div class="nav-scroller py-1 mb-2">
				  <nav class="nav d-flex justify-content-between">
			  <!-- <a class="nav-link dropdown-toggle text-muted" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				圖書漂流瓶
			  </a>
					  <div class="dropdown-menu text-muted" aria-labelledby="navbarDropdownMenuLink">
						  <a class="dropdown-item text-muted" href="#">Action</a>
						  <a class="dropdown-item text-muted" href="#">Another action</a>
						  <a class="dropdown-item text-muted" href="#">Something else here</a>
					  </div>
					  <a class="p-2 text-muted" href="#">二手書交易系統</a>
					  <a class="p-2 text-muted" href="#">共讀趣／閱讀沙龍</a>
			  <a class="p-2 text-muted" href="#">討論區</a> -->
			  <form action=".\Search.jsp">
				<button type="submit"  class="btn btn-link text-muted">圖書漂流瓶</button>
			  </form>
			  <form action=".\qaqmid.jsp">
				<button type="submit"  class="btn btn-link text-muted">二手書交易系統</button>
			  </form>
			  <form action=".\index.jsp">
				<button type="submit"  class="btn btn-link text-muted">共讀趣／閱讀沙龍</button>
			  </form>
			  <form action=".\mainpage.jsp">
				<button type="submit"  class="btn btn-link text-muted">討論區</button>
			  </form>
			  <form action=".\BookReportServlet" method="post">
						<button type="submit"  class="btn btn-link text-muted">閱讀履歷</button>
			  </form>
					  <!-- <a class="nav-link dropdown-toggle text-muted" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						  閱讀履歷
					  </a>
					  <div class="dropdown-menu text-muted" aria-labelledby="navbarDropdownMenuLink">
						  <a class="dropdown-item text-muted" href="#">Action</a>
						  <a class="dropdown-item text-muted" href="#">Another action</a>
						  <a class="dropdown-item text-muted" href="#">Something else here</a>
					  </div> -->
				  </nav>
			  
		</div>

		<!-- 以上是導覽列，以下是主要內容 -->

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<%
	List<BookBean> user = (List<BookBean>) request.getAttribute("searchlist");
	request.setAttribute("list", user);
	%>

		<br>
		<hr>
		<br> <br>
		
		<div class="collect">
		<a class="btn btn-outline-dark" href="Search.jsp" role="button">搜尋首頁</a>
		<button type="submit" name="list" class="btn btn-outline-dark" value="5">收藏清單</button>
		<!-- value=會員ID -->
		</div>
		
		<h3>搜尋結果：</h3>
		
		
		<br> 

<c:forEach items="${list}" var="row">  

          <div class="book">
              <img class="itemcov" alt="" src="${row.getBK_Pic()}" height="190">
          
       <h3>
                   
<button type="submit" name="page" class="btn btn-link btn-lg" value="${row.getBK_ID()}">${row.getBK_Name()}</button>
       </h3>

		作者：${row.getBK_Writer()}<br>
		出版社：${row.getBK_Publish()}
		${row.getBK_ID()}
		
		<br>
		出版日期：${row.getBK_Time()}
		<br>
		
		<p>${row.getBK_Content()}</p>


				<div class="collect">				
					<img alt="點選收藏"
						src="Img/heartred.png" id="Img/heart" width="25px">
					<button type="submit" name="collect" class="btn btn-outline-danger btn-sm" value="${row.getBK_ID()}">收藏本書</button>
				</div>
			</div>
			
</c:forEach>  		
			
	</div>
</form>

</body>
</html>