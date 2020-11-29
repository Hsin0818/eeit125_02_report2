<%@page import="book.bean.*"%>
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
<jsp:useBean id="b" class="book.bean.BookBean"></jsp:useBean>  

<title>書適圈</title>
    <link rel="stylesheet" href="bottle.css">
    <link rel="stylesheet" href="book_message2.css">

    <style>

.check{
    margin: auto;
    text-align: center;
}
    </style>
</head>
<body>
<form action="./SearchServlet" method="post">
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
	BookBean bookData = (BookBean)request.getAttribute("page2");
	//request.setAttribute("bookData", bookData);
%>



                <br>
                <hr>
                <br>

               <div class="row">
                    <div class="col-sm-1">
                    </div>
                    
                    
                    <div class="col-sm-11">

                        <div class="back">
                            <h2 class="title">更新書目資訊：</h2>
                            <hr><br>
                            <input type="hidden" name="id" value="<%=bookData.getBK_ID() %>">
                            <span>書名：</sapn><input type="text" name="bookname" value="<%=bookData.getBK_Name() %>"><br>
                            <br><span>作者：</sapn><input type="text" name="bookwriter" value="<%=bookData.getBK_Writer() %>"><br>
                            <br><span>出版社：</sapn><input type="text" name="bookpublish" value="<%=bookData.getBK_Publish() %>"><br>
                            <br><span>出版日期：</sapn><input type="text" name="booktime" value="<%=bookData.getBK_Time() %>"><br>
                            <br>
                            <figure>
                                <span>內容簡介：</span>
                                <div class="context">
                                
                                <textarea cols="100" rows="8" name="bookcontent">
								<%=bookData.getBK_Content() %>
								</textarea>
								</div>
                            </figure>

                            

                    </div>
                  </div>
			<div class="check">
			
			<button type="submit" name="confirm" class="btn btn-outline-danger btn-sm" value="">確認修改</button>
			
			</div>
		
</div>
</form>

</body>
</html>