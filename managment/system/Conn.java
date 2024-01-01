
package employee.managment.system;

import java.sql.*;

public class Conn {
    
     Connection c; // c string h
     Statement s;
    public Conn(){
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    c = DriverManager.getConnection("jdbc:mysql:///emplooyemanagmentsystem", "root", "MDhasnat@123");
    s = c.createStatement();
   }
  catch(Exception e){
    e.printStackTrace();
}    
    }
}

        
