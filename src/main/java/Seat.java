public class Seat {
    private int movie_id;
 
    private String movie_title;
    private String venue_name;
    private String showTiming;
    public Seat(int movie_id, String movie_title, String venue_name, String showTiming) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.venue_name = venue_name;
        this.showTiming = showTiming;
    }
    public int getMovie_id() {
        return movie_id;
    }
    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }
    public String getMovie_title() {
        return movie_title;
    }
    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }
    public String getVenue_name() {
        return venue_name;
    }
    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }
    public String getShowTiming() {
        return showTiming;
    }
    public void setShowTiming(String showTiming) {
        this.showTiming = showTiming;
    }
}
