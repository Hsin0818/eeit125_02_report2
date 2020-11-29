package member;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import memberbean.MemberBean;

/**
 * Servlet implementation class Modify
 */
@WebServlet("/Modify")
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";
	private static final String Select = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);

		// To prevent caching
		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
		if (request.getParameter("update") != null) 
			gotoUpdate(request, response);
	}

	public void gotoUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;

		try {

			// �إ�Context Object,�s��JNDI Server
			ctxt = new InitialContext();

			// �ϥ�JNDI API���DataSource
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/EmployeeDB");
			// ds = ( DataSource ) ctxt.lookup("jdbc/OracleXE");
			// �VDataSource�nConnection
			conn = ds.getConnection();

			// �إ�Database Access Object,�t�dTable��Access
			MemberBean a = new MemberBean();
			ModifyDAO c = Select(a);
			
			System.out.println(a);
			
//			String a=request.getParameter("account");
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

	private ModifyDAO Select(MemberBean a) {
		// TODO Auto-generated method stub
		return null;
	}
}
