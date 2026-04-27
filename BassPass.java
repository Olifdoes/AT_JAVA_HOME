import java.util.Arrays;

class Bassket {
    public static void main(String[] args) {

        String[] petya = {"курица", "бананы", "творог"};
        String[] kolya = {"курица", "бананы", "творог"};
        String[] terentiy = {"пиво", "пельмени", "ласка магия черного"};

        //Сравниваю по количеству
        System.out.println("Петя и Коля (количество): " + (petya.length == kolya.length));
        System.out.println("Петя и Терентий (количество): " + (petya.length == terentiy.length));

        //Сравниваю по составу
        System.out.println("Петя и Коля (состав): " + Arrays.equals(petya, kolya));
        System.out.println("Петя и Терентий (состав): " + Arrays.equals(petya, terentiy));

        //Объединяю все товары
        String[] allProducts = new String[petya.length + kolya.length + terentiy.length];

        int index = 0;

        for (String item : petya) {
            allProducts[index++] = item;
        }
        for (String item : kolya) {
            allProducts[index++] = item;
        }
        for (String item : terentiy) {
            allProducts[index++] = item;
        }

        //Ищу слово по длинне
        String longest = allProducts[0];
        String shortest = allProducts[0];

        int totalLength = 0;

        for (String product : allProducts) {
            totalLength += product.length();

            if (product.length() > longest.length()) {
                longest = product;
            }
            if (product.length() < shortest.length()) {
                shortest = product;
            }
        }

        double averageLength = (double) totalLength / allProducts.length;

        //Вывод
        System.out.println("Самое длинное название: " + longest);
        System.out.println("Самое короткое название: " + shortest);
        System.out.println("Средняя длина: " + averageLength);
    }
}

class Pass {
    public static void main(String[] args) {
        String[] passwords = {"SolnecHn_Ytr0", " @JL?zW%yg%23", "56Qb:=JYFC!"};

        for (String password : passwords) {
            boolean valid = password.length() > 8
                    && !password.startsWith("1")
                    && !password.endsWith("z")
                    && !password.contains("1234")
                    && !password.contains("qwerty");

            System.out.println("Пароль: '" + password + "'");
            System.out.println("Длина: " + password.length() + " символов");
            System.out.println("Результат проверки: " + (valid ? "✅ Прошёл" : "❌ Не прошёл"));
            System.out.println("-----------------------------------");
        }
    }
}