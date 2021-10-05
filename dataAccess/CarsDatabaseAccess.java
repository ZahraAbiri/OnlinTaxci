package ir.maktab58.dataAccess;

import ir.maktab58.model.Cars;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarsDatabaseAccess extends Database {
    public CarsDatabaseAccess() throws SQLException {
    }

    public void save(Cars car) throws SQLException {
        if (getConnection() != null) {
            String sql = String.format("INSERT INTO car (name,model,color,capacity,plateNumber) VALUES ('%S','%S','%S','%S','%S')",
                    car.getName(), car.getModel(), car.getColor(), car.getCapacity(), car.getPlateNumber());
            PreparedStatement statement = getConnection().prepareStatement(sql);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            } else {
                System.out.println("A new user was not inserted successfully!");
            }
        }
    }

    public void printcarInfo() throws SQLException {
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from car");
        while (resultSet.next()) {
            System.out.print(resultSet.getString(1));
        }
    }
}
