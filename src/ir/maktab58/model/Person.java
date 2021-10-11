package ir.maktab58.model;

public class Person {
    private String name;
    private String family;
    private int age;
    private String nationalcode;
    private String username;
    private String phoneNumber;
    private Account account;

    public Person(String name, String family,int age, String nationalcode, String username, String phoneNumber) {
        this.name = name;
        this.family = family;
        this.age=age;
        this.nationalcode = nationalcode;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public Person() {

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationalcode() {
        return nationalcode;
    }

    public void setNationalcode(String nationalcode) {
        this.nationalcode = nationalcode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
