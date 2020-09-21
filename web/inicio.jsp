<%-- 
    Document   : index
    Created on : 10-sep-2020, 21:31:53
    Author     : karen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head><
    <body>
        <%
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
   %>
        <h1>Añadir nuevo alumno</h1>  
        <form action="GuardarServlet" method="post">  
            <table>  
                <tr><td>Numero Control:</td><td><input type="text" name="NOCONTROL"/></td></tr>  
                <tr><td>Nombre:</td><td><input type="text" name="NOMBRE"/></td></tr>  
                <tr><td>Curso:</td><td><input type="text" name="CURSO"/></td></tr>  
                  <tr><td>Semestre:</td><td><input type="text" name="SEMESTRE"/></td></tr>  
                <tr><td colspan="2"><input type="submit" value="Guardar"/></td></tr>  
            </table>  
        </form>  

        <br/>  
        <a href="ViewServlet">Ver alumnos</a>  

        
                <!-- CERRAR SESIÓN-->
        <form action="LogoutServlet" method="post">
            <input type="submit" value="Cerrar sesion">
        </form>
    </body>
    </body>
</html>

