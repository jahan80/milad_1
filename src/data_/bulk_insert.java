


package data_;

import DB_Action.create_tbl;
import DB_Action.db_conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class bulk_insert {

    // متد برای درج دادههای تولید شده در دیتابیس
    public void insertGeneratedData() {
// ایجاد شیء از کلاس db_conection برای اتصال به دیتابیس
        db_conection dbConnection = new db_conection();

// اتصال به دیتابیس
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        create_tbl cr_tbl = new create_tbl(connection);
        cr_tbl.createTable();
// دستور SQL برای درج اطلاعات در جدول
        String insertQuery = "INSERT INTO student_ (id, name, national_code, email_id, slevel) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
// حلقه برای درج 500 رکورد
            for (int i = 0; i < 500; i++) {
// دریافت دادههای تصادفی از کلاس genaretdata
                Object[] generatedData = genaretdata.generateRandomData();

// تنظیم مقادیر ورودی در دستور SQL
                preparedStatement.setInt(1, (int) generatedData[0]); // ID
                preparedStatement.setString(2, (String) generatedData[1]); // Name
                preparedStatement.setString(3, (String) generatedData[2]); // National Code
                preparedStatement.setString(4, (String) generatedData[3]); // Email
                preparedStatement.setString(5, (String) generatedData[4]); // Slevel

// اجرای دستور SQL
                preparedStatement.addBatch(); // اضافه کردن به batch
            }

// اجرای batch
            int[] rowsInserted = preparedStatement.executeBatch();
            System.out.println(rowsInserted.length + " rows inserted successfully into the table.");
        } catch (SQLException e) {
            System.out.println("Error while inserting data into the table:");
            e.printStackTrace();
        } finally {
// قطع اتصال به دیتابیس
            dbConnection.disconnect();
        }
    }
}