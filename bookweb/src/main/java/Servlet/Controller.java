package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DAO.ArticleDAO;
import DAO.ArticleDAOInterface;
import Service.ArticleService;
import Service.ArticleServiceInterface;
import model.ArticleBean;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

//	DataSource ds = null;
//	InitialContext ctxt = null;
//	Connection conn = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);

		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", -1); // Prevents caching at the proxy server

		try {
//			ctxt = new InitialContext();
//			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/BookDB");
//			conn = ds.getConnection();

			//根據前端button submit的參數，分配處理的程式
			if (request.getParameter("insertarticle") != null) {
				insertarticleprocess(request, response);}
			if (request.getParameter("editarticle") != null) {
				editarticleprocess(request, response);}
			if (request.getParameter("deletearticle") != null) {
				deletearticleprocess(request, response);}

		} catch (Exception e) {
			e.printStackTrace();
//		} finally {
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}

	}

	//承接insertpage.jpg的參數
	public void insertarticleprocess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String article_title = (String) request.getParameter("article_title");
		String article_content = (String) request.getParameter("article_content");
		ArticleServiceInterface service = new ArticleService();
		service.insertArticle(new ArticleBean(article_title, article_content));
		response.sendRedirect("insertsuccess.jsp");
	}

	//承接editpage.jpg的參數
	public void editarticleprocess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("ID"));
		String article_title = (String) request.getParameter("article_title");
		String article_content = (String) request.getParameter("article_content");
		ArticleServiceInterface service = new ArticleService();
		service.editArticle(new ArticleBean(article_title, article_content), id);
		response.sendRedirect("editsuccess.jsp");
	}

	//承接searchresult.jsp的delete button
	public void deletearticleprocess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("sendID"));
		ArticleServiceInterface service = new ArticleService();
		service.deleteArticle(id);
		response.sendRedirect("deletesuccess.jsp");
	}

}
