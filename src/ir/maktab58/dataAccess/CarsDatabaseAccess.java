package ir.maktab58.dataAccess;
import ir.maktab58.model.Vehicle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarsDatabaseAccess extends Database {
    public CarsDatabaseAccess() throws SQLException {
    }

    public void save(Vehicle car) throws SQLException {
        if (getConnection() != null) {
            String sql = String.format("INSERT INTO vehicle (name,model,color,capacity,plateNumber,kindofVehicle) VALUES ('%S','%S','%S','%S','%S','%S')",
                    car.getName(), car.getModel(), car.getColor(), car.getCapacity(), car.getPlateNumber(),car.getKindofVehicle());
            PreparedStatement statement = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet=statement.getGeneratedKeys();
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            } else {
                System.out.println("A new user was not inserted successfully!");
            }
        }
    }


    public List<Vehicle> findAllvehicles() throws SQLException {
        if (getConnection() != null) {
            List<Vehicle> vehicles = new ArrayList<>();
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Vehicle");
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setName(resultSet.getString("name"));
                vehicles.add(vehicle);
            }
            return vehicles;
        } else {
            return Collections.emptyList();
        }
    }
}
