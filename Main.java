import java.time.LocalDate;
import java.util.Random;

public class Main {

    // Протокол ГЕНЕРАТОР
    // доступен другим классам
    public static String generateAccessCode() {
        String year = String.valueOf(LocalDate.now().getYear());
        int number = (int) Math.pow(3, 7);

        return year + "-" + number;
    }

    // Протокол ВАЛИДАТОР
    // скрыт от других классов
    private static boolean isValidCode(String code, int minLength) {
        return code != null
                && code.length() >= minLength
                && code.contains("-");
    }

    // Протокол ЛОГГЕР
    // доступны другим классам
    public static void logEvent(String message) {
        System.out.println("[INFO] " + message);
    }

    public static void logEvent(String message, boolean isCritical) {
        if (isCritical) {
            System.out.println("[CRITICAL] " + message);
        } else {
            logEvent(message);
        }
    }

    // Протокол РАНДОМАЙЗЕР
    // доступен другим классам
    public static String generateAgentId(String prefix, int seed) {
        Random random = new Random(seed);

        int number = random.nextInt(9000) + 1000;

        return prefix + "-" + number;
    }

    // Протокол ДАШБОРД
    public static void main(String[] args) {

        // Генерация кода доступа
        String code = generateAccessCode();

        // Проверка кода
        boolean isValid = isValidCode(code, 8);
        System.out.println("Code valid: " + isValid);

        // Логирование событий
        logEvent("Server protection activated");
        logEvent("Intrusion attempt detected", true);

        // Генерация ID агентов
        System.out.println(generateAgentId("AGENT", 42));
        System.out.println(generateAgentId("AGENT", 77));
        System.out.println(generateAgentId("AGENT", 13));
    }
}