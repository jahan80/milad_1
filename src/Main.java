import DB_Action.db_conection;
import DB_Action.create_tbl;

import java.sql.Connection;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        db_conection con = new db_conection();
        con.connect();

         create_tbl  cr_tbl= new create_tbl(con.getConnection());
        cr_tbl.createtable();

        con.disconnect();
    }





}