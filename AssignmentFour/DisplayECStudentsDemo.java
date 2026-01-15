import java.sql.*;

public class DisplayECStudentsDemo {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","password");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Students WHERE branch='EC' AND semester=7");
            while(rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDouble(5)+" "+rs.getInt(6));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}