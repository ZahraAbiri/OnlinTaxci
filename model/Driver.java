package ir.maktab58.model;
import java.util.List;
public class Driver extends Person {
    private int driverId;
    private Vehicle car;
    private List<Passenger> passenger;
    private TravelStatuse travelStatuse;
    public Driver(String name, String family, int age, String nationalcode, String username, String phoneNumber, Location location, int driverId, Vehicle car, TravelStatuse travelStatuse) {
        super(name, family, age, nationalcode, username, phoneNumber, location);
        this.driverId = driverId;
        this.car = car;
        this.travelStatuse = travelStatuse;
    }
    public Driver(String name, String family, int age, String nationalcode, String username, String phoneNumber, Location location,TravelStatuse travelStatuse) {
        super(name, family, age, nationalcode, username, phoneNumber, location);
        this.travelStatuse = travelStatuse;
    }
    public Driver() {
    }
    public TravelStatuse getTravelStatuse() {
        return travelStatuse;
    }
    public List<Passenger> getPassenger() {
        return passenger;
    }
    public void setPassenger(List<Passenger> passenger) {
        this.passenger = passenger;
    }
    public void setTravelStatuse(TravelStatuse travelStatuse) {
        this.travelStatuse = travelStatuse;
    }
    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", car=" + car +
                ", travelStatuse=" + travelStatuse +
                "} " + super.toString();
    }


}
