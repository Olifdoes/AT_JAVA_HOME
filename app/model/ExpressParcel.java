package delivery.app.model;

public class ExpressParcel extends Parcel {

    private int deliveryHours;

    public ExpressParcel(String recipientName, String deliveryAddress,
                         double weight, String trackNumber, int deliveryHours) {
        super(recipientName, deliveryAddress, weight, trackNumber);
        this.deliveryHours = deliveryHours;
    }

    @Override
    public double calculateDeliveryPrice() {
        double basePrice = super.calculateDeliveryPrice();
        if (deliveryHours < 24) {
            return basePrice + 500;
        }
        return basePrice;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Delivery deadline: " + deliveryHours + " hours");
    }
}