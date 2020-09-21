
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
        //processRequest(request, response);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

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
                        response.sendRedirect("index.jsp");
                        return;
                    }
                    i++;
                }
            } else {
                response.sendRedirect("index.jsp");
                return;
            }

            //Cerrar sesión
            out.println("</table>");
            out.println("<form action='LogoutServlet' method='post'>");
            out.print("<input type='submit' value='Cerrar sesion'>");
            out.print("</form>");

            out.println("<a href='inicio.jsp'>Añadir nuevo alumno</a>");
            out.println("<h1>Lista de Alumnos</h1>");

            List<Alumnos> list = AlumnoDAO.getAllAlumnos();

            out.print("<table border='1' width='100%'");
            out.print("<tr><th>Numero de Control</th><th>Nombre</th><th>Curso</th><th>Semestre</th><th>Editar</th><th>Eliminar</th></tr>");
            for (Alumnos e : list) {
                out.print("<tr><td>" + e.getNoControl() + "</td><td>" + e.getNombre() + "</td><td>" + e.getCurso() + "</td><td>" + e.getSemestre() + "</td><td><a href='ModificarServlet?NOCONTROL=" + e.getNoControl() + "'>Modificar</a></td><td><a href='EliminarServlet?NOCONTROL=" + e.getNoControl() + "'>Eliminar</a></td></tr>");
            }
            out.print("</table>");

            out.close();

        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

}
