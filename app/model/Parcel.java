package delivery.app.model;

public class Parcel {

    private String recipientName;
    private String deliveryAddress;
    protected double weight;
    String trackNumber; // package-private (default)

    // Конструктор с параметрами
    public Parcel(String recipientName, String deliveryAddress, double weight, String trackNumber) {
        this.recipientName = recipientName;
        this.deliveryAddress = deliveryAddress;
        this.weight = weight;
        this.trackNumber = trackNumber;
    }

    // Конструктор без параметров
    public Parcel(String olegSmirnov, String kazan, double v, String ex789, int i) {
    }

    // Геттеры и сеттеры
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
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Track number: " + trackNumber);
    }
}