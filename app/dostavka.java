package delivery.app;

import delivery.app.model.Parcel;
import delivery.app.model.FragileParcel;
import delivery.app.service.ParcelService;

public class dostavka {

    public static void main(String[] args) {

        // Обычная посылка
        Parcel parcel = new Parcel(
                "Ivan Ivanov",
                "Moscow",
                2.5,
                "TR123"
        );

        // Хрупкая посылка
        FragileParcel fragileParcel = new FragileParcel(
                "Anna Petrova",
                "Saint Petersburg",
                1.2,
                "FR456",
                true
        );

        // Экспресс-посылка
        Parcel expressParcel = new Parcel(
                "Oleg Smirnov",
                "Kazan",
                3.0,
                "EX789",
                12
        );

        // Посылка через пустой конструктор
        Parcel emptyParcel = new Parcel("Oleg Smirnov", "Kazan", 3.0, "EX789", 12);

        emptyParcel.setRecipientName("Test User");
        emptyParcel.setDeliveryAddress("Sochi");
        emptyParcel.setWeight(4.5);

        // Массив посылок
        Parcel[] parcels = {
                parcel,
                fragileParcel,
                expressParcel,
                emptyParcel
        };

        // Сервис
        ParcelService service = new ParcelService();

        // Отчет
        service.printParcelsReport(parcels);
    }
}