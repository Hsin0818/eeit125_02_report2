package ACT;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

    // 顯示要修改的活動資料
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>修改活動資料</h1>");
        String sid = request.getParameter("MB_ID");
        int MB_ID = Integer.parseInt(sid);

        ActBean act = ActDAO1.getRecordById(MB_ID);

        //String education = act.getEducation();

        out.print("<form action='EditServlet' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='MB_ID' value='" + act.getMB_ID() + "'/></td></tr>");
        out.print("<tr><td>活動名稱:</td><td><input type='text' name='ACT_Name' value='" + act.getACT_Name() + "'/></td></tr>");
        out.print("<tr><td>活動主題:</td><td><input type='text' name='ACT_Theme' value='" + act.getACT_Theme()+ "'/></td></tr>");
        out.print("<tr><td>活動日期:</td><td><input type='date' name='ACT_Date' value='" + act.getACT_Date() + "'/></td></tr>");
        out.print("<tr><td>活動地點:</td><td><input type='text' name='ACT_Loc' value='" + act.getACT_Loc() + "'/></td></tr>");
        out.print("<tr><td>活動簡介:</td><td><input type='text' name='ACT_Intro' value='" + act.getACT_Intro() + "'/></td></tr>");
        out.print("<tr><td>活動嘉賓:</td><td><input type='text' name='ACT_Guest' value='" + act.getACT_Guest() + "'/></td></tr>");
        out.print("<tr><td>活動人數:</td><td><input type='text' name='ACT_Pax' value='" + act.getACT_Pax() + "'/></td></tr>");
        out.print("<tr><td>活動辦法:</td><td><input type='text' name='ACT_Rule' value='" + act.getACT_Rule() + "'/></td></tr>");
        out.print("<tr><td>活動標籤:</td><td><input type='text' name='ACT_Tag' value='" + act.getACT_Tag() + "'/></td></tr>");
        out.print("<tr><td>活動場所:</td><td><input type='text' name='ACT_Place' value='" + act.getACT_Place() + "'/></td></tr>");
        /*
		 * out.print("<tr><td>学历:</td><td>");
		 * out.print("<select name='education' style='width:150px'>"); if(education ==
		 * "专科") { out.print("<option value='专科' selected='selected'>专科</option>");
		 * }else { out.print("<option value='专科'>专科</option>"); }
		 * 
		 * if(education == "本科") {
		 * out.print("<option value='本科' selected='selected'>本科</option>"); }else {
		 * out.print("<option value='本科'>本科</option>"); }
		 * 
		 * if(education == "研究生") {
		 * out.print("<option value='研究生' selected='selected'>研究生</option>"); }else {
		 * out.print("<option value='研究生'>研究生</option>"); } if(education == "博士") {
		 * out.print("<option value='博士' selected='selected'>博士</option>"); }else {
		 * out.print("<option value='博士'>博士</option>"); }
		 * 
		 * if(education == "其它") {
		 * out.print("<option value='其它' selected='selected'>其它</option>"); }else {
		 * out.print("<option value='其它'>其它</option>"); } out.print("</select>");
		 * out.print("</td></tr>");
		 */
        out.print("<tr><td colspan='2'><input type='submit' value='編輯&保存'/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }

     // 收集表单信息并将修改更新到数据库
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //String sid = request.getParameter("MB_ID");
        //int MB_ID = Integer.parseInt(sid);
        
        int MB_ID = Integer.parseInt(request.getParameter("MB_ID"));
        
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

        ActBean act = new ActBean();
        act.setMB_ID(MB_ID);
        act.setACT_Name(ACT_Name);
        act.setACT_Theme(ACT_Theme);
        act.setACT_Date(ACT_Date);
        act.setACT_Loc(ACT_Loc);
        act.setACT_Intro(ACT_Intro);
        act.setACT_Guest(ACT_Guest);
        act.setACT_Pax(ACT_Pax);
        act.setACT_Rule(ACT_Rule);
        act.setACT_Tag(ACT_Tag);
        act.setACT_Place(ACT_Place);

        int status = ActDAO1.updateAct(act);
        if (status > 0) {
            response.sendRedirect("ViewServlet");
        } else {
            out.println("OOPS~，更新失敗!");
        }
        out.close();
    }
}

