
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ModificarServlet extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
        
        response.setContentType("text/html;charset=UTF-8");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Modificar Alumno</h1>");  
        String  NControl=request.getParameter("NOCONTROL");  
        //int numeroC=Integer.parseInt(sid);  
          
        Alumnos e=AlumnoDAO.getAlumnoXNoC(NControl);  
          
        out.print("<form action= 'ModificarServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='NOCONTROL' value='"+e.getNoControl()+"'/></td></tr>"); 
        out.print("<tr><td>Nombre:</td><td><input type='text' name='NOMBRE' value='"+e.getNombre()+"'/></td></tr>");  
        out.print("<tr><td>Curso:</td><td><input type='text' name='CURSO' value='"+e.getCurso()+"'/> </td></tr>"); 
        out.print("<tr><td>Semestre:</td><td><input type='text' name='SEMESTRE' value='"+e.getSemestre()+"'/> </td></tr>"); 
         
         
        out.print("<tr><td colspan='2'><input type='submit' value='Guardar cambios '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
        
    }



