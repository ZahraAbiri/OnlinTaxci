package ir.maktab58.model;

import java.util.List;

public class Passenger extends Person{
    private int passengerId;
    private TravelStatuse travelStatuse;
    private int firstMoney;
    private List<Driver> driver;

    public Passenger(String name, String family, int age, String nationalcode, String username, String phoneNumber, int passengerId, TravelStatuse travelStatuse, int firstMoney, List<Driver> driver) {
        super(name, family, age, nationalcode, username, phoneNumber);
        this.passengerId = passengerId;
        this.travelStatuse = travelStatuse;
        this.firstMoney = firstMoney;
        this.driver = driver;
    }

    public List<Driver> getDriver() {
        return driver;
    }

    public void setDriver(List<Driver> driver) {
        this.driver = driver;
    }

    public Passenger() {

    }

    public Passenger(String name, String family, int age, String nationalcode, String username, String phoneNumber, Location location, int passengerId, TravelStatuse travelStatuse, int firstMoney) {
        super(name, family, age, nationalcode, username, phoneNumber, location);
        this.passengerId = passengerId;
        this.travelStatuse = travelStatuse;
        this.firstMoney = firstMoney;
    }

    public Passenger(String name, String family, int age, String nationalcode, String username, String phoneNumber,
                     int money, TravelStatuse travelStatuse, Location location) {
        super(name, family, age, nationalcode, username, phoneNumber, location);
        this.travelStatuse = travelStatuse;
        this.firstMoney = money;

    }

    public long getFirstMoney() {
        return firstMoney;
    }

    public void setFirstMoney(int firstMoney) {
        this.firstMoney = firstMoney;
    }

    public TravelStatuse getTravelStatuse() {
        return travelStatuse;
    }

    public void setTravelStatuse(TravelStatuse travelStatuse) {
        this.travelStatuse = travelStatuse;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }


    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", travelStatuse=" + travelStatuse +
                ", firstMoney=" + firstMoney +
                "} " + super.toString();
    }
}
