import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class VenueDAO {
    String jdbcURL;
    String jdbcUserName;
    String jdbcPassword;
    private Connection jdbcConnection;

    public VenueDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUserName = jdbcUserName;
        this.jdbcPassword = jdbcPassword;
    }

    void connect() throws Exception {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {

            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        }
    }

    void disconnect() throws Exception {
        if (jdbcConnection != null || !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    List<Venue> ListVenue(Venue newvenue) throws Exception {
        List<Venue> venueDaoList = new ArrayList<Venue>();
        String sql = "SELECT *FROM venue where movie_id=?";
        System.out.println("----------");
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, newvenue.getMovie_id());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int venueid=resultSet.getInt("venue_id");
            String venuename=resultSet.getString("venue_name");
            int movieid=resultSet.getInt("movie_id");
            String show1=resultSet.getString("show_1");
            String show2=resultSet.getString("show_2");
            String show3=resultSet.getString("show_3");
            String show4=resultSet.getString("show_4");
            Venue venueobj=new Venue();
            venueobj.setVenue_id(venueid);
            venueobj.setVenue_name(venuename);
            venueobj.setMovie_id(movieid);
            venueobj.setShow_1(show1);
            venueobj.setShow_2(show2);
            venueobj.setShow_3(show3);
            venueobj.setShow_4(show4);
            venueDaoList.add(venueobj);


        }
        for (Venue venue : venueDaoList) {
            System.out.println(venue);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return venueDaoList;

    }
}
