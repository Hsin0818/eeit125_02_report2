<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>書適圈</title>
</head>
<body>
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

		<br>
		<hr>
		<br>
		<form action="./SearchServlet" method="post">
			<h3>輸入關鍵字：</h3>
			<div class="form-inline">
				<input class="form-control mr-sm-2" name="name" value=""
					type="search" placeholder="Search" aria-label="Search">

				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">查詢</button>
			</div>

			<br>
			<hr>

		</form>



		<br>
		<h3>選擇書籍類別：</h3>
		<br>

		<div class="row">

			<div class="col-sm-4">
				<div class="btn-group-toggle" data-toggle="buttons">
				<button type="button" class="btn btn-primary btn-lg">文學創作</button>
				<br>
				<br>
				<p class="btn btn-outline-primary">
					<input type="checkbox" name="c" value="" /> 詩
				</p>
				<p class="btn btn-outline-primary">
					<input type="checkbox" name="c" value="" /> 散文
				</p>
				<p class="btn btn-outline-primary">
					<input type="checkbox" name="c" value="" /> 戀愛/言情 小說
				</p>
				<p class="btn btn-outline-primary">
					<input type="checkbox" name="c" value="" /> 武俠/歷史 小說
				</p>
				<p class="btn btn-outline-primary">
					<input type="checkbox" name="c" value="" /> 推理/驚悚 小說
				</p>
				<p class="btn btn-outline-primary">
					<input type="checkbox" name="c" value="" /> 科幻/奇幻 小說
				</p>
				<p class="btn btn-outline-primary">
					<input type="checkbox" name="c" value="" /> 溫馨/療癒 小說
				</p>
				<p class="btn btn-outline-primary">
					<input type="checkbox" name="c" value="" /> 翻譯文學
				</p>
				</div>
				<hr>



				<div class="btn-group-toggle" data-toggle="buttons">
					<label class="btn btn-warning active btn-lg"> <input
						type="checkbox" checked> 人文社會
					</label> <br>
					<br>
					<p class="btn btn-outline-warning">
						<input type="checkbox" name="b" value="" /> 政治/軍事
					</p>
					<p class="btn btn-outline-warning">
						<input type="checkbox" name="b" value="" /> 歷史/地理
					</p>
					<p class="btn btn-outline-warning">
						<input type="checkbox" name="b" value="" /> 宗教/哲學
					</p>
					<p class="btn btn-outline-warning">
						<input type="checkbox" name="b" value="" /> 法律/心理
					</p>
					<p class="btn btn-outline-warning">
						<input type="checkbox" name="b" value="" /> 社會/文化
					</p>
					<p class="btn btn-outline-warning">
						<input type="checkbox" name="b" value="" /> 兩性/家庭
					</p>
					<p class="btn btn-outline-warning">
						<input type="checkbox" name="b" value="" /> 報導/傳播
					</p>
					<p class="btn btn-outline-warning">
						<input type="checkbox" name="b" value="" /> 國際趨勢
					</p>

				</div>

			</div>








			<div class="col-sm-4">
				<div class="btn-group-toggle" data-toggle="buttons">
				<button type="button" class="btn btn-danger btn-lg">圖文漫畫</button>
				<br>
				<br>
				<p class="btn btn-outline-danger">
					<input type="checkbox" name="b" value="" /> 插畫集
				</p>
				<p class="btn btn-outline-danger">
					<input type="checkbox" name="b" value="" /> 各式圖鑑
				</p>
				<p class="btn btn-outline-danger">
					<input type="checkbox" name="b" value="" /> 戀愛/言情 漫畫
				</p>
				<p class="btn btn-outline-danger">
					<input type="checkbox" name="b" value="" /> 科幻/奇幻 漫畫
				</p>
				<p class="btn btn-outline-danger">
					<input type="checkbox" name="b" value="" /> 戰鬥/冒險 漫畫
				</p>
				<p class="btn btn-outline-danger">
					<input type="checkbox" name="b" value="" /> 推理/驚悚 漫畫
				</p>
				<p class="btn btn-outline-danger">
					<input type="checkbox" name="b" value="" /> 運動/競技 漫畫
				</p>
				</div>
			</div>

			<div class="col-sm-4">

				<div class="btn-group-toggle" data-toggle="buttons">
					<label class="btn btn-secondary active btn-lg"> <input
						type="checkbox" checked> 商業理財
					</label> <br>
					<br>
					<p class="btn btn-outline-secondary">
						<input type="checkbox" name="b" value="" /> 創業
					</p>
					<p class="btn btn-outline-secondary">
						<input type="checkbox" name="b" value="" /> 會計
					</p>
					<p class="btn btn-outline-secondary">
						<input type="checkbox" name="b" value="" /> 經濟學
					</p>
					<p class="btn btn-outline-secondary">
						<input type="checkbox" name="b" value="" /> 管理學
					</p>
					<p class="btn btn-outline-secondary">
						<input type="checkbox" name="b" value="" /> 財務金融
					</p>
					<p class="btn btn-outline-secondary">
						<input type="checkbox" name="b" value="" /> 投資理財
					</p>
					<p class="btn btn-outline-secondary">
						<input type="checkbox" name="b" value="" /> 企業經營
					</p>
					<p class="btn btn-outline-secondary">
						<input type="checkbox" name="b" value="" /> 市場行銷
					</p>
					<p class="btn btn-outline-secondary">
						<input type="checkbox" name="b" value="" /> 人力資源
					</p>

				</div>


			</div>

		</div>




	</div>


	<script type="text/javascript">
		function check_all(obj, cName) {
			var checkboxs = document.getElementsByName(cName);
			for (var i = 0; i < checkboxs.length; i++) {
				checkboxs[i].checked = obj.checked;
			}
		}
	</script>


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


</body>
</html>