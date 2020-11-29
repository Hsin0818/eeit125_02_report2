package ACT;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        
        //int MB_ID = Integer.parseInt(request.getParameter("MB_ID"));
        String ACT_Name = request.getParameter("ACT_Name");
        
        ActDAO1.deleteAct(ACT_Name);

        response.sendRedirect("ViewServlet");
    }
        
    }
