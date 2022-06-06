
package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PacienteDao {
    
    //Conectar no Banco de Dados
            Connection con;
            PreparedStatement st;
            
            public boolean conectar(){
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoacesso", "root", "tico0715612!");
                    return true;
                } catch (ClassNotFoundException | SQLException ex) {
                    return false;
                    
                }
                
            }
    
}
