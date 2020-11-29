<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Fun Tribe</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Anton&family=Dancing+Script:wght@700&family=Great+Vibes&family=Lobster&family=Monoton&family=Poiret+One&display=swap');
        
        .fakeimg {
            height: 200px;
            background: #aaa;
        }

        .h {
            color: #156f99;
            text-align: center;
            font-family: 'Monoton', cursive;
            font-size: 100px;
            margin-top: 40px;
        }
        .hh{
            color: #156f99;
            text-align: center;
            font-family: 'Noto Serif TC', serif;
            font-weight: bolder;
            font-size: 30px;
            line-height: 50px;
            margin-bottom: 50px;
        }

        p {
            color: #293241;
            font-size: 25px;
            font-family: 'Noto Serif TC', serif;
        }

        .d1 {
            background-color: white;
            font-size: 100px;
            font-family: 'Noto Serif TC', serif;
        }

       

        .menu {
            margin-top: 10px;
            width: 250px;
            height: auto
        }
        .list{
            font-size: 20px;
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
    <div class="d1 container">
        <h1 class="h">Fun Tribe</h1>
        <div class="hh">共樂聚落</div>
    </div>
    
    
    <div class="container" style="margin-top:30px">
        <div class="row">
            <nav class="col-sm-6">
                <h1>發布活動</h1>
                <form action="CreateServlet" method="post">
                    <table>
                        <tr>
                            <td>會員帳號:</td>
                            <td><input type="text" name="MB_ID" /></td>
                        </tr>
                        <tr>
                            <td>活動名稱:</td>
                            <td><input type="text" name="ACT_Name" /></td>
                        </tr>
                        <tr>
                            <td>活動主題:</td>
                            <td><input type="text" name="ACT_Theme" /></td>
                        </tr>
                        <tr>
                            <td>活動日期:</td>
                            <td><input type="date" name="ACT_Date" /></td>
                        </tr>
                        <tr>
                            <td>活動地點:</td>
                            <td><input type="text" name="ACT_Loc" /></td>
                        </tr>
                        <tr>
                            <td>活動簡介:</td>
                            <td><input type="text" name="ACT_Intro" /></td>
                        </tr>
                        <tr>
                            <td>活動嘉賓:</td>
                            <td><input type="text" name="ACT_Guest" /></td>
                        </tr>
                        <tr>
                            <td>活動人數:</td>
                            <td><input type="text" name="ACT_Pax" /></td>
                        </tr>
                        <tr>
                            <td>活動辦法:</td>
                            <td><input type="text" name="ACT_Rule" /></td>
                        </tr>
                        <tr>
                            <td>活動標籤:</td>
                            <td><input type="text" name="ACT_Tag" /></td>
                        </tr>
                        <tr>
                            <td>活動場所:</td>
                            <td><input type="text" name="ACT_Place" /></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="新增活動" /></td>
                        </tr>
                    </table>
                </form>
        	</nav>
        </div>
        <br />
        <a href="ViewServlet">查看活動列表</a>
    </div>

    
</body>
</html>

