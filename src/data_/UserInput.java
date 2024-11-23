package data_;
import java.util.Scanner;

public class UserInput {

    // متد برای گرفتن ورودی‌ها
    public static Object[] getUserInputs() {
        Scanner scanner = new Scanner(System.in);

        // گرفتن ورودی‌ها از کاربر
        System.out.print("Please enter ID: ");
        int id = scanner.nextInt();  // گرفتن ورودی به صورت عدد صحیح

        scanner.nextLine();  // برای مصرف خط جدید باقی‌مانده بعد از وارد کردن عدد

        System.out.print("Please enter name: ");
        String name = scanner.nextLine();  // گرفتن ورودی به صورت رشته

        System.out.print("Please enter national code: ");
        String nationalCode = scanner.nextLine();  // گرفتن ورودی به صورت رشته


        String email; // تعریف متغیر برای ایمیل

        while (true) {
            System.out.print("Please enter your email: ");
            email = scanner.nextLine().trim(); // حذف فاصله‌های اضافی

            if (Emailchecker.isValidEmail(email)) { // بررسی اعتبار ایمیل

                break; // خروج از حلقه در صورت معتبر بودن
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        }
        String slevel = "";  // متغیر برای ذخیره مقدار سطح

        // گرفتن ورودی معتبر برای slevel (فقط سه مقدار E، R، D)
        while (true) {
            System.out.print("Please enter level (E, R, D): ");
            slevel = scanner.nextLine().toUpperCase();  // ورودی را به حروف بزرگ تبدیل می‌کنیم
            if (slevel.equals("E") || slevel.equals("R") || slevel.equals("D")) {
                break;  // اگر ورودی معتبر باشد، از حلقه خارج می‌شود
            } else {
                System.out.println("Invalid input. Please enter one of the values E, R, or D.");
            }
        }

        // بازگشت مقادیر وارد شده به صورت یک آرایه
        return new Object[]{id, name, nationalCode, email, slevel};
    }
}