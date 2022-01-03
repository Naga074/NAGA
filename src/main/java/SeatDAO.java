import java.sql.Connection;
import java.sql.DriverManager;

public class SeatDAO {
    String jdbcURL;
    String jdbcUserName;
    String jdbcPassword;
    private Connection jdbcConnection;
    public SeatDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUserName = jdbcUserName;
        this.jdbcPassword = jdbcPassword;
    }
    void connect() throws Exception {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {

            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        }
    }
    // Method to Disconnect the Connection
    void disconnect() throws Exception {
        if (jdbcConnection != null || !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    //create a sql statement
    
}
