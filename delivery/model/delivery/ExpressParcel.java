package delivery.model;

public class ExpressParcel extends Parcel {

    private int deliveryHours;

    public ExpressParcel(String recipientName,
                         String deliveryAddress,
                         double weight,
                         String trackingNumber,
                         int deliveryHours) {

        super(recipientName, deliveryAddress, weight, trackingNumber);

        this.deliveryHours = deliveryHours;
    }

    @Override
    public double calculateDeliveryPrice() {

        double price = super.calculateDeliveryPrice();

        if (deliveryHours < 24) {
            price += 500;
        }

        return price;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Delivery deadline: " + deliveryHours + " hours");
    }
}