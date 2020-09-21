/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author karen
 */
public class EliminarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        try {

            //sesion activa
            Cookie[] cks = request.getCookies();
            if (cks != null) {
                for (int i = 0; i < cks.length; i++) {
                    String name = cks[i].getName();
                    String value = cks[i].getValue();
                    if (name.equals("auth")) {
                        break;
                    }
                    if (i == (cks.length - 1)) {
                        response.sendRedirect("login.jsp");
                        return;
                    }
                    i++;
                }
            } else {
                response.sendRedirect("login.jsp");
                return;
            }

            String NControl = request.getParameter("NOCONTROL");
            AlumnoDAO.delete(NControl);
            response.sendRedirect("ViewServlet");

        } catch (Exception exc) {
            System.out.println(exc);
        }

    }

}
