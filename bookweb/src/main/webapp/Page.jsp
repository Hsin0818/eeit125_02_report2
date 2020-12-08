
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*,model.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
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
<form action="searchBook" method="post">
    <div class="container">
        <header class="blog-header py-3">
          <div class="row flex-nowrap justify-content-between align-items-center">
            
            <div class="col-4 text-center">
              <a class="blog-header-logo text-dark" href="#">書適圈</a>
            </div>
            <div class="col-4 d-flex justify-content-end align-items-center">
              <a class="btn btn-sm btn-outline-secondary" href="#">登入</a>
            </div>
          </div>
        </header>
      
        <div class="nav-scroller py-1 mb-2">
          <nav class="nav d-flex justify-content-between">
            <a class="nav-link dropdown-toggle text-muted" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                圖書漂流瓶
              </a>
              <div class="dropdown-menu text-muted" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item text-muted" href="#">Action</a>
                <a class="dropdown-item text-muted" href="#">Another action</a>
                <a class="dropdown-item text-muted" href="#">Something else here</a>
              </div>
            <a class="p-2 text-muted" href="#">二手書交易系統</a>
            <a class="p-2 text-muted" href="#">共讀趣／閱讀沙龍</a>
            <a class="p-2 text-muted" href="#">討論區</a>
            <a class="nav-link dropdown-toggle text-muted" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                閱讀履歷
              </a>
              <div class="dropdown-menu text-muted" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item text-muted" href="#">Action</a>
                <a class="dropdown-item text-muted" href="#">Another action</a>
                <a class="dropdown-item text-muted" href="#">Something else here</a>
              </div>
          </nav>
        </div>

                <!-- 以上是導覽列，以下是主要內容 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% 
	BookBean bookData = (BookBean)request.getAttribute("result");
	//request.setAttribute("bookData", bookData);
%>

                <br>
                <hr>
                <br>
		<div class="collect">
		<a class="btn btn-outline-dark" href="Search.jsp" role="button">搜尋首頁</a><br><br>
		<button type="submit" name="list" class="btn btn-outline-dark" value="5">收藏清單</button>
		<!-- value=會員ID -->
		</div>

               <div class="row">
                    <div class="col-sm-5">

                        <p class="s-corner">
                        <img class="mainpic" alt="" src="<%=bookData.getBk_Pic() %>" height="390">
                        </p>
                        <div class="detail">
                            <h6>詳細資訊：</h6>
                            <p>　　ISBN：<%=bookData.getBk_ISBN()%><br>　　頁數：<%=bookData.getBk_Page()%><br></p>
          
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
                            <h5>作者：<%=bookData.getBk_Author() %></h5>
                            <h5>出版社：<%=bookData.getBk_Publish() %></h5>
                            <h5>出版日期：<%=bookData.getBk_Date() %></h5>
                            <br>
                            <figure>
                                <h5>內容簡介：</h5>
                               <%=bookData.getBk_Content() %>
                            </figure>

                            <div class="collect">
                                <img alt="點選收藏" src="Img/heartred.png" id="heart" width="25px">
                                <button type="submit" name="pagecollect" class="btn btn-outline-danger btn-sm" value="<%=bookData.getBk_ID() %>">收藏本書</button>
								<button type="submit" name="update" class="btn btn-outline-info btn-sm" value="<%=bookData.getBk_ID() %>">修改書訊</button>
								
                            </div>
                            

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
                        

                    </div>
                  </div>
		
</div>
</form>

</body>
</html>