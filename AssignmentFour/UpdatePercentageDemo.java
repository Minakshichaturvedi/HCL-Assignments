import java.sql.*;

public class UpdatePercentageDemo {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","password");
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE Students SET percentage = percentage * 1.05 WHERE branch='CSE'");
            System.out.println("Updated");
            con.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}