import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * SeatServlet
 */
public class SeatServlet extends HttpServlet {
    SeatDAO seatDAO;
    public void init(){
        String jdbcURL = "jdbc:mysql://db4free.net/gowtham12_db";
        String jdbcUsername = "gowtham_s";
        String jdbcPassword = "Kgisl@12345";
        System.out.println("........");
        seatDAO=new SeatDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
    List<Seat>seatlist=new ArrayList<Seat>();
    public Seat newseat;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("seattiming is called");
        PrintWriter out = resp.getWriter();
        out.println("");
        String requestData = req.getReader().lines().collect(Collectors.joining());
        System.out.println(requestData);
        System.out.println("requestData Length->" + requestData.length());
        System.out.println("requestData->" + requestData);
        newseat=new Gson().fromJson(requestData,Seat.class);
        doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get method from seatservlet");
        try {
            // seatlist=seatDAO.
            // add method to process the qurey
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}