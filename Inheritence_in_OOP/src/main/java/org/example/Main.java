import java.util.Random;

class Device {
    private String type;
    private double price;
    private double weight;

    public Device(String type, double price, double weight) {
        this.type = type;
        this.price = price;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class Smartphone extends Device {
    private double screenSize;
    private int cameraResolution;

    public Smartphone(String type, double price, double weight, double screenSize, int cameraResolution) {
        super(type, price, weight);
        this.screenSize = screenSize;
        this.cameraResolution = cameraResolution;
    }

}


class Laptop extends Device {
    private String processor;
    private int memoryGB;

    public Laptop(String type, double price, double weight, String processor, int memoryGB) {
        super(type, price, weight);
        this.processor = processor;
        this.memoryGB = memoryGB;
    }


}


class Tablet extends Device {
    private String operatingSystem;
    private boolean hasKeyboard;

    public Tablet(String type, double price, double weight, String operatingSystem, boolean hasKeyboard) {
        super(type, price, weight);
        this.operatingSystem = operatingSystem;
        this.hasKeyboard = hasKeyboard;
    }


}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int numOfDevices;


        numOfDevices = 5;


        Device[] devices = new Device[numOfDevices];

        for (int i = 0; i < numOfDevices; i++) {
            int randomDeviceType = random.nextInt(3);

            if (randomDeviceType == 0) {
                devices[i] = new Smartphone("Smartphone", random.nextDouble() * 1000, random.nextDouble() * 1000, random.nextDouble() * 6, random.nextInt(12));
            } else if (randomDeviceType == 1) {
                devices[i] = new Laptop("Laptop", random.nextDouble() * 1500, random.nextDouble() * 2000, "Intel i" + (random.nextInt(10) + 3), random.nextInt(32));
            } else {
                devices[i] = new Tablet("Tablet", random.nextDouble() * 800, random.nextDouble() * 800, "Android", random.nextBoolean());
            }
        }

        double totalPrice = 0;
        double totalWeight = 0;

        int distinctTypes = 0;
        for (Device device : devices) {
            totalPrice += device.getPrice();
            totalWeight += device.getWeight();
        }

        System.out.println("Number of distinct device types created: " + distinctTypes);
        System.out.println("Total price of all devices: $" + totalPrice);
        System.out.println("Total weight of all devices: " + totalWeight + " grams");
    }
}
