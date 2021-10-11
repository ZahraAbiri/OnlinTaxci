package ir.maktab58.model;

public class Travel {
    private int travelId;
    private Location origin;
    private Location destination;
    private TravelStatuse travelStatuse;
    private Driver driver;
    private Passenger passenger;
    public Travel() {
    }

    public Travel(int travelId, Location origin, Location destination, TravelStatuse travelStatuse, Driver driver, Passenger passenger) {
        this.travelId = travelId;
        this.origin = origin;
        this.destination = destination;
        this.travelStatuse = travelStatuse;
        this.driver = driver;
        this.passenger = passenger;
    }

    public int getTravelId() {
        return travelId;
    }

    public void setTravelId(int travelId) {
        this.travelId = travelId;
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public TravelStatuse getTravelStatuse() {
        return travelStatuse;
    }

    public void setTravelStatuse(TravelStatuse travelStatuse) {
        this.travelStatuse = travelStatuse;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
