package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.ActService;
import Service.ActServiceImpl;
import model.ActBean;


@WebServlet("/InsertActServlet")
public class InsertActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("error", errorMsg);
		// 讀取輸入資料
		String MB_ID = request.getParameter("MB_ID");
		String ACT_Image = request.getParameter("ACT_Image");
		String ACT_Name = request.getParameter("ACT_Name");
		String ACT_Theme = request.getParameter("ACT_Theme");
		String ACT_Date = request.getParameter("ACT_Date");
		String ACT_Loc = request.getParameter("ACT_Loc");
		String ACT_Intro = request.getParameter("ACT_Intro");
		String ACT_Guest = request.getParameter("ACT_Guest");
		String ACT_Pax = request.getParameter("ACT_Pax");
		String ACT_Rule = request.getParameter("ACT_Rule");
		String ACT_Tag = request.getParameter("ACT_Tag");
		String ACT_Place = request.getParameter("ACT_Place");

		if (MB_ID == null || MB_ID.trim().length() == 0) {
			errorMsg.put("MB_ID", "帳號不得空白");
		} else if (MB_ID.trim().length() < 3) {
			errorMsg.put("MB_ID", "帳號至少要3個字元");
		}
		if (ACT_Name == null || ACT_Name.trim().length() == 0) {
			errorMsg.put("ACT_Name", "活動名稱不得空白");
		}
		if (ACT_Theme == null || ACT_Theme.trim().length() == 0) {
			errorMsg.put("ACT_Theme", "活動主題不得空白");
		}
		if (ACT_Date == null || ACT_Date.trim().length() == 0) {
			errorMsg.put("ACT_Date", "請選擇活動日期");
		}
		if (ACT_Loc == null || ACT_Loc.trim().length() == 0) {
			errorMsg.put("ACT_Loc", "活動地點不得空白");
		}
		if (ACT_Intro == null || ACT_Intro.trim().length() == 0) {
			errorMsg.put("ACT_Intro", "活動簡介不得空白");
		}
		if (ACT_Guest == null || ACT_Guest.trim().length() == 0) {
			errorMsg.put("ACT_Guest", "活動嘉賓不得空白");
		}
		if (ACT_Pax == null || ACT_Pax.trim().length() == 0) {
			errorMsg.put("ACT_Pax", "活動人數不得空白");
		}
		if (ACT_Rule == null || ACT_Rule.trim().length() == 0) {
			errorMsg.put("ACT_Rule", "活動人數不得空白");
		}
		if (ACT_Tag == null || ACT_Tag.trim().length() == 0) {
			errorMsg.put("ACT_Tag", "活動人數不得空白");
		}
		if (ACT_Place == null || ACT_Place.trim().length() == 0) {
			errorMsg.put("ACT_Place", "活動人數不得空白");
		}
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("ActForm.jsp");
			rd.forward(request, response);
			return;
		}

		// 企業邏輯的運算
		ActService as = new ActServiceImpl();
		if (as.isDup(ACT_Name)) {
			errorMsg.put("ACT_Name", "活動名稱重複，請重新輸入新活動名稱");
			RequestDispatcher rd = request.getRequestDispatcher("ActForm.jsp");
			rd.forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		try {
			// 將要寫入的資料裝到Bean內
			ActBean ab = new ActBean(MB_ID, null, ACT_Image, ACT_Name, ACT_Theme, ACT_Date, ACT_Loc, ACT_Intro,
					ACT_Guest, ACT_Pax, ACT_Rule, ACT_Tag, ACT_Place);
			session.setAttribute("ab", ab);
			as.save(ab);
		} catch (Exception e) {
			errorMsg.put("MB_ID", "寫入資料時發生異常,訊息:" + e.getMessage());
		}
		// 沒有任何錯誤時
		if (errorMsg.isEmpty()) {

			String url = request.getContextPath() + "/InsertActSuccess.jsp";
			String targetURL = response.encodeRedirectURL(url);
			// 新增資料成功,利用response.encodeRedirect送出回應,共用資料放在Session物件
			// 新增資料失敗,利用RequestDispatcher送出回應,共用資料放在request物件
			response.sendRedirect(targetURL);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("ActForm.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
