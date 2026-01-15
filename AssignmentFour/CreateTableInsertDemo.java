import java.sql.*;

public class CreateTableInsertDemo {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","password");
            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Students(id INT PRIMARY KEY, name VARCHAR(50), branch VARCHAR(20), semester INT, percentage DOUBLE, year INT)");
            PreparedStatement ps = con.prepareStatement("INSERT INTO Students VALUES(?,?,?,?,?,?)");
            ps.setInt(1,1); ps.setString(2,"Amit"); ps.setString(3,"CSE"); ps.setInt(4,6); ps.setDouble(5,75); ps.setInt(6,2025); ps.executeUpdate();
            ps.setInt(1,2); ps.setString(2,"Ravi"); ps.setString(3,"Civil"); ps.setInt(4,7); ps.setDouble(5,65); ps.setInt(6,2024); ps.executeUpdate();
            ps.setInt(1,3); ps.setString(2,"Neha"); ps.setString(3,"EC"); ps.setInt(4,7); ps.setDouble(5,80); ps.setInt(6,2025); ps.executeUpdate();
            System.out.println("Records Inserted");
            con.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}