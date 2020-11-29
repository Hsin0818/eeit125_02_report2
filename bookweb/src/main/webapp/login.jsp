<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- link rel="stylesheet" href="login.css"> -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<style>
@import url(https://fonts.googleapis.com/earlyaccess/cwtexyen.css);
body{
    font-family: "cwTeXYen", sans-serif;
    font-weight: 800;
    line-height: 2;
    font-size: 18px;
}
fieldset {
    border-radius: 25px;
    padding: 20px;
    margin: auto;
    background-color: beige;
    width: 400px
}
legend {
    text-align: center;
    font-size: 30px;
}
p {
	margin-top: 5px;
	font-size: 10px
}

.div1 {
	text-align: center;
}

.a10 button{
	margin: auto;
	margin-top: 20px;
	font-size: large;
	background-color: rgb(252, 210, 155);
	border-radius: 10px;
	margin-bottom: 10px;
	width: 115px;
}

span {
	font-size: 50px;
}
</style>
</head>
<body>
	<!-- 標題及工作列 -->
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
    </div>
    <!-- 標題及工作列 -->
	<form action="./Login" method="post">
		<fieldset>
			<legend>會員登入</legend>
			<div class="a2 div1">
				<label>帳號:</label> <input type="text" name="account" id="account"
					 size="12" onblur="">
			</div>
			<div class="a3 div1">
				<label>密碼:</label> <input type="password" name="pwd" id="pwd"
					 size="12" onblur="">
			</div>
			<div class="a10 div1">
				<button style="text-decoration: none" name="submit">登入</button>
			</div>
			<div class = "div1">
				<a href="password.html">忘記密碼?</a> <a href="account.html">忘記帳號?</a>
			</div>
			<hr>
			<div class="a10 div1">
				<a href="registe.jsp" style="text-decoration: none">新帳號註冊</a>
			</div>
		</fieldset>
	</form>
</body>
</html>