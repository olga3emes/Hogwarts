package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

     private  static final String URL ="jdbc:mysql://localhost:3306/hp";
     private  static final String USER = "root";
     private  static final String PASSWORD = "test";


     public static Connection getConnection(){

         Connection conn = null;
         try {
             conn = DriverManager.getConnection(URL, USER, PASSWORD);
             System.out.println("👍✅ Bienvenido a Hogwarts! 🏰");
         }catch(SQLException e){
             System.out.println("❌❌❌ Error de conexión: " + e.getMessage());
         }
     return conn;
     }
}
