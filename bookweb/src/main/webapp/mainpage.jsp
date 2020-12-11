<!-- sql建立table指令 
-- Drop table
-- DROP TABLE Booktest.dbo.NOVEL_ARTICLE GO

CREATE TABLE Booktest.dbo.NOVEL_ARTICLE (
	ID int IDENTITY(1,1) NOT NULL,
	Title nvarchar(20) COLLATE Chinese_Taiwan_Stroke_CS_AS NOT NULL,
	Content nvarchar(100) COLLATE Chinese_Taiwan_Stroke_CS_AS NOT NULL
) GO
) -->

<!-- 主畫面 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	<meta charset="UTF-8">
	<title>main page</title>

	<style type="text/css">
		.div1{
			text-align:center; 
			margin-top:20px;
		}
		button{
		font-size:20px;
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
				<form action=".\ActHomepage.jsp">
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
	<div class="div1" >
	<button onclick="javascript:location.href='insertpage.jsp'">新增貼文</button> 
	<button onclick="javascript:location.href='searchpage.jsp'">查詢貼文</button>
	</div>

</body>
</html>