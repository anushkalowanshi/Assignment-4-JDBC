package Assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteCivil2024 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "Root@123"
            );

            String delete =
                    "DELETE FROM Students WHERE year_of_passing = 2024 AND branch = 'Civil'";

            PreparedStatement ps = con.prepareStatement(delete);
            int rows = ps.executeUpdate();

            System.out.println(rows + " records deleted successfully");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

