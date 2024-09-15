package GRADECALC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    

      
        private static final String url = "jdbc:mysql://localhost:3306/kisho";
        private static final String password = "4049";
        private static final String userName = "root";

        public static Connection getConnection() throws SQLException {
                return DriverManager.getConnection(url, userName, password);
        }
}
