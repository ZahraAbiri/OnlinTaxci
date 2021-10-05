package ir.maktab58.dataAccess;

import ir.maktab58.model.Passenger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PassengerDatabaseAccess {
    Database database = new Database();

    public PassengerDatabaseAccess() throws SQLException {
    }

    public void save(Passenger passenger) throws SQLException {
        if (database.getConnection() != null) {//travelStatuse?
            String sql = String.format("INSERT INTO passenger (name,family,nationalcode,phoneNumber,firstMoney) VALUES ('%S','%S','%S','%S','%d')",
                    passenger.getName(), passenger.getFamily(), passenger.getNationalcode(), passenger.getPhoneNumber(), passenger.getFirstMoney());
            PreparedStatement statement = database.getConnection().prepareStatement(sql);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            } else {
                System.out.println("A new user was not inserted successfully!");
            }
        }
    }

    public void printPasengerInfo() throws SQLException {
        Statement statement = database.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from passenger");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
    }

    public boolean checkPassenger(String nationalcode) throws SQLException {
        Statement statement = database.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select dev.nationalcode from passenger dev");
        while (resultSet.next()) {
            if (resultSet.getString(1).equals(nationalcode)) {
                return true;
            }
        }
        return false;
    }

    public int getpassengerFirstMoney(String nationalcode) throws SQLException {
        int money;
        Statement statement = database.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select dev.nationalcode,dev.firstMoney from passenger dev");
        while (resultSet.next()) {
            if (resultSet.getString(1).equals(nationalcode)) {
                money=resultSet.getInt(2);
                return money;
            }
        }
        return resultSet.getInt(2);
    }

    public void seveIncreseMoney(int newMoney, String nationalcode) throws SQLException {

                String sqlU = String.format("UPDATE passenger SET firstMoney ='%d' where nationalcode='%S'", newMoney, nationalcode);
                PreparedStatement statementU = database.getConnection().prepareStatement(sqlU);
                int rowsUpdated = statementU.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("An existing user was updated successfully!");
                } else {
                    System.out.println("A new user was not inserted successfully!");


        }
    }
}
