/**
 * Movie
 */
public class Movie {
   private int movie_id;
   private  String movie_title;
   private  String description;
   private float duration;
   private  String language;
   private  String relase_date;
   private   String genre;
    public Movie(int movie_id, String movie_title, String description, float duration, String language,
            String relase_date, String genre) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.description = description;
        this.duration = duration;
        this.language = language;
        this.relase_date = relase_date;
        this.genre = genre;
    }
    public Movie() {
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getDuration() {
        return duration;
    }
    public void setDuration(float duration) {
        this.duration = duration;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getRelase_date() {
        return relase_date;
    }
    public void setRelase_date(String relase_date) {
        this.relase_date = relase_date;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }   
}