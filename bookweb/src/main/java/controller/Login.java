package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

import java.sql.*;
import java.util.List;

//import javax.rmi.*;
import javax.naming.*;
import javax.sql.*;

import Service.MemberService;
import model.MemberBean;


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

		account = request.getParameter("account");
		pwd = request.getParameter("pwd");

		MemberService ms = new MemberService();
		boolean mb = ms.Login(account, pwd);
		if (mb) {
			System.out.println("成功登入");
			MemberBean select = ms.select(account);
			request.getSession(true).setAttribute("Login", select);
			request.getRequestDispatcher("/city.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	// 會員資料
	public void gotoMbselectProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberBean mb_inf = (MemberBean) request.getSession(true).getAttribute("Login");
		String account = mb_inf.getmB_Account();
		MemberService ms = new MemberService();
		MemberBean select = ms.select(account);
		request.getSession(true).setAttribute("Member", select);
		request.getRequestDispatcher("/mb_inf.jsp").forward(request, response);
	}

	// 會員修改
	public void gotoUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password;
		MemberBean Member = (MemberBean) request.getSession(true).getAttribute("Member");

		password = request.getParameter("pwd");
		Member.setmB_Password(password);

//		request.getSession(true).setAttribute("Member", password);
		System.out.println("MemberPsd:" + Member.getmB_Password());

		MemberService ms = new MemberService();
		boolean update = ms.update(Member);
		if (update) {
			request.getRequestDispatcher("/city.jsp").forward(request, response);
//			response.sendRedirect("city.jsp");
		}

	}

	// 管理員(會員資料)
	public void gotoSelectProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//			request.getRequestDispatcher("/admin.jsp").forward(request, response);
		MemberService ms = new MemberService();
		List<MemberBean> inf = ms.adminselect();
		if (inf != null) {
//			request.getSession(true).setAttribute("inf", inf);
			request.setAttribute("user", inf);
		}
		request.getRequestDispatcher("/adminModify.jsp").forward(request, response);
//				request.getRequestDispatcher("/admin.jsp").forward(request, response);
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
		MemberService ms = new MemberService();
		ms.deleteMember(MB_ID);
		List<MemberBean> inf = ms.adminselect();
		request.setAttribute("user", inf);
		request.getRequestDispatcher("/adminModify.jsp").forward(request, response);

	}

}
