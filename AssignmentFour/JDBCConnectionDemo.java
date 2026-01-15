import java.sql.*;

public class JDBCConnectionDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","password");
            System.out.println("Connection Successful");
            con.close();
        } catch (Exception e) {
            System.out.println("Unable to connect");
        }
    }
}