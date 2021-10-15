package ir.maktab58;

import ir.maktab58.model.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static int choices = 0;
    static boolean choice = false;

    public static void welcome() {
        System.out.println("************Welcome to taxi reservation system****************");
        System.out.println(" ");
    }

    public static int chekChoice() {
        do {
            while (!input.hasNextInt()) {
                System.out.println("That's not a number! \n Enter number");
                input.next();
            }
            choices = input.nextInt();
            choice = true;
        } while (!choice);
        choice = false;
        return choices;
    }

    static Manager manager;
    static RegexLimitation regex;
    static Driver driver;
    static Passenger passenger;
    static int destination;
    static int origin;
    static boolean travelRequest;

    public static void main(String[] args) throws SQLException {
        int choiceDriver = 0;
        int manegerChoice;
        String nationalcodeDriver;
        String nationalcod;
        manager = new Manager();
        welcome();
        do {
            System.out.println("************Manager Menu****************");
            System.out.println("1.Add groups of dinner menu\n2.Add groups of passenger \n3.Driver login" +
                    "\n4.passenger login\n5.show list of driver\n6.show list of passenger\n7.show ongoing travel\n8.fished program");
            System.out.println("Select a Choice:");
            manegerChoice = chekChoice();
            switch (manegerChoice) {
                case 1:
                    System.out.println("number of driver you want to add");
                    int number = RegexLimitation.paternpatternNumber();
                    addGropuOfDrivers(number);
                    choice = false;
                    break;
                case 2:
                    System.out.println("number of passengers you want to add");
                    int numberPas = RegexLimitation.paternpatternNumber();
                    addGroupOfPassengers(numberPas);
                    choice = false;
                    break;
                case 3:
                    System.out.println("enter nationalcode");
                    nationalcodeDriver = RegexLimitation.paternNationalcode();
                    boolean result = manager.checkDriver(nationalcodeDriver);
                    if (!result) {
                        System.out.println("enter choice\n1.register\n2.exit");
                        choiceDriver = chekChoice();
                        if (choiceDriver == 1) {
                            System.out.println("name,family,nationalcode,phoneNumber,origin,destination");
                            manager.addDriver(RegexLimitation.paternString(), RegexLimitation.paternString(), RegexLimitation.paternpatternNumber(),
                                    RegexLimitation.paternNationalcode(), RegexLimitation.paternNationalcode(), RegexLimitation.paternNationalcode(),
                                    new Location(chekChoice(), chekChoice()), TravelStatuse.WAITING);
                        } else if (choiceDriver == 2) {
                            break;
                        }
                    } else if (result) {
                        switch (manager.checkDriverTravelStatus(nationalcodeDriver)) {
                            case "WAITING":
                                System.out.println("you are in waiting for travel");
                                break;
                            case "START":
                                System.out.println("TravelStatus is : ongoing");
                                System.out.println("enter choice\n1.conform give money\n2.finished travel\n3.exit");
                                choiceDriver = chekChoice();
                                if (choiceDriver == 1 && travelRequest == true) {
                                    System.out.println("money paid");
                                    manager.updateTravelDriverStatus(TravelStatuse.WAITING, nationalcodeDriver);
                                } else if (choiceDriver == 2) {
                                    manager.updateTravelDriverStatus(TravelStatuse.FINISHED, nationalcodeDriver);
                                } else {
                                    break;
                                }
                                break;
                        }
                    }
                    choice = false;
                    break;
                case 4:
                    System.out.println("enter nationalcode");
                    nationalcod = RegexLimitation.paternNationalcode();
                    boolean resultcheck = manager.checkPassenger(nationalcod);
                    if (!resultcheck) {
                        System.out.println("enter choice\n1.register\n2.exit");
                        int choice = chekChoice();
                        if (choice == 1) {
                            System.out.println("name,family,age,nationalcode,username,phoneNumber,money,origin ,destination");
                            manager.addPassenger(RegexLimitation.paternString(), RegexLimitation.paternString(), RegexLimitation.paternpatternNumber(), RegexLimitation.paternNationalcode(),
                                    RegexLimitation.paternNationalcode(), RegexLimitation.paternphonenumber(),
                                    RegexLimitation.paternMoney(), TravelStatuse.WAITING, new Location(chekChoice(), chekChoice()));
                        } else {
                            break;
                        }
                    } else if (resultcheck) {
                        System.out.println("enter choice\n1travel request(pay by cash)\n2travel request(pay by account balance)" +
                                "\n3.Increase account balance increase\n4.exit");
                        int choice = chekChoice();
                        passengerRequstTravelStatuse(nationalcod, choice);
                    }
                    choice = false;
                    break;
                case 5:
                    manager.printDriversInfo();
                    choice = false;
                    break;
                case 6:
                    manager.printPassengerInfo();
                    choice = false;
                    break;
                case 7:
                    manager.printOngoingTravel();
                    choice = false;
                    break;
                case 8:
                    choice = true;
                    break;
            }
        } while (!choice);
    }

    public static String getNationalcodeDriver() {
        String nationalcodeDriver;
        System.out.println("enter nationalcode");
        nationalcodeDriver = RegexLimitation.paternNationalcode();
        return nationalcodeDriver;
    }

    private static void passengerRequstTravelStatuse(String nationalcode, int choice) throws SQLException {
        switch (choice) {
            case 1:
                System.out.println("enter origin ,destination");
                origin = input.nextInt();
                destination = input.nextInt();
                try {
                    manager.findBynearOrigin(origin, destination);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                manager.updateTravelPassengerStatus(TravelStatuse.START, nationalcode);
                travelRequest = true;
                break;
            case 2:
                manager.updateTravelPassengerStatus(TravelStatuse.START, nationalcode);
                int cost = manager.calculateDistance(manager.PassengerOrigin(nationalcode), manager.PassengerDistance(nationalcode));
                if (cost > manager.money(nationalcode)) {
                    System.out.println("your balance is not enough");
                } else {
                    cost = cost - manager.money(nationalcode);
                    manager.decreaseMoney(cost, nationalcode);
                }
                break;
            case 3:
                System.out.println("enter money you want to increase");
                int money = RegexLimitation.paternMoney();
                manager.increaseMoney(money, nationalcode);
                break;
            case 4:
                break;
        }
    }

    private static void addGroupOfPassengers(int numberPas) throws SQLException {
        for (int i = 0; i < numberPas; i++) {
            System.out.println("name,family,age,nationalcode,username,phoneNumber,firstMoney,origin ,destination");
            manager.addPassenger(RegexLimitation.paternString(), RegexLimitation.paternString(), RegexLimitation.paternpatternNumber(), RegexLimitation.paternNationalcode(), RegexLimitation.paternNationalcode()
                    , RegexLimitation.paternphonenumber(), RegexLimitation.paternMoney(),
                    TravelStatuse.WAITING, new Location(chekChoice(), chekChoice()));
        }
    }

    private static void addGropuOfDrivers(int number) throws SQLException {
        for (int i = 0; i < number; i++) {
            System.out.println("name,family,age,nationalcode,username,phoneNumber,origin ,destination");
            manager.addDriver(RegexLimitation.paternString(), RegexLimitation.paternString(), RegexLimitation.paternpatternNumber(),
                    RegexLimitation.paternNationalcode(), RegexLimitation.paternNationalcode(), RegexLimitation.paternNationalcode(),
                    new Location(chekChoice(), chekChoice()), TravelStatuse.WAITING);
        }
    }
}
