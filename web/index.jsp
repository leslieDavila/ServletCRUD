<%-- 
    Document   : login
    Created on : 20-sep-2020, 17:23:18
    Author     : Leslie Karen Davila Gallegos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginServlet" method="post">
            <h1> Acceso al sistema Alumnos </h1>
            Usuario : <input type="text" name="uname"><br><br>
            Contraseña : <input type="password" name="pass"><br><br>
            <input type="submit" value="Iniciar sesion">
        </form>
        

</html>




