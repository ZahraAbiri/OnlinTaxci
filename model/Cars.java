package ir.maktab58.model;

public class Cars {
    private int carId;
    private int driverId;
    private String name;
    private String model;
    private String color;
    private String capacity;
    private String plateNumber;
    private KindofVehicle kindofVehicle;


    public Cars() {
    }

    public Cars(int carId, int driverId, String name, String model, String color, String capacity, String plateNumber, KindofVehicle kindofVehicle) {
        this.carId = carId;
        this.driverId = driverId;
        this.name = name;
        this.model = model;
        this.color = color;
        this.capacity = capacity;
        this.plateNumber = plateNumber;
        this.kindofVehicle = kindofVehicle;
    }


    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
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
                "carId=" + carId +
                ", DriverId=" + driverId +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", capacity='" + capacity + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }

}