package delivery.model;

public class Parcel {

    private String recipientName;
    private String deliveryAddress;

    protected double weight;

    String trackingNumber;

    // Конструктор без параметров
    public Parcel() {
    }

    // Конструктор с параметрами
    public Parcel(String recipientName,
                  String deliveryAddress,
                  double weight,
                  String trackingNumber) {

        this.recipientName = recipientName;
        this.deliveryAddress = deliveryAddress;
        this.weight = weight;
        this.trackingNumber = trackingNumber;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculateDeliveryPrice() {
        return 100 + weight * 30;
    }

    public void printInfo() {
        System.out.println("Recipient: " + recipientName);
        System.out.println("Address: " + deliveryAddress);
        System.out.println("Weight: " + weight);
        System.out.println("Tracking number: " + trackingNumber);
    }
}