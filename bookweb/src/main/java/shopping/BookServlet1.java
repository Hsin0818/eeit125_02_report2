package shopping;

import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
import java.util.List;

//import javax.naming.InitialContext;
//import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookBean;
//import javax.sql.DataSource;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet1")
public class BookServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

//	DataSource ds = null;
//	Connection conn = null;

	@Override
	public void init() throws ServletException {
		super.init();
//		try {
//			InitialContext ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/BookDB");
//			if (ds == null)
//				throw new ServletException("Unknown DataSource 'jdbc/BookDB'");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet1() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType(CONTENT_TYPE);
		BookDAO bookDAO = new BookDAO();

		try {
			System.out.println("qaq");
			if (request.getParameter("selectbk") != null) {
				// 改變
				BookBean data = bookDAO.selectBookID(Integer.parseInt(request.getParameter("selectbk")));
				request.getSession(true).setAttribute("mid", data);
				request.getRequestDispatcher("/single.jsp").forward(request, response);
				// 改變
			} else if (request.getParameter("setbk") != null) {
				// 改變
				String a = request.getParameter("setbk");
				bookDAO.insertBook(Integer.parseInt(request.getParameter(a + "qty")),
						Integer.parseInt(request.getParameter(a + "price")),
						Integer.parseInt(request.getParameter("setbk")), 1);
//					data.setBookid(Integer.parseInt(request.getParameter("setbk")));
//					data.setBookprice(Integer.parseInt(request.getParameter(a+"price")));
//					data.setBookqty(Integer.parseInt(request.getParameter(a+"qty")));
//					data = book.insertBook(data);					
				request.getRequestDispatcher("/sellmid.jsp").forward(request, response);
				// 改變
			} else if (request.getParameter("waitupbk") != null) {
				// 改變
				BookBean data = bookDAO.selectBookID(Integer.parseInt(request.getParameter("waitupbk")));
				request.getSession(true).setAttribute("top", data);
				request.getRequestDispatcher("/displaysell.jsp").forward(request, response);
//				conn = ds.getConnection();
//				BookDAO book = new BookDAO(conn);
//				BookData data = new BookData();
//				data.setBookid(Integer.parseInt(request.getParameter("waitupbk")));
//				data = book.selectBookID(data);
//				request.getSession(true).setAttribute("top", data);
//				request.getRequestDispatcher("/displaysell.jsp").forward(request, response);
				// 改變
			} else if (request.getParameter("updatebk") != null) {
				// 改變
				bookDAO.updateBook(Integer.parseInt(request.getParameter("qty")), Integer.parseInt(request.getParameter("price")), Integer.parseInt(request.getParameter("BK_ID")));
				request.getRequestDispatcher("/sellmid.jsp").forward(request, response);
//				updatebk(request, response);
//					conn = ds.getConnection();
//					BookDAO book = new BookDAO(conn);
//					BookData data = new BookData();
//					data.setBookid(Integer.parseInt(request.getParameter("bookid")));
//					data.setBookprice(Integer.parseInt(request.getParameter("price")));
//					data.setBookqty(Integer.parseInt(request.getParameter("qty")));
//					data = book.updateBook(data);
//					request.getRequestDispatcher("/sellmid.jsp").forward(request, response);
				// 改變
			} else if (request.getParameter("deletebk") != null) {
				// 改變
				
				bookDAO.deleteBook(Integer.parseInt(request.getParameter("deletebk")));
				request.getRequestDispatcher("/sellmid.jsp").forward(request, response);
				
//				deletebk(request, response);
//					conn = ds.getConnection();
//					BookDAO book = new BookDAO(conn);
//					BookData data = new BookData();
//					System.out.println("sss");
//					data.setBookid(Integer.parseInt(request.getParameter("deletebk")));
//					data = book.deleteBook(data);
//					request.getRequestDispatcher("/sellmid.jsp").forward(request, response);
				// 改變
			} else if (request.getParameter("searchbk") != null) {
				// 改變
				
				List<BookBean> list = bookDAO.listBookData(request.getParameter("searchbk"));
				request.getSession(true).setAttribute("qaqget", list);
				request.getRequestDispatcher("/searchsell.jsp").forward(request, response);
//				searchbK(request, response);
					// List<BookData> uvi = dao.listUviData();
//					conn = ds.getConnection();
//					BookDAO book = new BookDAO(conn);
//					BookData data = new BookData();
//					data.setBookname(request.getParameter("searchbk"));
//					List<BookData> list = book.listBookData(data);
//					request.getSession(true).setAttribute("qaqget", list);
//					request.getRequestDispatcher("/searchsell.jsp").forward(request, response);
				// 改變
			}

		} 
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	

}
