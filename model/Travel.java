package ir.maktab58.model;

public class Travel {
    private int travelId;
    private String origin;
    private String destination;
    private TravelStatuse travelStatuse;
    public Travel() {
    }

    public Travel(int travelId, String origin, String destination, TravelStatuse travelStatuse) {
        this.travelId = travelId;
        this.origin = origin;
        this.destination = destination;
        this.travelStatuse = travelStatuse;
    }

    public int getTravelId() {
        return travelId;
    }

    public void setTravelId(int travelId) {
        this.travelId = travelId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public TravelStatuse getTravelStatuse() {
        return travelStatuse;
    }

    public void setTravelStatuse(TravelStatuse travelStatuse) {
        this.travelStatuse = travelStatuse;
    }
}
