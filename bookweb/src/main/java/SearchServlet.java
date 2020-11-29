
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
//import java.io.PrintWriter;
//import java.io.IOException;
import book.bean.*;
import collect.BookDAO;

import java.io.*;

import java.sql.*;
import java.util.List;

import javax.naming.*;
import javax.sql.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name = null;
	private int bk_id = 0;
	private int mb_id = 0;
	
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);
		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
		
		if (request.getParameter("name") != null) {
			gotoSearch(request, response);
		}else {
			request.getRequestDispatcher("/Search.jsp");
		}
		
		if (request.getParameter("collect") != null) {
			gotoCollect(request, response);
		}

		if (request.getParameter("list") != null) {
			gotoList(request, response);
		}
		
		if (request.getParameter("delete") != null) {
			gotoDelete(request, response);
		}
		
		if (request.getParameter("page") != null) {
			gotoPage(request, response);
		}
		
		if (request.getParameter("pagecollect") != null) {
			gotoPageCollect(request, response);
		}
		if (request.getParameter("check") != null) {
			gotoUpdate(request, response);
		}
		
		if (request.getParameter("confirm") != null) {
			gotoUpdateFin(request, response);
		}
		if (request.getParameter("update") != null) {
			gotoUpdate(request, response);
		}
		     
	}
	

	//查詢書籍
	public void gotoSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		PrintWriter o = response.getWriter();
		
		try {
			
			ctxt = new InitialContext();
			ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/BookDB");
			conn = ds.getConnection();
			BookDAO bookDAO = new BookDAO(conn);
		
			name = request.getParameter("name");
			List<BookBean> dept = bookDAO.searchBook(name);
			request.getSession(true).setAttribute("name",name);
			request.setAttribute("name",name);
			request.setAttribute("searchlist", dept);
			request.getRequestDispatcher("/Result.jsp").forward(request, response);
			
	    } catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	      try {
	        if (conn != null) conn.close();
	      } catch (Exception e) {
	        System.out.println("Connection Pool Error!");
	      }
	    }

	}

	
	
	
	
	//收藏書籍
	public void gotoCollect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		PrintWriter o = response.getWriter();

		try {
			
			ctxt = new InitialContext();
			ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/BookDB");
			conn = ds.getConnection();
			BookDAO bookDAO = new BookDAO(conn);
		
			int bk_id = Integer.valueOf(request.getParameter("collect"));
			int mb_id = 5;
			int dept = bookDAO.create(bk_id, mb_id);

			List<BookBean> a = bookDAO.searchBook(name) ;	
			request.setAttribute("searchlist", a);
			request.getRequestDispatcher("/Result.jsp").forward(request, response);
			
	    } catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	      try {
	        if (conn != null) conn.close();
	      } catch (Exception e) {
	        System.out.println("Connection Pool Error!");
	      }
	    }

	}

	
	
	
	
	//取得收藏清單
	public void gotoList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		PrintWriter o = response.getWriter();

		try {
			
			ctxt = new InitialContext();
			ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/BookDB");
			conn = ds.getConnection();
			BookDAO bookDAO = new BookDAO(conn);

			int mb_id = Integer.valueOf(request.getParameter("list"));
			List<BookBean> dept = bookDAO.getCollect(mb_id);

			request.setAttribute("list",dept);
			request.getRequestDispatcher("/Collect.jsp").forward(request, response);

	    } catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	      try {
	        if (conn != null) conn.close();
	      } catch (Exception e) {
	        System.out.println("Connection Pool Error!");
	      }
	    }

	}
	
	
	
	
	//刪除收藏
	public void gotoDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		PrintWriter o = response.getWriter();

		try {
			
			ctxt = new InitialContext();
			ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/BookDB");
			conn = ds.getConnection();
			BookDAO bookDAO = new BookDAO(conn);
		
			int bk_id = Integer.valueOf(request.getParameter("delete"));
			int mb_id = 5;
			int dept = bookDAO.delete(bk_id, mb_id);

			List<BookBean> dept2 = bookDAO.getCollect(mb_id);

			request.setAttribute("list",dept2);
			request.getRequestDispatcher("/Collect.jsp").forward(request, response);
			
			
	    } catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	      try {
	        if (conn != null) conn.close();
	      } catch (Exception e) {
	        System.out.println("Connection Pool Error!");
	      }
	    }

	}
	
	
	
	//前往單獨頁面
	public void gotoPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("00");
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		PrintWriter o = response.getWriter();
		System.out.println("1");
		try {
			
			ctxt = new InitialContext();
			
			ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/BookDB");
			System.out.println("2");
			conn = ds.getConnection();
			BookDAO bookDAO = new BookDAO(conn);

			int bk_id = Integer.valueOf(request.getParameter("page"));
			BookBean dept3 = bookDAO.getBook(bk_id);
			request.setAttribute("page1",dept3);
			request.getRequestDispatcher("/Page.jsp").forward(request, response);

	    } catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	      try {
	        if (conn != null) conn.close();
	      } catch (Exception e) {
	        System.out.println("Connection Pool Error!");
	      }
	    }

	}
	
	
	
	
	
	//單獨頁面加入收藏
	public void gotoPageCollect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		PrintWriter o = response.getWriter();

		try {
			
			ctxt = new InitialContext();
			ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/BookDB");
			conn = ds.getConnection();
			BookDAO bookDAO = new BookDAO(conn);
		
			int bk_id = Integer.valueOf(request.getParameter("pagecollect"));
			int mb_id = 2;
			int dept = bookDAO.create(bk_id, mb_id);

			BookBean dept3 = bookDAO.getBook(bk_id);
			request.setAttribute("page1",dept3);
			request.getRequestDispatcher("/Page.jsp").forward(request, response);
			
	    } catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	      try {
	        if (conn != null) conn.close();
	      } catch (Exception e) {
	        System.out.println("Connection Pool Error!");
	      }
	    }

	}
	
	//前往修改頁面
		public void gotoUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			DataSource ds = null;
			InitialContext ctxt = null;
			Connection conn = null;
			PrintWriter o = response.getWriter();
			System.out.println("goUp");
			try {
				
				ctxt = new InitialContext();		
				ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/BookDB");
				conn = ds.getConnection();
				BookDAO bookDAO = new BookDAO(conn);

				int bk_id = Integer.valueOf(request.getParameter("update"));
				BookBean dept3 = bookDAO.getBook(bk_id);
				request.setAttribute("page2",dept3);
				request.getRequestDispatcher("/Update.jsp").forward(request, response);

		    } catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
		      try {
		        if (conn != null) conn.close();
		      } catch (Exception e) {
		        System.out.println("Connection Pool Error!");
		      }
		    }
		}
		
		//最終更新頁面
		public void gotoUpdateFin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			DataSource ds = null;
			InitialContext ctxt = null;
			Connection conn = null;
			PrintWriter o = response.getWriter();

			try {
				
				ctxt = new InitialContext();		
				ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/BookDB");
				conn = ds.getConnection();
				BookDAO bookDAO = new BookDAO(conn);
				
				int id = Integer.valueOf(request.getParameter("id"));
				String name = request.getParameter("bookname");
				String writer = request.getParameter("bookwriter");
				String publish = request.getParameter("bookpublish");
				Date booktime = java.sql.Date.valueOf(request.getParameter("booktime"));
				String bookcontent = request.getParameter("bookcontent");
			
				boolean a = bookDAO.update(id, name, writer, publish, booktime, bookcontent);
				
				BookBean dept3 = bookDAO.getBook(id);
				request.setAttribute("page1",dept3);
				request.getRequestDispatcher("/Page.jsp").forward(request, response);

		    } catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
		      try {
		        if (conn != null) conn.close();
		      } catch (Exception e) {
		        System.out.println("Connection Pool Error!");
		      }
		    }
		}

	
	
}
