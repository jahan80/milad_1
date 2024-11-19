package DB_Action;

import java.sql.*;
import java.sql.Connection;

public class create_tbl {

    private Connection connection ;
    public create_tbl (Connection connection){
        this.connection=connection;
    }
    public void createtable() {
        String tbl_student = "create table student_ (" +
                " id NUMBER PRIMARY KEY ," +
                "name VARCHAR2(50) ," +
                " national_code VARCHAR2(50) , " +
                "email_id VARCHAR2(50), " +
                "slevel VARCHAR2(50))" ;


        try (Statement statement = connection.createStatement()) {
            ((Statement) statement).executeUpdate(tbl_student);
            System.out.println("جدول با موفقیت ایجاد شد!");
        } catch (SQLException e) {
            System.out.println("خطا در ایجاد جدول:");
            e.printStackTrace();
        }
    }


    }

