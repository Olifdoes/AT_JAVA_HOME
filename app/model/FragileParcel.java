package delivery.app.model;

public class FragileParcel extends Parcel {

    private boolean requiresCarefulHandling;

    public FragileParcel(String recipientName, String deliveryAddress,
                         double weight, String trackNumber, boolean requiresCarefulHandling) {
        super(recipientName, deliveryAddress, weight, trackNumber);
        this.requiresCarefulHandling = requiresCarefulHandling;
    }

    @Override
    public double calculateDeliveryPrice() {
        return super.calculateDeliveryPrice() + 200;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Handle with care: " + requiresCarefulHandling);
    }
}