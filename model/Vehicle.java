package ir.maktab58.model;

public class Vehicle {
    private int vehicleId;
    private Driver driver;
    private String name;
    private String model;
    private String color;
    private String capacity;
    private String plateNumber;
    private KindofVehicle kindofVehicle;


    public Vehicle() {
    }

    public Vehicle(int vehicleId, Driver driver, String name, String model, String color, String capacity, String plateNumber, KindofVehicle kindofVehicle) {
        this.vehicleId = vehicleId;
        this.driver = driver;
        this.name = name;
        this.model = model;
        this.color = color;
        this.capacity = capacity;
        this.plateNumber = plateNumber;
        this.kindofVehicle = kindofVehicle;
    }

    public Vehicle(String name, String model, String color, String capacity, String plateNumber, KindofVehicle kindofVehicle) {
        this.name = name;
        this.model = model;
        this.color = color;
        this.capacity = capacity;
        this.plateNumber = plateNumber;
        this.kindofVehicle = kindofVehicle;
    }


    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }


    public KindofVehicle getKindofVehicle() {
        return kindofVehicle;
    }

    public void setKindofVehicle(KindofVehicle kindofVehicle) {
        this.kindofVehicle = kindofVehicle;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "carId=" + vehicleId +
                ", DriverId=" + driver +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", capacity='" + capacity + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }

}