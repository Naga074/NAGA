import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    String jdbcURL;
    String jdbcUserName;
    String jdbcPassword;
    private Connection jdbcConnection;
    public MovieDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUserName = jdbcUserName;
        this.jdbcPassword = jdbcPassword;
    }
    
    // Method to Establish the Connection
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
    List<Movie>ListAllMovie() throws Exception{
        List<Movie> movieDAOList=new ArrayList<Movie>();
        String sql = "SELECT * FROM movie";
        connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        while(resultset.next()){
            int movie_id=resultset.getInt("movie_id");
            String movie_title=resultset.getString("movie_title");
            // String description=resultset.getString("description");
            float duration=resultset.getFloat("duration");
            String language=resultset.getString("language");
            String release_date=resultset.getString("release_date");
            String genre=resultset.getString("genre");
            Movie movieobj=new Movie();
            movieobj.setMovie_id(movie_id);
            movieobj.setMovie_title(movie_title);
            // movieobj.setDescription(description);
            movieobj.setDuration(duration);
            movieobj.setLanguage(language);
            movieobj.setRelase_date(release_date);
            movieobj.setGenre(genre);
            movieDAOList.add(movieobj);

        }
        resultset.close();
        statement.close();
        disconnect();
        return movieDAOList;

    }
}
