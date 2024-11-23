package DB_Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert {

    private Object[] userInput; // ذخیره ورودی‌های کاربر

    // متد برای گرفتن ورودی از کاربر (فقط یک‌بار)
    public void getUserInputs() {
        this.userInput = data_.UserInput.getUserInputs();
    }

    // متد برای درج داده‌ها در جدول
    public void insertUserData() {
        // ایجاد شیء از کلاس db_conection برای اتصال به دیتابیس
        db_conection dbConnection = new db_conection();

        // اتصال به دیتابیس
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();

        // دستور SQL برای درج اطلاعات در جدول
        String insertQuery = "INSERT INTO student_ (id, name, national_code, email_id, slevel) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // تنظیم مقادیر ورودی در دستور SQL
            preparedStatement.setInt(1, (int) userInput[0]); // ID
            preparedStatement.setString(2, (String) userInput[1]); // Name
            preparedStatement.setString(3, (String) userInput[2]); // National Code
            preparedStatement.setString(4, (String) userInput[3]); // Email
            preparedStatement.setString(5, (String) userInput[4]); // Slevel

            // اجرای دستور SQL
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully into the table.");
            }
        } catch (SQLException e) {
            System.out.println("Error while inserting data into the table:");
            e.printStackTrace();
        } finally {
            // قطع اتصال به دیتابیس
            dbConnection.disconnect();
        }
    }
}
