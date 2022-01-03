import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
@WebServlet("/movieservlet")
public class MovieServlet extends HttpServlet {
    MovieDAO movieDAO;
    @Override
    public void init() throws ServletException {
        String jdbcURL = "jdbc:mysql://db4free.net/gowtham12_db";
        String jdbcUsername = "gowtham_s";
        String jdbcPassword = "Kgisl@12345";
        movieDAO=new MovieDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.println("get is calling..");
       List<Movie> movieList=new ArrayList<Movie>();
        try {
            movieList=movieDAO.ListAllMovie();
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        Gson g = new Gson();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String movie1 = g.toJson(movieList);
        resp.getWriter().print(movie1);
    }
}
