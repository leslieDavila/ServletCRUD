
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
    
    
    //CONEXION A LA BD
    public static Connection getConnection() {

        Connection con = null;
        String url = "jdbc:derby://localhost:1527/Tarea2";
        String user = "Alumnos";
        String pass = "1234";

        Driver driver = new org.apache.derby.jdbc.ClientDriver();

        try {
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;

    }
//guardar
        public static int save(Alumnos e){  
            int status=0;  
            try{  
                Connection con=AlumnoDAO.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "insert into ALUMNOS(NOCONTROL,NOMBRE,CURSO,SEMESTRE) values (?,?,?,?)");  
                ps.setString(1,e.getNoControl()); 
                ps.setString(2,e.getNombre());  
                ps.setString(3,e.getCurso()); 
                ps.setString(4,e.getSemestre());   
                
   
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        
//actualizar        
        public static int update(Alumnos e){  
            int status=0;  
            try{  
                Connection con=AlumnoDAO.getConnection(); 
                //System.out.println("entre");
                PreparedStatement ps=con.prepareStatement(  
                             "update ALUMNOS set NOMBRE=?,CURSO=?,SEMESTRE=? where NOCONTROL=?");  
                
                ps.setString(1,e.getNombre());  
                ps.setString(2,e.getCurso()); 
                ps.setString(3,e.getSemestre()); 
                ps.setString(4,e.getNoControl()); 
                //System.out.println("hice la consulta");
                status=ps.executeUpdate();  
                  //System.out.println("aqui toy");
                con.close();  
                //System.out.println("cerre");
            }catch(Exception ex){
                 
                ex.printStackTrace();}  
              
            return status;  
        }  
        
//eliminar        
        public static int delete(String NControl){  
            int status=0;  
            try{  
                Connection con=AlumnoDAO.getConnection();  
                PreparedStatement ps=con.prepareStatement("delete from ALUMNOS where NOCONTROL=?");  
                ps.setString(1,NControl);  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return status;  
        }  
        
//por numero de control
        public static Alumnos getAlumnoXNoC(String NControl){  
            Alumnos e=new Alumnos();  
              
            try{  
                Connection con=AlumnoDAO.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from ALUMNOS where NOCONTROL=?");  
                ps.setString(1,NControl);  
                ResultSet rs=ps.executeQuery();  
                if(rs.next()){  
                    e.setNoControl(rs.getString(1));  
                    e.setNombre(rs.getString(2));  
                    e.setCurso(rs.getString(3));  
                    e.setSemestre(rs.getString(4));  
                 
                }  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return e;  
        }  
        
// ver todos        
        public static List<Alumnos> getAllAlumnos(){  
            List<Alumnos> list=new ArrayList<Alumnos>();  
              
            try{  
                Connection con=AlumnoDAO.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from ALUMNOS");  
                ResultSet rs=ps.executeQuery();  
                while(rs.next()){  
                    Alumnos e=new Alumnos();  
                    e.setNoControl(rs.getString(1));  
                    e.setNombre(rs.getString(2));  
                    e.setCurso(rs.getString(3));  
                    e.setSemestre(rs.getString(4)); 
                    list.add(e);  
                }  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return list;  
        }  
    }  