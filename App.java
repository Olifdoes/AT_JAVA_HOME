public class App {
    public static void main(String[] args) {
        String employeeName = "Дорбэк";
        String role = "Шаурмист-универсал";

        double rublPerShift = 4000.0;
        int numSmen = 20;
        double rublPrem = 3000.0;
        double firePita = 800.0;

        double shaurmaCost = 350.0; 
        int shaurmaSold = 2100; 

        double muddySalary = numSmen * rublPerShift;
        double clearSalary = muddySalary + rublPrem - firePita;
        double profit = shaurmaSold * shaurmaCost;

     
        System.out.println("Сотрудник: " + employeeName);
        System.out.println("Должность: " + role);
        System.out.println("Оплата за смены: " + (int) muddySalary + " руб");
        System.out.println("Сингулярная Премия: " + (int) rublPrem + " руб");
        System.out.println("Штраф за сгоревший лаваш: " + (int) firePita + " руб");
        System.out.println("Итоговая зарплата: " + (int) clearSalary + " руб");
        System.out.println("Лишь шаурма-а-а-а на углях, ой, профит с точки: " + (int) profit + " руб");
    }
}