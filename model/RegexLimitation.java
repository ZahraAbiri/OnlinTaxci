package ir.maktab58.model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLimitation {
    static Scanner input = new Scanner(System.in);
    public static int paternpatternNumber() {
        int number = 0;
        Pattern patternId = Pattern.compile("[A-Za-z]{0}[0-9]+");
        String num = input.next();
        Matcher matcherId = patternId.matcher(num);
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
        String natinalcode = "";
        try {
            Pattern patternName = Pattern.compile("[0-9]+[A-Za-z]{0}");
            natinalcode = input.next();

            Matcher matcherName = patternName.matcher(natinalcode);
            if (matcherName.find()) {
                natinalcode = (matcherName.group());


            }

        } catch (Exception ex) {
            System.out.println("wrong nationalcode");

        }
        return natinalcode;


    }

    public static String paternphonenumber() {
        Pattern patternName = Pattern.compile("[0-9]{11}[A-Za-z]{0}");
        String name = input.next();
        Matcher matcherName = patternName.matcher(name);
        if (matcherName.find()) {
            name = (matcherName.group());
        }
        return name;
    }
}
