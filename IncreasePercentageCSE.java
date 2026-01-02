package Assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class IncreasePercentageCSE {
	public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "Root@123"
            );

            String update =
                    "UPDATE Students SET percentage = percentage + (percentage * 0.05) " +
                    "WHERE branch = 'CSE'";

            PreparedStatement ps = con.prepareStatement(update);
            int rows = ps.executeUpdate();

            System.out.println(rows + " CSE student records updated");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
