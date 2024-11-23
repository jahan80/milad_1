
import DB_Action.db_conection;
import DB_Action.insert;
import data_.bulk_insert;
import DB_Action.search_;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a command (init, userset, getrecord):");
        String command = scanner.nextLine().trim().toLowerCase();

        switch (command) {
            case "init":
                bulk_insert bulkinsert = new bulk_insert();
                bulkinsert.insertGeneratedData();
                break;

            case "userset":
                insert dbActions = new insert();
                dbActions.getUserInputs();
                dbActions.insertUserData();
                break;

            case "getrecord":
                db_conection con = new db_conection();
                con.connect();
                search_ search = new search_(con.getConnection());
                System.out.println("Enter part of the national code to search:");
                String partialNationalCode = scanner.nextLine().trim();
                search.searchByPartialNationalCode(partialNationalCode);
                con.disconnect();
                break;

            default:
                System.out.println("Invalid command. Please enter one of the following: init, userset, getrecord.");
                break;
        }

        scanner.close();
    }
}