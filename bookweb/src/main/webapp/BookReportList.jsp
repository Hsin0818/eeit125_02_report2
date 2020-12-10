
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="BookReport.*" import="java.util.List" import="model.*"%>
<%
	request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
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
<style>
.bd-placeholder-img {
	font-size: 1. 125rem;
	text-anchor: middle;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<title>閱讀履歷</title>
</head>
<body>

	<!-- 標題及工作列 -->
	<div class="container">
		<header class="blog-header py-3">
			<div
				class="row flex-nowrap justify-content-between align-items-center">
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
					<button type="submit" class="btn btn-link text-muted">圖書漂流瓶</button>
				</form>
				<form action=".\qaqmid.jsp">
					<button type="submit" class="btn btn-link text-muted">二手書交易系統</button>
				</form>
				<form action=".\index.jsp">
					<button type="submit" class="btn btn-link text-muted">共讀趣／閱讀沙龍</button>
				</form>
				<form action=".\mainpage.jsp">
					<button type="submit" class="btn btn-link text-muted">討論區</button>
				</form>
				<form action=".\BookReportServlet" method="post">
					<button type="submit" class="btn btn-link text-muted">閱讀履歷</button>
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

	<form action=".\BookReportServlet" method="post" id="form1">
		<%
			List<model.BookReportBean> bookReportTable = (List<model.BookReportBean>) request.getAttribute("bookReportTable");
				if (bookReportTable.size() == 0) {
			bookReportTable.add(null);
				}
		%>
		<!--功能列畫面-->
		<div class="container tab-content" id="nav-tabContent">
			<button id="insertButton" type="button"
				class="btn btn-lg btn-primary" data-toggle="modal"
				data-target="#editModal" name="insertButton"
				value="<%=request.getParameter("bookreportBK_ID")%>>">＋新增讀書</button>
			<br> <br>
			<!-- 閱讀心得 -->
			<div class="tab-pane fade show active" id="nav-read" role="tabpanel"
				aria-labelledby="nav-read-tab">
				<div class="row">
					<%
						for (model.BookReportBean reportData : bookReportTable) {
									if (reportData == null) {
										break;
									}
					%>
					<div class="col-md-4">
						<div class="card mb-4 shadow-sm ">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="250" xmlns="http://www.w3.org/2000/svg"
								preserveAspectRatio="xMidYMid slice" focusable="false"
								role="img" aria-label="Placeholder: Thumbnail">
						<image xlink:href="<%=reportData.getBook().getBk_Pic()%>"
									width="100%" height="100%" />
					</svg>
							<div class="card-body">
								<p><%=reportData.getBook().getBk_Name()%>
								<p>
								<p class="card-text">
									評分：<%=reportData.getBr_Score()%></p>
								<input type="hidden" id="edit_pic"
									name="<%=reportData.getBr_ID()%>BkPic"
									value="<%=reportData.getBook().getBk_Pic()%>"> <input
									type="hidden" id="edit_BkName"
									name="<%=reportData.getBr_ID()%>BkName"
									value="<%=reportData.getBook().getBk_Name()%>"> <input
									type="hidden" id="edit_MbID"
									name="<%=reportData.getBr_ID()%>MbID"
									value="<%=reportData.getMember().getmB_ID()%>"> <input
									type="hidden" id="edit_BkID" name="BkID"
									value="<%=reportData.getBook().getBk_ID()%>"> <input
									type="hidden" id="<%=reportData.getBr_ID()%>edit_BrContent"
									name="<%=reportData.getBr_ID()%>BrContent"
									value="<%=reportData.getBr_Content()%>"> <input
									type="hidden" id="edit_BkWriter"
									name="<%=reportData.getBr_ID()%>BkWriter"
									value="<%=reportData.getBook().getBk_Author()%>"> <input
									type="hidden" id="edit_BkPublish"
									name="<%=reportData.getBr_ID()%>BkPublish"
									value="<%=reportData.getBook().getBk_Publish()%>"> <input
									type="hidden" id="<%=reportData.getBr_ID()%>edit_BrScore"
									name="<%=reportData.getBr_ID()%>BrScore"
									value="<%=reportData.getBr_Score()%>">
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="submit" class="btn btn-sm btn-outline-link"
											name="viewBookReport" value="<%=reportData.getBr_ID()%>">View</button>
									</div>
									<small class="text-muted">創建日期：<br><%=reportData.getBr_DateTime()%></small>
								</div>
							</div>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
			<!-- 閱讀心得 -->
		</div>
		<!--功能列畫面-->



		<!--編輯畫面-->
		<div class="modal" role="dialog" id="editModal" tabindex="-1">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">更改內容</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="media">
							<img id="BkPicE" src="" class="w-25 p-3" alt="...">
							<div class="media-body">
								<h5 class="mt-0" id="BkNameE">書名：</h5>
								<p class="mt-0" id="BkWriterE">作者：</p>
								<p class="mt-0" id="BkPublishE">出版社：</p>
								評分：<select name="BrScore1">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>分
							</div>
						</div>
						<label for="message-text" class="col-form-label">心得:</label>
						<textarea class="form-control" id="BrContentE"
							style="height: 350px;" name="BrContent1"></textarea>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary" id="insertButtons"
							name="insertButtons" value="insert1">Save changes</button>
					</div>
				</div>
			</div>
		</div>
		<!--編輯畫面-->
	</form>

	<script>
				
				$("#insertButton").click(function() {
					$("#BkPicE").attr("src","<%=request.getSession(true).getAttribute("bkPic")%>");
					$("#BkNameE").html( "書名："+"<%=request.getSession(true).getAttribute("bkName")%>");
					$("#BkWriterE").html("作者："+"<%=request.getSession(true).getAttribute("bkWriter")%>");
					$("#BkPublishE").html("出版社："+"<%=request.getSession(true).getAttribute("bk_Publish")%>");
					$("#MbId").val($("#edit_MbID").val());
					$("#insertButtons").val("<%=request.getSession(true).getAttribute("bk_ID")%>");
				});
	</script>



</body>
</html>