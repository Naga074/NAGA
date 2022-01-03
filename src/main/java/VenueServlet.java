import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
@WebServlet("/venueServlet")

public class VenueServlet extends HttpServlet {
    VenueDAO venueDAO;
    public void init(){
        String jdbcURL = "jdbc:mysql://db4free.net/gowtham12_db";
        String jdbcUsername = "gowtham_s";
        String jdbcPassword = "Kgisl@12345";
        System.out.println("........");
        venueDAO=new VenueDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
    List<Venue>venueList=new ArrayList<Venue>();
    public Venue newvenue;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("++++++++");
        PrintWriter out = resp.getWriter();
        out.println("");
        RequestDispatcher rs= req.getRequestDispatcher("/Venue.html");
        rs.include(req, resp);
        String requestData = req.getReader().lines().collect(Collectors.joining());
        System.out.println(requestData);
        System.out.println("requestData Length->" + requestData.length());
        System.out.println("requestData->" + requestData);
        newvenue=new Gson().fromJson(requestData, Venue.class);        
      doGet(req, resp);
    }    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("0000000");
      
        try {
           
            venueList=venueDAO.ListVenue(newvenue);;
        } catch (Exception e) {

            e.printStackTrace();
        }
        Gson g=new Gson();
        resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String user1 = g.toJson(venueList);
            resp.getWriter().print(user1);
            // out.print("");
            // out.flush();
            // out.close();           
    }
}
