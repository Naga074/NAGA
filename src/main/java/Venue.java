import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Venue {
    int venue_id;
    String venue_name;
    int movie_id;
    String show_1;
    String show_2;
    String show_3;
    String show_4;
    public Venue(int venue_id, String venue_name, int movie_id, String show_1, String show_2, String show_3,
            String show_4) {
        this.venue_id = venue_id;
        this.venue_name = venue_name;
        this.movie_id = movie_id;
        this.show_1 = show_1;
        this.show_2 = show_2;
        this.show_3 = show_3;
        this.show_4 = show_4;
    }
    public Venue() {
    }
    public int getVenue_id() {
        return venue_id;
    }
    public void setVenue_id(int venue_id) {
        this.venue_id = venue_id;
    }
    public String getVenue_name() {
        return venue_name;
    }
    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }
    public int getMovie_id() {
        return movie_id;
    }
    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }
    public String getShow_1() {
        return show_1;
    }
    public void setShow_1(String show_1) {
        this.show_1 = show_1;
    }
    public String getShow_2() {
        return show_2;
    }
    public void setShow_2(String show_2) {
        this.show_2 = show_2;
    }
    public String getShow_3() {
        return show_3;
    }
    public void setShow_3(String show_3) {
        this.show_3 = show_3;
    }
    public String getShow_4() {
        return show_4;
    }
    public void setShow_4(String show_4) {
        this.show_4 = show_4;
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp,Venue a) {
    }
}
