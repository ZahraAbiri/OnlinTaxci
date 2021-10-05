package ir.maktab58.dataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    String dbURL = "jdbc:mysql://localhost:3306/taxi";
    String username = "root";
    String password = "123qwe";
    private Connection connection;

    public Database() throws SQLException {
        connection = DriverManager.getConnection(dbURL, username, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


}
