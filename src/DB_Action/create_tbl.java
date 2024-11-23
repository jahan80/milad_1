

package DB_Action;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class create_tbl {
    public String tbl_name = "student_";
    private Connection connection;
    private tbl_checker tblChecker;

    public create_tbl(Connection connection) {
        this.connection = connection;
        this.tblChecker = new tbl_checker(connection);
    }

    public void createTable() {
// حذف جدول اگر وجود دارد
        if (tblChecker.doesTableExist(tbl_name)) {
            String dropTableSQL = "DROP TABLE " + tbl_name;
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(dropTableSQL);
                System.out.println("Table '" + tbl_name + "' dropped.");
            } catch (SQLException e) {
                System.out.println("Error while dropping the table:");
                e.printStackTrace();
            }
        }

// ایجاد جدول جدید
        String createTableSQL =
                "CREATE TABLE " + tbl_name + " (" +
                        "id NUMBER PRIMARY KEY, " +
                        "name VARCHAR2(50), " +
                        "national_code VARCHAR2(50), " +
                        "email_id VARCHAR2(50), " +
                        "slevel VARCHAR2(50))";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Table '" + tbl_name + "' created.");
        } catch (SQLException e) {
            System.out.println("Error while creating the table:");
            e.printStackTrace();
        }
    }
}