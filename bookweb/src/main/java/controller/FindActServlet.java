package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ActService;
import Service.ActServiceImpl;
import model.ActBean;




@WebServlet("/FindActServlet")
public class FindActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer Act_ID = Integer.valueOf(request.getParameter("key"));//注意大小寫
		System.out.println(Act_ID);
		ActService as = new ActServiceImpl();
		ActBean ab = as.getAct(Act_ID);
		request.setAttribute("ab", ab);
		RequestDispatcher rd = request.getRequestDispatcher("updateAct.jsp");
		rd.forward(request, response);
		return;
	}
}
