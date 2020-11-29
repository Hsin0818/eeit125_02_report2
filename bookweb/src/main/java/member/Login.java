package member;

import javax.servlet.*;
import java.io.*;

import java.sql.*;
import java.util.List;

//import javax.rmi.*;
import javax.naming.*;
import javax.sql.*;
import javax.websocket.Session;

import memberbean.LoginBean;
import memberbean.MemberBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

	public Login() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);

		// To prevent caching
		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		if (request.getParameter("submit") != null && account.equals("a123456") && pwd.equals("a123456")) {
			gotoAdminProcess(request, response);
		} else if (request.getParameter("submit") != null)
			gotoSubmitProcess(request, response);

		if (request.getParameter("mb_inf") != null)
			gotoMbselectProcess(request, response);

		if (request.getParameter("update") != null)
			gotoUpdate(request, response);

		if (request.getParameter("delete") != null)
			gotoDelete(request, response);

		if (request.getParameter("inf") != null)
			gotoSelectProcess(request, response);
	}

	// 會員登入
	public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account;
		String pwd;
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;

		try {
			// �إ�Context Object,�s��JNDI Server
			ctxt = new InitialContext();
			// �ϥ�JNDI API���DataSource
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/BookDB");
			// ds = ( DataSource ) ctxt.lookup("jdbc/OracleXE");
			// �VDataSource�nConnection
			conn = ds.getConnection();
			account = request.getParameter("account");
			pwd = request.getParameter("pwd");
			// �إ�Database Access Object,�t�dTable��Access
			MemberDAO MemberDAO = new MemberDAO(conn);
			if (MemberDAO.Login(account, pwd)) {
				System.out.println("成功登入");
				MemberBean select = MemberDAO.select(account);
				request.getSession(true).setAttribute("Login", select);
			
				request.getRequestDispatcher("/city.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Connection Error");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}
	}

	// 會員資料
	public void gotoMbselectProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;

		try {

			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/BookDB");
			conn = ds.getConnection();
			MemberDAO MemberDAO = new MemberDAO(conn);
			MemberBean mb_inf = (MemberBean) request.getSession(true).getAttribute("Login");
			String account = mb_inf.getMB_Account();
			MemberBean select = MemberDAO.select(account);
			request.getSession(true).setAttribute("Member", select);
			request.getRequestDispatcher("/mb_inf.jsp").forward(request, response);
		}

		catch (

		NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Connection Error");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}
	}

	// 會員修改
	public void gotoUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		String password;
		String account;
		try {

			// �إ�Context Object,�s��JNDI Server
			ctxt = new InitialContext();

			// �ϥ�JNDI API���DataSource
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/BookDB");
			// ds = ( DataSource ) ctxt.lookup("jdbc/OracleXE");
			// �VDataSource�nConnection
			conn = ds.getConnection();

			// �إ�Database Access Object,�t�dTable��Access
			MemberBean Login = (MemberBean) request.getSession(true).getAttribute("Login");
			System.out.print(Login.getMB_Account());
			account = Login.getMB_Account();
			password = request.getParameter("pwd");
			MemberDAO connt = new MemberDAO(conn);
			boolean update = connt.update(account, password);

			if (update) {
				request.getRequestDispatcher("/city.jsp").forward(request, response);
//			response.sendRedirect("city.jsp");
			}
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Connection Error");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}

	}

	// 管理員(會員資料)
	public void gotoSelectProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.getRequestDispatcher("/admin.jsp").forward(request, response);
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		System.out.println(1);
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/BookDB");
			conn = ds.getConnection();

			MemberDAO memberDAO = new MemberDAO(conn);
			List<MemberBean> inf = memberDAO.adminselect();
			System.out.println(inf);
			// if(inf != null) {
//				request.getSession(true).setAttribute("inf", inf);
			request.setAttribute("user", inf);
			// }
			request.getRequestDispatcher("/adminModify.jsp").forward(request, response);
//				request.getRequestDispatcher("/admin.jsp").forward(request, response);
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Connection Error");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}

	}

	// 管理員介面
	public void gotoAdminProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/admin.jsp").forward(request, response);

	}

	// 管理員會員刪除
	public void gotoDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.getRequestDispatcher("/admin.jsp").forward(request, response);

		int MB_ID = Integer.valueOf(request.getParameter("delete"));
		System.out.print(MB_ID);

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/BookDB");
			conn = ds.getConnection();

			MemberDAO memberDAO = new MemberDAO(conn);
			memberDAO.delete(MB_ID);
			List<MemberBean> inf = memberDAO.adminselect();
			request.setAttribute("user", inf);
			request.getRequestDispatcher("/adminModify.jsp").forward(request, response);

		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Connection Error");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}

	}

}
