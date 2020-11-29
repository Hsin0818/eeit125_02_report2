<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html;charset=UTF-8");
request.setCharacterEncoding("UTF-8");
%>
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
		<!-- -->
		<jsp:useBean id="mid" class="shopping.BookData" scope="session" />
		<form method="POST">
			<div>
				<label for="url"></label> <img alt="xx" width="200px" height="300px"
					src="<jsp:getProperty name="mid" property="url" />">
			</div>
			<div>
				<label for="bookname">書名</label>
				<jsp:getProperty name="mid" property="bookname" />
			</div>
			<div>
				<label for="bookauthor">作者</label>
				<jsp:getProperty name="mid" property="bookauthor" />
			</div>
			<div>
				<label for="bookpublish">出版社</label>
				<jsp:getProperty name="mid" property="bookpublish" />
			</div>
			<div>
				<label for="content">描述: </label>
				<jsp:getProperty name="mid" property="content" />
			</div>

			<div>
				<input type="submit" value="放入購物車" name="">
			</div>
		</form>
		<form action="qaqmid.jsp" method="post">
			<button type="submit" name="">返回</button>
			<br>
		</form>
		<!-- -->
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
	<!-- -->

</body>
</html>