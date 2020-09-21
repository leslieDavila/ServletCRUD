import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String un= request.getParameter("uname");
      String pw= request.getParameter("pass");
      
      PrintWriter out=response.getWriter();
      Cookie ck=new Cookie("auth", un);
      ck.setMaxAge(600);
       if(un.equals("Karen")&pw.equals("091197"))
       {
          response.addCookie(ck);
          response.sendRedirect("inicio.jsp");
          return;
       }
       else
       {
          RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
           out.println("<font color=red>Either user name or password is wrong.</font>");
           rd.include(request, response);
       }
   }

}
