package ir.maktab58.model;
import ir.maktab58.Exception.DuplicateUserNameException;
import ir.maktab58.Exception.InvalidInputException;
import ir.maktab58.dataAccess.CarsDatabaseAccess;
import ir.maktab58.dataAccess.DriverDatabaseAccess;
import ir.maktab58.dataAccess.PassengerDatabaseAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    Passenger passenger = new Passenger();
    DriverDatabaseAccess driverDatabaseAccess = new DriverDatabaseAccess();
    PassengerDatabaseAccess passengerDatabaseAccess = new PassengerDatabaseAccess();
    CarsDatabaseAccess carsDatabaseAccess = new CarsDatabaseAccess();
    RegexLimitation regex;
    List<Driver> drivers = new ArrayList<>();
    List<Passenger> passengers = new ArrayList<>();
    Driver driver;
    boolean drivercheck;
    boolean passengercheck;
    public Manager() throws SQLException {
    }
    public void findBynearOrigin(int origin,int destination) throws Exception {
        drivers=driverDatabaseAccess.findAllDrivers();
        for (Driver driver:drivers) {
            if (driverOrigin(driver.getNationalcode())<= origin) {
                System.out.println(driver.getName());
                changeDriverLocation(destination,driver.getNationalcode());
                updateTravelDriverStatus(TravelStatuse.START, driver.getNationalcode());
                break;
            }
        }
    }
    public int driverOrigin(String nationalcode) throws SQLException {
        return driverDatabaseAccess.getDriverorigin(nationalcode);
    }

    public Driver addDriver(String name, String family, int age, String nationalcode, String username, String phoneNumber, Location location, TravelStatuse travelStatuse) throws SQLException {
        try {
            if (validateInfo(name, family, age, nationalcode, username, phoneNumber)) {
                driver = new Driver(name, family, age, nationalcode, username, phoneNumber, location,travelStatuse);
                if (!isDriverExsist(driver)) {
                    driverDatabaseAccess.save(driver);
                    drivers.add(driver);
                    System.out.println(" now Enter car information : name,model,color,capacity,plateNumber");
                    addCar(RegexLimitation.paternString(), RegexLimitation.paternString(), RegexLimitation.paternString(),
                            RegexLimitation.paternString(), RegexLimitation.paternString(), KindofVehicle.CAR.setShortcut("CAR"));
                }
            }
        } catch (InvalidInputException | DuplicateUserNameException e) {
            System.out.println(e.getMessage());
        }
        return driver;
    }

    private boolean isDriverExsist(Driver driver) throws DuplicateUserNameException, SQLException {
        Driver found = driverDatabaseAccess.findByNationalCodeOrUserName(driver.getNationalcode());
        if (found == null) {
            return false;
        }
        throw new DuplicateUserNameException("Nationalcode id duplicate");
    }

    private boolean isPassengerExsist(Passenger passenger) throws DuplicateUserNameException, SQLException {
        Passenger found = passengerDatabaseAccess.findByNationalCodeOrUserName(passenger.getNationalcode());
        if (found == null) {
            return false;
        }
        throw new DuplicateUserNameException("Nationalcode id duplicate");
    }
    public void addCar(String name, String model, String color, String capacity, String plateNumber, KindofVehicle kindofVehicle) throws SQLException {
        Vehicle car = new Vehicle(name, model, color, capacity, plateNumber, kindofVehicle);
        carsDatabaseAccess.save(car);
    }

    public void addPassenger(String name, String family, int age, String nationalcode, String username,
                             String phoneNumber, int money, TravelStatuse travelStatuse, Location location) throws SQLException {
        try {
            if (validateInfo(name, family, age, nationalcode, username, phoneNumber)) {
                Passenger passenger = new Passenger(name, family, age, nationalcode, username, phoneNumber, money, travelStatuse, location);

                if (!isPassengerExsist(passenger)) {
                    passengerDatabaseAccess.save(passenger);
                    passengers.add(passenger);
                }
            }
        } catch (InvalidInputException | DuplicateUserNameException e) {
            System.out.println(e.getMessage());
        }
    }
    public void printDriversInfo() throws SQLException {
        driverDatabaseAccess.printDriversInfo();
    }
    public void printPassengerInfo() throws SQLException {
        passengerDatabaseAccess.printPasengerInfo();
    }
    public void printCarInfo() throws SQLException {
        carsDatabaseAccess.findAllvehicles();
    }
    public boolean checkPassenger(String nationalcode) throws SQLException {
        passengercheck = passengerDatabaseAccess.checkPassenger(nationalcode);
        return passengercheck;
    }
    public boolean checkDriver(String nationalcode) throws SQLException {
        passengercheck = driverDatabaseAccess.checkDriver(nationalcode);
        return passengercheck;
    }
    public boolean printDriver(String nationalcode) throws SQLException {
        drivercheck = driverDatabaseAccess.checkDriver(nationalcode);
        return drivercheck;
    }
    public int increaseMoney(int money, String nationalcode) throws SQLException {
        int firstMoney = passengerDatabaseAccess.getpassengerFirstMoney(nationalcode);
        int newMoney = money;
        newMoney += firstMoney;
        passenger.setFirstMoney(newMoney);
        passengerDatabaseAccess.seveIncreseMoney(newMoney, nationalcode);
        return newMoney;
    }
    public int money(String nationalcode) throws SQLException {
        return passengerDatabaseAccess.getpassengerFirstMoney(nationalcode);
    }
    public int decreaseMoney(int cost, String nationalcode) throws SQLException {
        int money = passengerDatabaseAccess.getpassengerFirstMoney(nationalcode);
        int newMoney = cost;
        money -= cost;
        passenger.setFirstMoney(money);
        passengerDatabaseAccess.seveIncreseMoney(money, nationalcode);
        return money;
    }
    private boolean validateInfo(String name, String family, int age, String nationalcode, String username, String phoneNumber) throws InvalidInputException {
        return validateNationalcode(nationalcode) && validateFulName(name, family) && validatephone(phoneNumber);
    }

    private boolean validatephone(String phoneNumber) throws InvalidInputException {
        if (phoneNumber.startsWith("09") && phoneNumber.length() == 11 && phoneNumber.matches("[0-9]{11}")) {
            return true;
        }
        throw new InvalidInputException("phoneNumber is not valid");
    }

    private boolean validateFulName(String name, String family) throws InvalidInputException {
        if (name != null && name.matches("[A-Za-z]+")
                && family != null && family.matches("[A-Za-z]+")) {
            return true;
        }
        throw new InvalidInputException("name or family is not valid the lenght should more than 3");
    }

    private boolean validateNationalcode(String nationalcode) throws InvalidInputException {
        if (nationalcode != null && nationalcode.length() == 10 && nationalcode.matches("[0-9]{10}")) {
            return true;
        }
        throw new InvalidInputException("natinalcode");
    }

    public void printOngoingTravel() throws SQLException {
        drivers=driverDatabaseAccess.findAllDrivers();
        for (Driver driver : drivers) {
            System.out.println("diver"+driver);
           passengers=passengerDatabaseAccess.findAllPassenger();
            for (Passenger passenger : passengers) {
                System.out.println("passenger"+passenger.getName());
                System.out.println("passenger"+passenger.getFamily());
            }
        }
    }
    public int calculateDistance(int origin,int destination) {
        int result = (destination - origin) * 1000;
        return result;
    }
    public void changeDriverLocation(int destination, String nationalcode) throws SQLException {
        driverDatabaseAccess.updateDriverLocation(destination,nationalcode);
    }

    public void updateTravelDriverStatus(TravelStatuse travelStatuse, String nationalcode) throws SQLException {
        driverDatabaseAccess.UpdateTravelStatus(travelStatuse, nationalcode);
    }

    public void updateTravelPassengerStatus(TravelStatuse travelStatuse, String nationalcode) throws SQLException {
        passengerDatabaseAccess.UpdateTravelStatus(travelStatuse, nationalcode);
    }
    public String checkDriverTravelStatus( String nationalcode) throws SQLException {
        String statuse=driverDatabaseAccess.checkDriverTravelStatus(nationalcode);
        return statuse;
    }
    public int PassengerDistance(String nationalcode) throws SQLException {

        return passengerDatabaseAccess.getpassengerdestination(nationalcode);
    }
    public int PassengerOrigin(String nationalcode) throws SQLException {

        return passengerDatabaseAccess.getpassengerorigin(nationalcode);
    }

}

