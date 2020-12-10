package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.SearchService;
import Service.SearchServiceImpl;
import model.BookBean;
import model.Book_COLLECTBean;

@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		if (request.getParameter("name") != null) {
			gotoSearch(request, response);
		} else {
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
		
		if (request.getParameter("update") != null) {
			gotoUpdate(request, response);
		}

		if (request.getParameter("confirm") != null) {
			gotoUpdateFin(request, response);
		}

	}

	// 查詢書籍關鍵字
	public void gotoSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		name = request.getParameter("name");
		SearchService ss = new SearchServiceImpl();
		List<BookBean> result = ss.searchBook(name);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
		rd.forward(request, response);
	}

	// 在查詢結果頁加入收藏
	@SuppressWarnings("unused")
	public void gotoCollect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bk_id = Integer.valueOf(request.getParameter("collect"));
		int mb_id = 5;
		SearchService ss = new SearchServiceImpl();
		int result2 = ss.savebc(bk_id, mb_id);
		
		//導回原查詢頁面
		List<BookBean> result = ss.searchBook(name);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
		rd.forward(request, response);

	}
	
	// 會員收藏清單
	public void gotoList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		int mb_id=request.getParameter("list");
		int mb_id = 5;
		SearchService ss = new SearchServiceImpl();
		List<Book_COLLECTBean> result = ss.gotoCollect(mb_id);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("Collect.jsp");
		rd.forward(request, response);
	}

	// 刪除收藏項目
	@SuppressWarnings("unused")
	public void gotoDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bc_id = Integer.valueOf(request.getParameter("delete"));
		SearchService ss = new SearchServiceImpl();
		int result2 = ss.delete(bc_id);

		//導回會員收藏清單
		int mb_id = 5;
		List<Book_COLLECTBean> result = ss.gotoCollect(mb_id);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("Collect.jsp");
		rd.forward(request, response);
	}

	// 取得單一本書的詳細資訊
	public void gotoPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bk_id = Integer.valueOf(request.getParameter("page"));
		SearchService ss = new SearchServiceImpl();
		BookBean result = ss.getBook(bk_id);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("Page.jsp");
		rd.forward(request, response);
	}
	
	//在單獨頁面加入收藏
	public void gotoPageCollect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bk_id = Integer.valueOf(request.getParameter("pagecollect"));
		int mb_id = 5;
		SearchService ss = new SearchServiceImpl();
		int result2 = ss.savebc(bk_id, mb_id);
		
		//導回原單獨頁面
		BookBean result = ss.getBook(bk_id);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("Page.jsp");
		rd.forward(request, response);
	}


	// 前往修改書籍頁面
	public void gotoUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bk_id = Integer.valueOf(request.getParameter("update"));
		SearchService ss = new SearchServiceImpl();
		BookBean result = ss.getBook(bk_id);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
		rd.forward(request, response);
	}

	// 最終更新頁面
	@SuppressWarnings("unused")
	public void gotoUpdateFin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取得輸入資料（未完整）
		int bk_ID = Integer.valueOf(request.getParameter("id"));
		String bk_Name = request.getParameter("bookname");
		String bk_Author = request.getParameter("bookwriter");
		String bk_Publish = request.getParameter("bookpublish");
		Date bk_Date = java.sql.Date.valueOf(request.getParameter("booktime"));
		String bk_Content = request.getParameter("bookcontent");
		String bk_Editor = null;
		String bk_Translator = null;
		String bk_Transname = null;
		String bk_ISBN = null;
		String bk_Pic = "aaaa";
		String bk_Language = null;
		int bk_Page = 0;
		String bk_Reader = null;

		BookBean result = new BookBean(bk_ID, bk_Name, bk_Transname, bk_Author, bk_Translator, bk_Publish,
				bk_ISBN, bk_Date, bk_Pic, bk_Language, bk_Content, bk_Page);
		SearchService ss = new SearchServiceImpl();
		int count = ss.updatebk(result);

		//導回原本的書籍單獨頁面，顯示更新結果
		result = ss.getBook(bk_ID);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("Page.jsp");
		rd.forward(request, response);
	
	}

}
