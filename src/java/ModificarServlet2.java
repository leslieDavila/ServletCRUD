

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Leslie Karen Davila Gallegos
 */
public class ModificarServlet2 extends HttpServlet {



  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        
     //sesion activa
        HttpSession session = request.getSession();
            if (session != null) {
                if (session.getAttribute("user") != null) {
                    String name = (String) session.getAttribute("user");
                    //out.print("Hello, " + name + "  Welcome to ur Profile");
                } else {
                    response.sendRedirect("index.jsp");
                }
            }
          
       
        String NoControl=request.getParameter("NOCONTROL");  
        String nombre=request.getParameter("NOMBRE");  
        String curso=request.getParameter("CURSO");  
        String semestre=request.getParameter("SEMESTRE");  
          
        Alumnos e=new Alumnos();  
        e.setNoControl(NoControl);
        e.setNombre(nombre); 
        e.setCurso(curso);  
        e.setSemestre(semestre); 
         
         
      
          
        int status=AlumnoDAO.update(e);  
        if(status>0){ 
            
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("No se guardaron los cambios");  
            

              
        }  
          
        out.close();  
    }  
        
        
    }

  


