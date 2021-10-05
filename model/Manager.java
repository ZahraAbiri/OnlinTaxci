package ir.maktab58.model;
import ir.maktab58.dataAccess.CarsDatabaseAccess;
import ir.maktab58.dataAccess.DriverDatabaseAccess;
import ir.maktab58.dataAccess.PassengerDatabaseAccess;
import java.sql.SQLException;

public class Manager {
    Driver driver = new Driver();
    Passenger passenger = new Passenger();
    DriverDatabaseAccess driverDatabaseAccess = new DriverDatabaseAccess();
    PassengerDatabaseAccess passengerDatabaseAccess = new PassengerDatabaseAccess();
    CarsDatabaseAccess carsDatabaseAccess = new CarsDatabaseAccess();
    boolean drivercheck;
    boolean passengercheck;

    public Manager() throws SQLException {
    }

    public void addDriver(String name, String family, String nationalcode, String phoneNumber) throws SQLException {
        driver.setName(name);
        driver.setFamily(family);
        driver.setNationalcode(nationalcode);
        driver.setPhoneNumber(phoneNumber);
        driverDatabaseAccess.save(driver);
    }

    public void addCar(String name, String model, String color, String capacity, String plateNumber) throws SQLException {
        Cars car = new Cars();
//        car.setDriverId(driverId);
        car.setName(name);
        car.setCapacity(capacity);
        car.setModel(model);
        car.setColor(color);
        car.setPlateNumber(plateNumber);
        carsDatabaseAccess.save(car);
    }

    public void addPassenger(String name, String family, String nationalcode, String phoneNumber, int money) throws SQLException {
        passenger.setName(name);
        passenger.setFamily(family);
        passenger.setNationalcode(nationalcode);
        passenger.setPhoneNumber(phoneNumber);
        passenger.setTravelStatuse("start");
        passenger.setFirstMoney(money);
        passengerDatabaseAccess.save(passenger);
    }

    public void printDriversInfo() throws SQLException {
        driverDatabaseAccess.printDriversInfo();
    }

    public void printPassengerInfo() throws SQLException {
        passengerDatabaseAccess.printPasengerInfo();
    }

    public void printCarInfo() throws SQLException {
        carsDatabaseAccess.printcarInfo();
    }

    public boolean checkPassenger(String nationalcode) throws SQLException {
        passengercheck = passengerDatabaseAccess.checkPassenger(nationalcode);
        return passengercheck;
    }

    public boolean printDriver(String nationalcode) throws SQLException {
        drivercheck = driverDatabaseAccess.checkDriver(nationalcode);
        return drivercheck;
    }

    public int increaseMoney(int money,String nationalcode) throws SQLException {
       int firstMoney= passengerDatabaseAccess.getpassengerFirstMoney(nationalcode);
        int newMoney = money;
        newMoney += firstMoney;
        passenger.setFirstMoney(newMoney);
        passengerDatabaseAccess.seveIncreseMoney(newMoney,nationalcode);
        return newMoney;
    }


}

