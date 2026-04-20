import java.util.Random;
import java.util.Scanner;

public class BChigan {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Генерация
        int minAge = 0;
        int maxAge = 100;
        int age = minAge + random.nextInt(maxAge - minAge + 1);

        double balance = random.nextDouble() * 100000;

        // 70% шанс, что есть приглашение
        boolean hasInvitation = random.nextDouble() < 0.7;

        // 20% шанс попасть в черный список
        boolean isBlacklisted = random.nextDouble() < 0.2;

        // Логика
        boolean isAdult = age >= 18;
        boolean hasAccessByMoney = balance > 50000;
        boolean hasAccess = hasInvitation || hasAccessByMoney;
        boolean isAllowed = isAdult && hasAccess && !isBlacklisted;

        // Красивый вывод
        System.out.println("\n--- ДАННЫЕ ПОСЕТИТЕЛЯ ---");
        System.out.println("Возраст: " + age);
        System.out.printf("Баланс: %.2f\n", balance);
        System.out.println("Приглашение: " + hasInvitation);
        System.out.println("Черный список: " + isBlacklisted);

        System.out.println("\n--- РЕЗУЛЬТАТ ---");
        System.out.println("Допуск: " + isAllowed);

        // Взнос считаем ТОЛЬКО если 18+
        if (isAdult) {
            double contribution = balance * 0.075;
            System.out.printf("Обязательный добровольный взнос: %.2f\n", contribution);
        } else {
            System.out.println("Посетителям младше 18 взнос и доступ запрещен.");
        }

        scanner.close();
    }
}