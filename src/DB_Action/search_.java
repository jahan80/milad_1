

package DB_Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class search_ {

    private Connection connection;

    public search_(Connection connection) {
        this.connection = connection;
    }

    // متد برای جستجو بر اساس بخشی از national_code
    public void searchByPartialNationalCode(String partialNationalCode) {
        String searchQuery = "SELECT * FROM student_ WHERE national_code LIKE ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            preparedStatement.setString(1, "%" + partialNationalCode + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) { // بررسی خالی بودن ResultSet
                System.out.println("No records found for National Code containing: " + partialNationalCode);
                return;
            }

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String nationalCode = resultSet.getString("national_code");
                String email = resultSet.getString("email_id");
                String slevel = resultSet.getString("slevel");

                System.out.println("ID: " + id + ", Name: " + name + ", National Code: " + nationalCode + ", Email: " + email + ", Level: " + slevel);
            }
        } catch (SQLException e) {
            System.out.println("Error while searching for data:");
            e.printStackTrace();
        }
    }
}