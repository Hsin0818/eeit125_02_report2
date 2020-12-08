package controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookRebortDAO;
import model.BookReportBean;

/**
 * Servlet implementation class BookReportServlet
 */
@WebServlet("/BookReportServlet")
public class BookReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String lastDeletBR_ID = "";
	private String lastUpDateBR_ID = "";
	private String lastView = "";
	private String lupDate_BrContent = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see ArticleServlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");  
		response.setCharacterEncoding("UTF-8");  
		request.setCharacterEncoding("UTF-8");
		
		BookRebortDAO bookReportTable = new BookRebortDAO();
		
		String deleteBR_ID = request.getParameter("beleteButton");
		String update_ID =  request.getParameter("editButton");
		String view_ID = request.getParameter("viewBookReport");
		String bk_ID = request.getParameter("bookreportBK_ID");
		String insertBk = request.getParameter("insertButtons");
		
		String upDate_BrScore = request.getParameter("BrScore1");
		String upDate_BrContent = request.getParameter("BrContent1");
		
		String bkName = request.getParameter(view_ID+"BkName");
		String bkWriter = request.getParameter(view_ID+"BkWriter");
		String bkPublish = request.getParameter(view_ID+"BkPublish");
		String bkPic = request.getParameter(view_ID+"BkPic");
		String brScore = request.getParameter(view_ID+"BrScore");
		String brContent = request.getParameter(view_ID+"BrContent");
		
		
		
		if(view_ID != null && view_ID != lastView) {
			request.setAttribute("bkName", bkName);
			request.setAttribute("bkWriter", bkWriter);
			request.setAttribute("bkPublish", bkPublish);
			request.setAttribute("bkPic", bkPic);
			request.setAttribute("brScore", brScore);
			request.setAttribute("brContent", brContent);
			request.getRequestDispatcher("/addBookReport.jsp").forward(request,response);
		}else if(update_ID != null && update_ID != lastUpDateBR_ID) {
			int br_ID = Integer.valueOf(update_ID);
			int br_Score = Integer.valueOf(upDate_BrScore);
			bookReportTable.upDateBookReportData(br_ID, br_Score, upDate_BrContent);
			List<BookReportBean> bookReportList = bookReportTable.bookReportList(5);
			
			request.setAttribute("bookReportTable", bookReportList);
			request.getRequestDispatcher("/BookReport.jsp").forward(request,response);
			
		}else if(deleteBR_ID != null && deleteBR_ID != lastDeletBR_ID) {
	
			bookReportTable.deleteBookReport(deleteBR_ID);
			List<BookReportBean> bookReportList = bookReportTable.bookReportList(5);
			
			request.setAttribute("bookReportTable", bookReportList);
			request.getRequestDispatcher("/BookReport.jsp").forward(request,response);
		}else if(bk_ID != null) {
			int view_BK_ID = Integer.valueOf(bk_ID);
			List<BookReportBean> bookReportList = bookReportTable.bookReportBKList(view_BK_ID);
			request.setAttribute("bookReportTable", bookReportList);
			request.getRequestDispatcher("/BookReportList.jsp").forward(request,response);
		}else if(insertBk != null ) {
			int insert_BK_ID = Integer.valueOf(insertBk);
			int br_Score = Integer.valueOf(upDate_BrScore);
			if (upDate_BrContent != lupDate_BrContent) {
				bookReportTable.insertBookReport(5, insert_BK_ID, br_Score, upDate_BrContent);
			}
			lupDate_BrContent = upDate_BrContent;
			List<BookReportBean> bookReportList = bookReportTable.bookReportBKList(insert_BK_ID);
			request.setAttribute("bookReportTable", bookReportList);
			request.getRequestDispatcher("/BookReportList.jsp").forward(request,response);
		}else{
			List<BookReportBean> bookReportList = bookReportTable.bookReportList(5);
			
			request.setAttribute("bookReportTable", bookReportList);
			request.getRequestDispatcher("/BookReport.jsp").forward(request,response);
		}
		
		
		
	}

}
