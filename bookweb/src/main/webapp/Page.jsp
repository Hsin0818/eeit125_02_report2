<%@page import="DAO.*"%>
<%@page import="model.*"%>
<%@page import="collect.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<jsp:useBean id="b" class="model.BookBean"></jsp:useBean>  

<title>書適圈</title>
    <link rel="stylesheet" href="bottle.css">
    <link rel="stylesheet" href="book_message2.css">
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
    </div>
      <!-- 標題及工作列 -->
    <div class="container">
      
                <!-- 以上是導覽列，以下是主要內容 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% 
	BookBean bookData = (BookBean)request.getAttribute("page1");
	request.getSession(true).setAttribute("bkName", bookData.getBk_Name());
	request.getSession(true).setAttribute("bkPic", bookData.getBk_Pic());
	request.getSession(true).setAttribute("bk_ID", bookData.getBk_ID());
	request.getSession(true).setAttribute("bkWriter", bookData.getBk_Writer());
	request.getSession(true).setAttribute("bk_Publish", bookData.getBk_Publish());
	//request.setAttribute("bookData", bookData);
%>

                <br>
                <hr>
                <br>
		<div class="collect">
		
      	<form action="./SearchServlet" method="post">
      		<a class="btn btn-outline-dark" href="Search.jsp" role="button">搜尋首頁</a>
      		<button type="submit" name="list" class="btn btn-outline-dark" value="5">收藏清單</button>
      	</form>
		<!-- value=會員ID -->
		</div>

               <div class="row">
                    <div class="col-sm-5">

                        <p class="s-corner">
                        <img class="mainpic" alt="" src="<%=bookData.getBk_Pic() %>" height="390">
                        </p>
                        <div class="detail">
                            <h6>詳細資訊：</h6>
                            <p>　　ISBN：<br>　　頁數：<br></p>
          
                        </div>

                        <div class="detail">
                            <h6>相關書評連結：</h6>
                            <ul>
                                <li>連結1</li>
                                <li>連結2</li>
                                <li>連結3</li>

                            </ul>
                        </div>



                    </div>
                    <div class="col-sm-7">

                        <div class="back">
                            <h2 class="title"><%=bookData.getBk_Name() %></h2>
                            <hr><br>
                            <h5>作者：<%=bookData.getBk_Writer() %></h5>
                            <h5>出版社：<%=bookData.getBk_Publish() %></h5>
                            <h5>出版日期：<%=bookData.getBk_Time() %></h5>
                            <br>
                            <figure>
                                <h5>內容簡介：</h5>
                               <%=bookData.getBk_Content() %>
                            </figure>
                          <form action="./SearchServlet" method="post">
                            <div class="collect">
                                <img alt="點選收藏" src="Img/heartred.png" id="heart" width="25px">
                                <button type="submit" name="pagecollect" class="btn btn-outline-danger btn-sm" value="<%=bookData.getBk_ID() %>">收藏本書</button>
                                <button type="submit" name="update" class="btn btn-outline-info btn-sm" value="<%=bookData.getBk_ID() %>">修改書訊</button>
                              </div>
                          </form>

                        </div>




                        <div class="detail">
                            <h6>二手拍賣連結：</h6>
                            <ul>
                                <li>連結1</li>
                                <li>連結2</li>
                                <li>連結3</li>
                            </ul>
                            <div class="follow">
                                ＊有二手書時通知我  <img alt="加入追蹤" src="Img/heartwhite.png" id="heart" width="25px">
                            </div>
                        </div>

                        <form action=".\BookReportServlet">
                          <button type="submit" name="bookreportBK_ID" style="margin-left: 100px; margin-top: 100px;" class="btn btn-lg btn-primary" value="<%=bookData.getBk_ID() %>">心得清單</button>
                        </form>

                    </div>
                  </div>

		
		<!-- 
		<div class="collect">
				
					<button type="submit" name="collect" value="${row.getBK_ID()}"> <img alt="點選收藏"
						src="Img/heartred.png" id="Img/heart" width="25px"> 收藏本書
					</button>
				</div>
		
		
		</div> -->
		
</div>


</body>
</html>