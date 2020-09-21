

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author karen
 */
public class ModificarServlet2 extends HttpServlet {



  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        
     //sesion activa
      Cookie[] cks = request.getCookies();
      if (cks != null) {
         for (int i = 0; i < cks.length; i++) {
            String name = cks[i].getName();
            String value = cks[i].getValue();
            if (name.equals("auth")) {
               break; 
            }
            if (i == (cks.length - 1))
            {
               response.sendRedirect("index.jsp");
               return; 
            }
            i++;
         }
      } else {
         response.sendRedirect("index.jsp");
         return; 
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

  


