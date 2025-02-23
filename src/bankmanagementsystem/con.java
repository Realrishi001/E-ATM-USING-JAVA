
package bankmanagementsystem;

import java.sql.*;

public class con {
    
       Connection c;
       Statement s;
       
    public con(){
        try{
            
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "rishi");
            s = c.createStatement();
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
