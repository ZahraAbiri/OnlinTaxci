package ir.maktab58.dataAccess;

import ir.maktab58.model.Driver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DriverDatabaseAccess extends Database {


    public DriverDatabaseAccess() throws SQLException {
    }

    public void save(Driver driver) throws SQLException {
        if (getConnection() != null) {
            String sql = String.format("INSERT INTO driver (name,family,age,nationalcode,username,phoneNumber) VALUES ('%S','%S','%S','%S','%S','%S')",
                    driver.getName(), driver.getFamily(), driver.getAge(), driver.getNationalcode(), driver.getUsername(), driver.getPhoneNumber());
            PreparedStatement statement = getConnection().prepareStatement(sql);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            } else {
                System.out.println("A new user was not inserted successfully!");
            }
        }
    }

    public void printDriversInfo() throws SQLException {
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from driver");
        while (resultSet.next()) {
            System.out.print(resultSet.getString(1));
            System.out.print(resultSet.getString(2));
            System.out.print(resultSet.getString(3));
            System.out.print(resultSet.getString(4));
        }
    }

    public boolean checkDriver(String nationalcode) throws SQLException {
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select dev.nationalcode from driver dev");
        while (resultSet.next()) {
            if (resultSet.getString(1).equals(nationalcode)) {
                return true;
            }
        }
        return false;
    }

    public Driver findByNationalCodeOrUserName(String nationalcode) throws SQLException {

        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select dev.nationalcode from driver dev");
        while (resultSet.next()) {
            if (resultSet.getString(1).equals(nationalcode)) {
                Driver driver = new Driver();
                driver.setNationalcode(nationalcode);
                return driver;
            }
        }
        return null;
    }
}
