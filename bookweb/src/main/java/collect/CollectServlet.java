package collect;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
//import java.io.PrintWriter;
//import java.io.IOException;
import book.bean.*;
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
@WebServlet("/CollectServlet")
public class CollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		if (request.getParameter("bk_id") != null) {
//			o.print("2");
			gotoCol(request, response);
		}
//	   else if (request.getParameter("confirm")!=null)
//	     
	}
	

	public void gotoCol(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		PrintWriter o = response.getWriter();
		System.out.println(1);
		try {
			
			int BK_ID = Integer.valueOf(request.getParameter("bk_id"));

			ctxt = new InitialContext();
			ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
			conn = ds.getConnection();			
	        Statement stmt = conn.createStatement();
	        
	        String sqlString = "INSERT INTO BOOK_COLLECT(BK_ID,MB_ID,BC_Time,BC_Tag) " +
	                "VALUES(" + BK_ID + "," +4+","+ "default" +"," + "null"+ ")";
	        System.out.println(sqlString);
	        ResultSet rs = stmt.executeQuery(sqlString);
//				
//			List<BookBean> dept = bookDAO.searchBook(name);
//
//			for(BookBean finalres : dept) {
//				o.print(finalres.getBK_ID() +finalres.getBK_Name());
//			}
//			String nextPage = "/Result.jsp";
//		      ServletContext servletContext = getServletContext();
//		      RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(nextPage);
//		      requestDispatcher.forward(request, response);
//
//			

	  	  rs.close();
		  stmt.close();
		
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
