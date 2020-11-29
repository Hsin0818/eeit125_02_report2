package member;

import javax.servlet.*;
import java.io.*;

import java.sql.*;
//import javax.rmi.*;
import javax.naming.*;
import javax.sql.*;

import memberbean.MemberBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

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
		
		
		if (request.getParameter("submit") != null) {
			gotoSubmitProcess(request, response);}
		if (request.getParameter("confirm") != null) 
			gotoConfirmProcess(request, response);
	}
	public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String MB_Account;
		String MB_Password;
		String MB_Sex;
		Date MB_Birthday;
		String MB_Name;
		String MB_Mail;
		String MB_Tel;
		String MB_Address;
		String MB_type;
		String type="";
		String vs[]=null;		
		
		MB_Account = request.getParameter("account").trim();
		MB_Password = request.getParameter("pwd").trim();
		MB_Sex = request.getParameter("sex").trim();
		MB_Birthday = Date.valueOf(request.getParameter("date").trim());
		MB_Name = request.getParameter("name").trim();
		MB_Mail = request.getParameter("mail").trim();
		MB_Tel = request.getParameter("tel").trim();
		MB_Address = request.getParameter("address").trim();
		vs=request.getParameterValues("type");
		for(int i=0;i<vs.length;i++) {type+=vs[i]+",";}		
		MB_type =type;
		MemberBean reg_member = new MemberBean(MB_Account, MB_Password, MB_Sex, MB_Birthday, MB_Name, MB_Mail, MB_Tel, MB_Address,null, 0, MB_type);
		request.getSession(true).setAttribute("reg_member", reg_member);
		request.getRequestDispatcher("/confirm.jsp").forward(request, response);
	}

	public void gotoConfirmProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

			// �إ�Database Access Object,�t�dTable��Access
			MemberDAO RegisterDAO = new MemberDAO(conn);
			MemberBean memberData = (MemberBean) request.getSession(true).getAttribute("reg_member");
			if (RegisterDAO.insertMember(memberData)) {
				System.out.println("Get some SQL commands done!");
				request.getSession(true).invalidate();
				request.getRequestDispatcher("/Thanks.jsp").forward(request, response);
			}else request.getRequestDispatcher("/login.jsp").forward(request, response);
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