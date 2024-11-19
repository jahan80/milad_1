package DB_Action;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_conection {
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String username = "hr";
    private String password = "hr";

    private Connection connection;
    public void connect() {
        try {

            Class.forName("oracle.jdbc.OracleDriver");


            connection = DriverManager.getConnection(url, username, password);
            System.out.println("ok_conect");

        } catch (ClassNotFoundException e) {
            System.out.println("Nok conect");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error in conect");
            e.printStackTrace();
        }
    }


    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("conection clos.");
            } catch (SQLException e) {
                System.out.println("error in conection close.");
                e.printStackTrace();
            }
        }
    }


    public Connection getConnection() {
        return connection;
    }


}
