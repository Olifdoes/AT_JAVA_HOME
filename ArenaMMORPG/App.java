import ArenaMMORPG.Arena.heroes.*;

public class App {
    public static void main(String[] args) {
        Hero[] heroes = {
                new Knight("Артур", 15, 120, 80),
                new Archer("Леголас", 12, 80, 150),
                new Mage("Гэндальф", 20, 90, 200)
        };

        for (Hero hero : heroes) {
            hero.printInfo();
            hero.attack();
            System.out.println("-------------------");
        }

        Hero.printHeroesCreated();

        // Вишенка
        final Knight knight = new Knight("Сэр Ланселот", 25, 150, 95);
        System.out.println("\nДо изменения: " + knight);
        knight.setHealth(999);
        System.out.println("После изменения: " + knight);
    }
}