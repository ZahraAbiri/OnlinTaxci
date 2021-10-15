package ir.maktab58.model;

public enum KindofVehicle {
    CAR("CAT"), VAN("VAN"), MOTOR("MOTOR");

    private String shortcut;

    KindofVehicle(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getShortcut() {
        return shortcut;
    }

    public KindofVehicle setShortcut(String shortcut) {
        this.shortcut = shortcut;
        return KindofVehicle.CAR;
    }
}
