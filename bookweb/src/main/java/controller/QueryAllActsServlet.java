package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ActService;
import Service.ActServiceImpl;
import model.ActBean;


@WebServlet("/QueryAllActsServlet")
public class QueryAllActsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActService as = new ActServiceImpl();
		List <ActBean>list = as.getAllActs();
		request.setAttribute("allActs", list);
		RequestDispatcher rd = request.getRequestDispatcher("showActs.jsp");
		rd.forward(request, response);
		return;		
	}

}
