package ir.maktab58.model;

public class Driver extends Person {
    private int driverId;
    private Vehicle car;

    public Driver(String name, String family, int age, String nationalcode, String username, String phoneNumber) {
        super(name, family, age, nationalcode, username, phoneNumber);
    }

    public Driver(String name, String family, int age, String nationalcode, String username, String phoneNumber, int driverId, Vehicle car) {
        super(name, family, age, nationalcode, username, phoneNumber);
        this.driverId = driverId;
        this.car = car;
    }

    public Driver() {
        super();
    }


    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }


}
