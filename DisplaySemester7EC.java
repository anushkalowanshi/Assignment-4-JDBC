package Assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplaySemester7EC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "Root@123"
            );

            String select =
                    "SELECT * FROM Students WHERE semester = 7 AND branch = 'EC'";

            PreparedStatement ps = con.prepareStatement(select);
            ResultSet rs = ps.executeQuery();

            System.out.println("ID  Name   Branch  Semester  Percentage  Year");
            System.out.println("----------------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "  " +
                        rs.getString("name") + "  " +
                        rs.getString("branch") + "  " +
                        rs.getInt("semester") + "  " +
                        rs.getDouble("percentage") + "  " +
                        rs.getInt("year_of_passing")
                );
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

