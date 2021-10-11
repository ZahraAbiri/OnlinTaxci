package ir.maktab58;

import ir.maktab58.model.Manager;
import ir.maktab58.model.RegexLimitation;
import ir.maktab58.model.TravelStatuse;

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
        } while (choice == false);
        choice = false;
        return choices;
    }

    static Manager manager;
    static RegexLimitation regex;

    public static void main(String[] args) throws SQLException {

        int manegerChoice;
        manager = new Manager();
        welcome();
        do {
            System.out.println("************Manager Menu****************");
            System.out.println("1.Add groups of dinner menu\n2.Add groups of passenger \n3.Driver login" +
                    "\n4.passenger login\n5.show list of driver\n6.show list of passenger\n7.fished program");
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
                    boolean result = manager.checkPassenger(RegexLimitation.paternNationalcode());
                    if (!result) {
                        System.out.println("enter choice\n1.register\n2.exit");
                        int choice = chekChoice();
                        if (choice == 1) {
                            System.out.println("name,family,nationalcode,phoneNumber");
                            manager.addDriver(RegexLimitation.paternString(),RegexLimitation.paternString(), RegexLimitation.paternpatternNumber(),
                                    RegexLimitation.paternNationalcode(), RegexLimitation.paternNationalcode(),RegexLimitation.paternNationalcode());

                        }
                    } else {
                        System.out.println("");
                        break;
                    }
                    choice = false;
                    break;
                case 4:
                    System.out.println("enter nationalcode");
                    String nationalcode = RegexLimitation.paternNationalcode();
                    boolean resultcheck = manager.checkPassenger(nationalcode);
                    if (!resultcheck) {
                        System.out.println("enter choice\n1.register\n2.exit");
                        int choice = chekChoice();
                        if (choice == 1) {
                            System.out.println("name,family,age,nationalcode,username,phoneNumber,money");
                            manager.addPassenger(RegexLimitation.paternString(), RegexLimitation.paternString(), RegexLimitation.paternpatternNumber(), RegexLimitation.paternNationalcode(),
                                    RegexLimitation.paternNationalcode(), RegexLimitation.paternphonenumber(),
                                    RegexLimitation.paternMoney(), TravelStatuse.WAITING.setShortcut("WAITING"));

                        } else {
                            break;
                        }
                    } else if (resultcheck) {
                        System.out.println("enter choice\n1.Increase account balance increase\n2.exit");
                        int choice = chekChoice();
                        if (choice == 1) {
                            System.out.println("enter money you want to increase");
                            int money = RegexLimitation.paternMoney();
                            manager.increaseMoney(money, nationalcode);
                        } else {
                            break;
                        }
                    } else {
                        break;
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

                    choice = true;
                    break;
            }
        } while (!choice);
    }

    private static void addGroupOfPassengers(int numberPas) throws SQLException {
        for (int i = 0; i < numberPas; i++) {
            System.out.println("name,family,age,nationalcode,username,phoneNumber,firstMoney");
            manager.addPassenger(RegexLimitation.paternString(), RegexLimitation.paternString(), RegexLimitation.paternpatternNumber(), RegexLimitation.paternNationalcode(), RegexLimitation.paternNationalcode()
                    , RegexLimitation.paternphonenumber(), RegexLimitation.paternMoney(), TravelStatuse.WAITING.setShortcut("WAITING"));
        }
    }

    private static void addGropuOfDrivers(int number) throws SQLException {
        for (int i = 0; i < number; i++) {
            System.out.println("name,family,age,nationalcode,username,phoneNumber");
            manager.addDriver(RegexLimitation.paternString(), RegexLimitation.paternString(), RegexLimitation.paternpatternNumber(),
                    RegexLimitation.paternNationalcode(), RegexLimitation.paternNationalcode(), RegexLimitation.paternNationalcode());
        }
    }


}
