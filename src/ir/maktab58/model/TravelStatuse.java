package ir.maktab58.model;

public enum TravelStatuse {
    ONGOING("ongoing"),
    WAITING("waiting"),
    START("START"),
    CANCEL("CANCEL"),
    FINISHED("FINISHED");

    private String shortcut;

    TravelStatuse(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getShortcut() {
        return shortcut;
    }

    public TravelStatuse setShortcut(String shortcut) {
        this.shortcut = shortcut;
        return TravelStatuse.WAITING;
    }
}