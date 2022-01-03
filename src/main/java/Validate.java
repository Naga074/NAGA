import java.sql.*;

public class Validate {
    public static boolean checkUser(String email,String pass,String role) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/kartheekeyan1212","kartheekeyan1212","Karthee@1212");
            PreparedStatement ps = con.prepareStatement("select * from register where email=? and pass=? and role=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ps.setString(3, role);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}

