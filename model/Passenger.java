package ir.maktab58.model;

public class Passenger {
    private int passengerId;
    private String name;
    private String family;
    private String nationalcode;
    private String phoneNumber;
    private Account account;
    private String travelStatuse;
    private int firstMoney;

    public Passenger(int passengerId, String name, String family, String nationalcode, String phoneNumber, String travelStatuse, int firstMoney) {
        this.passengerId = passengerId;
        this.name = name;
        this.family = family;
        this.nationalcode = nationalcode;
        this.phoneNumber = phoneNumber;
        this.travelStatuse = travelStatuse;
        this.firstMoney = firstMoney;
    }

    public Passenger(String name, String family, String nationalcode, String phoneNumber, String travelStatuse, int firstMoney) {
        this.name = name;
        this.family = family;
        this.nationalcode = nationalcode;
        this.phoneNumber = phoneNumber;
        this.travelStatuse = travelStatuse;
        this.firstMoney = firstMoney;
    }

    public Passenger(String name, String family, String nationalcode, String phoneNumber, Account account, String travelStatuse) {

        this.name = name;
        this.family = family;
        this.nationalcode = nationalcode;
        this.phoneNumber = phoneNumber;

        this.account = account;
        this.travelStatuse = travelStatuse;
    }

    public Passenger() {
    }

    public Passenger(String name, String family, String nationalcode, String phoneNumber, Account account) {

        this.name = name;
        this.family = family;
        this.nationalcode = nationalcode;
        this.phoneNumber = phoneNumber;
        this.account = account;

    }

    public long getFirstMoney() {
        return firstMoney;
    }

    public void setFirstMoney(int firstMoney) {
        this.firstMoney = firstMoney;
    }

    public String getTravelStatuse() {
        return travelStatuse;
    }

    public void setTravelStatuse(String travelStatuse) {
        this.travelStatuse = travelStatuse;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", nationalcode='" + nationalcode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", account=" + account +
                ", travelStatuse=" + travelStatuse +
                '}';
    }


}
