package ir.maktab58.model;

public class Account {
    private int accountId;
    private long firstMoney;
    private int passengerId;

    public Account() {
    }

    public Account(int accountId, long firstMoney, int passengerId) {
        this.accountId = accountId;
        this.firstMoney = firstMoney;
        this.passengerId = passengerId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public long getFirstMoney() {
        return firstMoney;
    }

    public void setFirstMoney(long firstMoney) {
        this.firstMoney = firstMoney;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", firstMoney=" + firstMoney +
                ", passengerId=" + passengerId +
                '}';
    }

    public long increaseMoney(long money) {
        long newMoney = money;
        newMoney += getFirstMoney();
        setFirstMoney(newMoney);
        return newMoney;
    }
}
