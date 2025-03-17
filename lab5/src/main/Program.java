import database.resources.DatabaseManager;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер місяця (1-12): ");
        int month = scanner.nextInt();

        List<String> students = DatabaseManager.getStudentsByMonth(month);
        if (students.isEmpty()) {
            System.out.println("Немає студентів, які народилися в цьому місяці.");
        } else {
            System.out.println("Студенти, народжені у вибраному місяці:");
            students.forEach(System.out::println);
        }
    }
}
