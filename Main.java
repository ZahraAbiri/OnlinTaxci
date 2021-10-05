package ir.maktab58;

import ir.maktab58.model.Manager;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Scanner input = new Scanner(System.in);
    static int choices = 0;
    static boolean choice = false;

    public static void welcome() {
        System.out.println("************Welcome to taxi reservation system****************");
        System.out.println(" ");
    }

    public static int paternpatternNumber() {
        int number = 0;
        Pattern patternId = Pattern.compile("[A-Za-z]{0}[0-9]+");
        String foodId = input.next();
        Matcher matcherId = patternId.matcher(foodId);
        if (matcherId.find()) {
            number = (int) Long.parseLong((matcherId.group()));
        }
        return number;
    }

    public static String paternPlate() {

        Pattern patternCount = Pattern.compile("[A-Za-z]{1}[0-9]{9}");
        String platenum = input.next();
        Matcher matcherPlateNum = patternCount.matcher(platenum);
        if (matcherPlateNum.find()) {
            platenum = (matcherPlateNum.group());
        }
        return platenum;
    }

    public static int paternMoney() {
        int money = 0;
        Pattern patternPrice = Pattern.compile("[A-Za-z]{0}[0-9]+");
        String moneyPatern = input.next();
        Matcher matcherPrice = patternPrice.matcher(moneyPatern);
        if (matcherPrice.find()) {
            money = Integer.parseInt((matcherPrice.group()));
        }
        return money;
    }

    public static String paternString() {
        Pattern patternName = Pattern.compile("[0-9]{0}[A-Za-z]+");
        String name = input.next();
        Matcher matcherName = patternName.matcher(name);
        if (matcherName.find()) {
            name = (matcherName.group());
        }
        return name;
    }

    public static String paternNationalcode() {
        Pattern patternName = Pattern.compile("[0-9]{10}[A-Za-z]{0}");
        String natinalcode = input.next();
        Matcher matcherName = patternName.matcher(natinalcode);
        if (matcherName.find()) {
            natinalcode = (matcherName.group());
        }
        return natinalcode;
    }

    public static String paternphonenumber() {
        Pattern patternName = Pattern.compile("[0-9]{10}[A-Za-z]{0}");
        String name = input.next();
        Matcher matcherName = patternName.matcher(name);
        if (matcherName.find()) {
            name = (matcherName.group());
        }
        return name;
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


    public static void main(String[] args) throws SQLException {

        int manegerChoice;
        Manager manager = new Manager();
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
                    int number = paternpatternNumber();
                    for (int i = 0; i < number; i++) {
                        System.out.println("name,family,nationalcode,phoneNumber");
                        manager.addDriver(paternString(), paternString(), paternNationalcode(), paternphonenumber());
                        System.out.println(" now Enter car information : name,model,color,capacity,plateNumber");
                        manager.addCar(paternString(), paternString(), paternString(), paternString(), paternPlate());
                    }
                    choice = false;
                    break;
                case 2:
                    System.out.println("number of passengers you want to add");
                    int numberPas = paternpatternNumber();
                    for (int i = 0; i < numberPas; i++) {
                        System.out.println("name,family,nationalcode,phoneNumber,money");
                        manager.addPassenger(paternString(), paternString(), paternNationalcode(), paternphonenumber()
                                , paternMoney());
                    }
                    choice = false;
                    break;
                case 3:
                    System.out.println("enter nationalcode");
                    boolean result = manager.checkPassenger(paternNationalcode());
                    if (result == false) {
                        System.out.println("enter choice\n1.register\n2.exit");
                        int choice = chekChoice();
                        if (choice == 1) {
                            System.out.println("name,family,nationalcode,phoneNumber");
                            manager.addDriver(paternString(), paternString(), paternNationalcode(), paternNationalcode());

                        }
                    } else {
                        break;
                    }
                    choice = false;
                    break;
                case 4:
                    System.out.println("enter nationalcode");
                    String nationalcode = paternNationalcode();
                    boolean resultcheck = manager.checkPassenger(nationalcode);
                    if (resultcheck == false) {
                        System.out.println("enter choice\n1.register\n2.exit");
                        int choice = chekChoice();
                        if (choice == 1) {
                            System.out.println("name,family,nationalcode,phoneNumber,money");
                            manager.addPassenger(paternString(), paternString(), paternNationalcode(), paternNationalcode(), paternMoney());

                        } else {
                            break;
                        }
                    } else if (resultcheck == true) {
                        System.out.println("enter choice\n1.Increse account balence increase\n2.exit");
                        int choice = chekChoice();
                        if (choice == 1) {
                            System.out.println("enter money you want to increse");
                            int money = paternMoney();
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


}
