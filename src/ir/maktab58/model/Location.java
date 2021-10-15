package ir.maktab58.model;

public class Location {
    private int origin;
    private int destination;

    public Location(int origin, int destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Location(int origin) {
        this.origin = origin;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
}
