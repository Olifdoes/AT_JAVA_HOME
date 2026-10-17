import net.datafaker.Faker;
import com.github.lalyos.jfiglet.FigletFont;
import java.util.Random;

public class Naiming {
    public static void main(String[] args) throws Exception {
        // ========== Часть 1: Название-логотип ==========

        // 1. Массив фамилий (хотя бы 4)
        String[] surnames = {"Smith", "Johnson", "Williams", "Brown"};

        // 2. Три части названия компании
        String part1 = getRandomSurname(surnames);          // случайная фамилия из массива
        String part2 = "&";                                  // просто заданное значение
        Faker faker = new Faker();
        String part3 = faker.name().lastName();              // фамилия из datafaker

        // 3. Собираем название компании в одну строку (для наглядности)
        String companyName = part1 + " " + part2 + " " + part3;
        System.out.println("Название компании: " + companyName + "\n");

        // 4. Рисуем логотип: каждая из трёх частей — на новой строке, ASCII-графикой
        System.out.println(FigletFont.convertOneLine(part1));
        System.out.println(FigletFont.convertOneLine(part2));
        System.out.println(FigletFont.convertOneLine(part3));

        // ========== Часть 2: Юридические данные ==========
        System.out.println("\n--- Данные для регистрации ---");
        System.out.println("ФИО: " + faker.name().fullName());
        System.out.println("Телефон: " + faker.phoneNumber().phoneNumber());
        System.out.println("Адрес: " + faker.address().fullAddress());
    }

    // Метод: случайная фамилия из массива через Random
    public static String getRandomSurname(String[] array) {
        Random random = new Random();
        return array[random.nextInt(array.length)];
    }
}