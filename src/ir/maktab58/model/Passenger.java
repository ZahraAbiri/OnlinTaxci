package ir.maktab58.model;

public class Passenger extends Person{
    private int passengerId;
    private TravelStatuse travelStatuse;
    private int firstMoney;

    public Passenger(String name, String family,int age, String nationalcode, String username, String phoneNumber) {
        super(name, family,age, nationalcode, username, phoneNumber);
    }

    public Passenger(String name, String family,int age, String nationalcode, String username, String phoneNumber, int passengerId, TravelStatuse travelStatuse, int firstMoney) {
        super(name, family,age, nationalcode, username, phoneNumber);
        this.passengerId = passengerId;
        this.travelStatuse = travelStatuse;
        this.firstMoney = firstMoney;
    }

    public Passenger() {

    }

    public Passenger(String name, String family, int age, String nationalcode, String username, String phoneNumber, int firstMoney, TravelStatuse travelStatuse) {
        super(name,family,age,nationalcode,username,phoneNumber);
        this.travelStatuse = travelStatuse;
        this.firstMoney = firstMoney;
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
                ", travelStatuse='" + travelStatuse + '\'' +
                ", firstMoney=" + firstMoney +
                '}';
    }
//    CREATE TABLE `taxi`.`passenger` (
//            `passengerId` INT NOT NULL AUTO_INCREMENT,
//  `name` VARCHAR(45) NOT NULL,
//  `family` VARCHAR(45) NOT NULL,
//  `age` INT NOT NULL,
//            `nationalcode` VARCHAR(45) NOT NULL,
//  `username` VARCHAR(45) NOT NULL,
//  `phoneNumber` VARCHAR(45) NOT NULL,
//  `TravelStatuse` ENUM('WATING', 'START', 'CANCEL', 'FINISHED') NOT NULL,
//    PRIMARY KEY (`passengerId`));
}
