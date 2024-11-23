 package data_;

 import java.util.HashSet;
 import java.util.Random;
 import java.util.Set;
 import java.util.UUID;

public class genaretdata {

    private static int currentId = 1;
    private static final Set<Integer> uniqueIds = new HashSet<>(); // برای نگهداری شناسه‌های غیرتکراری
    private static final Random random = new Random(); // برای تولید مقادیر تصادفی

    // متد برای تولید ID تصادفی غیر تکراری
    public static int generateUniqueId() {
        int id = currentId++; // شناسه جدید به ترتیب افزایشی
        uniqueIds.add(id); // اضافه کردن شناسه به مجموعه برای اطمینان از غیرتکراری بودن
        return id;
    }

    // متد برای تولید نام تصادفی
    public static String generateRandomName() {
        String[] names = {"John", "Alice", "Bob","ali", "Emma", "Oliver", "Sophia"};
        return names[random.nextInt(names.length)];
    }

    // متد برای تولید کد ملی تصادفی
    public static String generateRandomNationalCode() {
        return String.format("%09d", random.nextInt(1_000_000_000)); // کد ملی 9 رقمی
    }

    // متد برای تولید ایمیل تصادفی
    public static String generateRandomEmail() {
        String domain = "@example.com";
        String username = UUID.randomUUID().toString().substring(0, 8); // تولید رشته‌ای تصادفی
        return username + domain;
    }

    // متد برای تولید سطح تصادفی
    public static String generateRandomLevel() {
        String[] levels = {"E", "R", "D"};
        return levels[random.nextInt(levels.length)];
    }

    // متد برای تولید یک مجموعه از داده‌های تصادفی
    public static Object[] generateRandomData() {
        int id = generateUniqueId();
        String name = generateRandomName();
        String nationalCode = generateRandomNationalCode();
        String email = generateRandomEmail();
        String level = generateRandomLevel();

        return new Object[]{id, name, nationalCode, email, level};
    }
}

