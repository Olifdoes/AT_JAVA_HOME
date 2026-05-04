import java.util.Scanner;

class Decode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = new String[5];

        System.out.println("Введите 5 частей закодированного сообщения:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Часть " + (i + 1) + ": ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("NULL")) {
                System.out.println("Часть сообщения повреждена! Используем резервный фрагмент...");
                parts[i] = "XX";
            } else {
                parts[i] = input;
            }
        }

        // Собираем сообщение, разделяя части символом #
        String message = String.join("#", parts);

        // Вывод результата
        System.out.println("\n Расшифрованное послание: " + message);

        scanner.close();
    }
}


class Alert {
    public static void main(String[] args) {
        int passCount = 0;
        int flakyCount = 0;
        int bugCount = 0;
        int criticalCount = 0;

        System.out.println("=== РЕЗУЛЬТАТЫ ТЕСТОВ ===\n");

        for (int i = 1; i <= 100; i++) {
            String status;

            if (i % 3 == 0 && i % 5 == 0) {
                status = "Critical!";
                criticalCount++;
            } else if (i % 3 == 0) {
                status = "Flaky";
                flakyCount++;
            } else if (i % 5 == 0) {
                status = "Bug";
                bugCount++;
            } else {
                status = "Pass";
                passCount++;
            }

            // Вывод с номером теста
            if (i == 1) {
                System.out.println("Тест " + i + ": " + status);
            } else {
                System.out.println("Тест #" + i + ": " + status);
            }
        }

        // Итоговая сводка
        System.out.println("\n===== ИТОГИ НОЧНОЙ СМЕНЫ =====");
        System.out.println("Всего тестов: 100");
        System.out.println("Pass: " + passCount);
        System.out.println("Flaky: " + flakyCount);
        System.out.println("Bug: " + bugCount);
        System.out.println("Critical: " + criticalCount);
    }
}