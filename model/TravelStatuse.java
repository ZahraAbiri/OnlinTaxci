package ir.maktab58.model;

public enum TravelStatuse {
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

    public String setShortcut(String shortcut) {
        this.shortcut = shortcut;
        return shortcut;
    }
}
