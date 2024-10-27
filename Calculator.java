package NikolaevSASHA.lesson1;

import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение (например, 9 * 7):");
        String input = scanner.nextLine();

        try {
            System.out.println("Результат: " + calc(input));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) throw new Exception("Неверный формат ввода");

        int a = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int b = Integer.parseInt(parts[2]);

        if (a < 1 || a > 10 || b < 1 || b > 10)
            throw new Exception("Числа должны быть от 1 до 10 включительно");

        return switch (operator) {
            case "+" -> String.valueOf(a + b);
            case "-" -> String.valueOf(a - b);
            case "*" -> String.valueOf(a * b);
            case "/" -> {
                if (b == 0) throw new Exception("Деление на ноль невозможно");
                yield String.valueOf(a / b);
            }
            default -> throw new Exception("Неверный оператор");
        };
    }
}
