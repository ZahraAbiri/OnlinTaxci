package ir.maktab58.dataAccess;

import ir.maktab58.model.Driver;
import ir.maktab58.model.TravelStatuse;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverDatabaseAccess extends Database {


    public DriverDatabaseAccess() throws SQLException {
    }

    Database database = new Database();

    public void save(Driver driver) throws SQLException {
        if (getConnection() != null) {
            String sql = String.format("INSERT INTO driver (name,family,age,nationalcode,username,phoneNumber,origin,destination,TravelStatuse) " +
                            "VALUES ('%S','%S','%S','%S','%S','%S','%d','%d','%S')",
                    driver.getName(), driver.getFamily(), driver.getAge(), driver.getNationalcode(),
                    driver.getUsername(), driver.getPhoneNumber(), driver.getLocation().getOrigin(), driver.getLocation().getDestination(), driver.getTravelStatuse());
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

    public String checkDriverTravelStatus(String nationalcode) throws SQLException {
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select dev.TravelStatuse from driver dev");
        while (resultSet.next()) {

            return resultSet.getString(1);

        }
        return "travel status is unknown";
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

    public void UpdateTravelStatus(TravelStatuse travelStatuse, String nationalcode) throws SQLException {

        String sqlU = String.format("UPDATE driver SET travelStatuse ='%S' where nationalcode='%S'", travelStatuse, nationalcode);
        PreparedStatement statementU = getConnection().prepareStatement(sqlU);
        int rowsUpdated = statementU.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("travelStatuse successfully!");
        } else {
            System.out.println("travelStatuse not update successfully!");


        }
    }

    public int getDriverorigin(String nationalcode) throws SQLException {

        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select dev.nationalcode,dev.origin from driver dev");
        while (resultSet.next()) {
            if (resultSet.getString(1).equals(nationalcode)) {
                return resultSet.getInt(2);
            }

        }
        return -1;
    }

    public List<Driver> findAllDrivers() throws SQLException {
        if (getConnection() != null) {
            List<Driver> drivers = new ArrayList<>();
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from driver dev");
            while (resultSet.next()) {
                Driver driver = new Driver();
                driver.setName(resultSet.getString("name"));
                driver.setFamily(resultSet.getString("family"));
                driver.setNationalcode(resultSet.getString("nationalcode"));
                drivers.add(driver);
            }
            return drivers;
        } else {
            return Collections.emptyList();
        }
    }

    public void updateDriverLocation(int destination, String nationalcode) throws SQLException {
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select dev.nationalcode from driver dev");
        while (resultSet.next()) {
            if (resultSet.getString(1).equals(nationalcode)) {
                String sqlU = "UPDATE driver SET origin =? where nationalcode=?";
                PreparedStatement statementU = database.getConnection().prepareStatement(sqlU);
                statementU.setString(1, String.valueOf(destination));
                statementU.setString(2, nationalcode);
                int rowsUpdated = statementU.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("An existing user was updated successfully!");
                } else {
                    System.out.println("A new user was not inserted successfully!");
                }

            }
        }

    }
}
