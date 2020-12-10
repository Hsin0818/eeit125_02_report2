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


@WebServlet({ "/DeletenUpdateActServlet" })
public class DeletenUpdateActServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession hsession = request.getSession();
		Map<String,String> errorMsg = new HashMap<>();
		hsession.setAttribute("error", errorMsg);
		String modify = request.getParameter("finalDecision");
		Integer ACT_ID =Integer.valueOf(request.getParameter("ACT_ID"));
		System.out.println("modify="+modify);
		ActService as = new ActServiceImpl();
		int count=0;
		if(modify.equalsIgnoreCase("DELETE")){
			count = as.deleteActBean(ACT_ID);
			if(count ==1){
				hsession.setAttribute("modify", "刪除成功");
			}else{
				hsession.setAttribute("modify", "刪除時發生異常");
			}
			String url = request.getContextPath()+"/QueryAllActsServlet";
			String newurl = response.encodeRedirectURL(url);
			response.sendRedirect(newurl);
			
		}else if(modify.equalsIgnoreCase("UPDATE")){
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
			//檢查輸入的資料
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
			//如果輸入資料都正確,進行修改動作
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("updateAct.jsp");
				rd.forward(request, response);
				return;
			}
			
			ActBean ab = new ActBean(null,ACT_ID,ACT_Image,ACT_Name,ACT_Theme,ACT_Date,ACT_Loc,ACT_Intro,ACT_Guest,ACT_Pax,ACT_Rule,ACT_Tag,ACT_Place);
			System.out.println(ab.getACT_Theme());
			count = as.updateActBean(ab);
			if(count==1){
				hsession.setAttribute("modify", "修改成功");
			}else{
				hsession.setAttribute("modify", "修改時發生異常");
			}
			String url = request.getContextPath()+"/QueryAllActsServlet";
			String newurl = response.encodeRedirectURL(url);
			response.sendRedirect(newurl);
		}
	}
}
