package DB_Action;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tbl_checker {

    private Connection connection;


    public tbl_checker(Connection connection) {
        this.connection = connection;
    }


    public boolean doesTableExist(String tableName) {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            try (ResultSet resultSet = metaData.getTables(null, null, tableName.toUpperCase(), new String[]{"TABLE"})) {
                return resultSet.next(); //
            }
        } catch (SQLException e) {
            System.out.println("Error in checking");
            e.printStackTrace();
            return false;
        }
    }
}
