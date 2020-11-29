package ACT;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.jsp'>發布活動</a>");  
        out.println("<h1>活動列表</h1>");  

        List<ActBean> list=ActDAO1.getAllRecords();  

        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>會員帳號</th><th>活動名稱</th><th>活動主題</th><th>活動日期</th><th>活動地點</th><th>活動簡介</th><th>活動嘉賓</th><th>活動人數</th><th>活動辦法</th><th>活動標籤</th><th>活動場所</th><th>操作</th></tr>");  
        for(ActBean act:list){  
        out.print("<tr><td>"+act.getMB_ID()+"</td><td>"+act.getACT_Name()+
        		"</td><td>"+act.getACT_Theme()+"</td><td>"+act.getACT_Date()+
        		"</td><td>"+act.getACT_Loc()+"</td><td>"+act.getACT_Intro()+
        		"</td><td>"+act.getACT_Guest()+"</td><td>"+act.getACT_Pax()+
        		"</td><td>"+act.getACT_Rule()+"</td><td>"+act.getACT_Tag()+
        		"</td><td>"+act.getACT_Place()+
        		"</td><td><a href='EditServlet?MB_ID="+act.getMB_ID()+
        		"'>編輯</a> | <a href='DeleteServlet?ACT_Name="+act.getACT_Name()+
        		"' onClick=\"return confirm('確定要刪除嗎？')\">刪除</a></td></tr>");  
        }  
        out.print("</table>");  
        out.close();  
    }
}


