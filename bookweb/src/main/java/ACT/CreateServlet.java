package ACT;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

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
                

        int status = ActDAO1.createAct(act);
        if (status > 0) {
            out.print("<p>新增活動成功!</p>");
            request.getRequestDispatcher("index.jsp").include(request, response);
        } else {
            out.println("OOPS~，新增失敗!");
        }

        out.close();
    }

}

