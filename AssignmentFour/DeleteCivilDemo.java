import java.sql.*;

public class DeleteCivilDemo {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","password");
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM Students WHERE branch='Civil' AND year=2024");
            System.out.println("Deleted");
            con.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}