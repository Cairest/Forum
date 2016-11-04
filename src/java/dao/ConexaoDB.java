
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1539917
 */
public class ConexaoDB {
    
    private Connection connection;
    
    static{
            try {
		Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }

    public Connection getConnection() {
        try {
            if(connection!=null){
                return connection;
            }
            connection = DriverManager.getConnection(
		"jdbc:postgresql://localhost/forum", "postgres", "admin");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível executar o acesso ao banco de dados", e);
        }
    }
}
