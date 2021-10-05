package ir.maktab58.model;

public class Driver {
    private int driverId;
    private String name;
    private String family;
    private String nationalcode;
    private String phoneNumber;
    private int carId;
    private Cars car;


    public Driver() {
    }

    public Driver( String name, String family, String nationalcode, String phoneNumber,  Cars car) {

        this.name = name;
        this.family = family;
        this.nationalcode = nationalcode;
        this.phoneNumber = phoneNumber;
        this.car = car;
    }


    public Driver(int driverId, String name, String family, String nationalcode, String phoneNumber, int carId) {
        this.driverId = driverId;
        this.name = name;
        this.family = family;
        this.nationalcode = nationalcode;
        this.phoneNumber = phoneNumber;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNationalcode() {
        return nationalcode;
    }

    public void setNationalcode(String nationalcode) {
        this.nationalcode = nationalcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "DriverId=" + driverId +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", nationalcode='" + nationalcode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", carId=" + carId +
                '}';
    }
}
