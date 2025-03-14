import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private static final int MAX_SIZE = 20;
    private static final int MIN_RANDOM = -50;
    private static final int MAX_RANDOM = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть висоту матриці (не більше " + MAX_SIZE + "): ");
        int rows = getValidSize(scanner);

        System.out.print("Введіть ширину матриці (не більше " + MAX_SIZE + "): ");
        int cols = getValidSize(scanner);

        System.out.print("Оберіть спосіб заповнення матриці (1 - вручну, 2 - випадково): ");
        int choice = getValidChoice(scanner);

        int[][] matrix = (choice == 1) ? createMatrixManually(scanner, rows, cols) : createMatrixRandomly(rows, cols);

        System.out.println("\nЗгенерована матриця:");
        printMatrix(matrix);

        // Результати
        System.out.println("\nМінімальний елемент: " + findMin(matrix));
        System.out.println("Максимальний елемент: " + findMax(matrix));
        System.out.println("Середнє арифметичне: " + calculateAverage(matrix));
        System.out.println("Середнє геометричне: " + calculateGeometricMean(matrix));

        scanner.close();
    }

    private static int getValidSize(Scanner scanner) {
        int size;
        do {
            while (!scanner.hasNextInt()) {
                System.out.print("Помилка! Введіть число: ");
                scanner.next();
            }
            size = scanner.nextInt();
            if (size < 1 || size > MAX_SIZE) {
                System.out.print("Число має бути від 1 до " + MAX_SIZE + ". Спробуйте ще раз: ");
            }
        } while (size < 1 || size > MAX_SIZE);
        return size;
    }

    private static int getValidChoice(Scanner scanner) {
        int choice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.print("Помилка! Введіть 1 або 2: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice != 1 && choice != 2) {
                System.out.print("Некоректний вибір! Введіть 1 або 2: ");
            }
        } while (choice != 1 && choice != 2);
        return choice;
    }

    private static int[][] createMatrixManually(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("matrix[" + i + "][" + j + "]: ");
                matrix[i][j] = getValidInteger(scanner);
            }
        }
        return matrix;
    }

    private static int[][] createMatrixRandomly(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0, count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
                count++;
            }
        }
        return (double) sum / count;
    }

    private static double calculateGeometricMean(int[][] matrix) {
        double product = 1.0;
        int count = 0;

        for (int[] row : matrix) {
            for (int num : row) {
                if (num == 0) {
                    return 0; // Якщо є нуль, середнє геометричне = 0
                }
                product *= Math.abs(num); // Беремо абсолютні значення, щоб уникнути від'ємних чисел
                count++;
            }
        }
        return Math.pow(product, 1.0 / count);
    }

    private static int getValidInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Помилка! Введіть ціле число: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
