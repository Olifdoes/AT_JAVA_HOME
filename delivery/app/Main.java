package delivery.app;

import delivery.model.Parcel;
import delivery.model.FragileParcel;
import delivery.model.ExpressParcel;
import delivery.service.ParcelService;

public class Main {

    public static void main(String[] args) {

        Parcel parcel = new Parcel(
                "Ivan Ivanov",
                "Moscow",
                2.5,
                "TR123"
        );

        Parcel fragileParcel = new FragileParcel(
                "Anna Petrova",
                "Saint Petersburg",
                1.2,
                "FR456",
                true
        );

        Parcel expressParcel = new ExpressParcel(
                "Oleg Smirnov",
                "Kazan",
                3.0,
                "EX789",
                12
        );

        Parcel emptyParcel = new Parcel();

        emptyParcel.setRecipientName("Test User");
        emptyParcel.setDeliveryAddress("Sochi");
        emptyParcel.setWeight(4.5);

        Parcel[] parcels = {
                parcel,
                fragileParcel,
                expressParcel,
                emptyParcel
        };

        ParcelService service = new ParcelService();

        service.printParcelsReport(parcels);
    }
}