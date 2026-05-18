package delivery.app.service;

import delivery.app.model.Parcel;

public class ParcelService {

    public void printParcelsReport(Parcel[] parcels) {
        for (Parcel parcel : parcels) {
            parcel.printInfo();
            System.out.printf("Delivery price: %.2f%n", parcel.calculateDeliveryPrice());
            System.out.println("-------------------------------");
            System.out.println(); // пустая строка-разделитель
        }
    }
}