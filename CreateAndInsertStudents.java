package Assignment4;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CreateAndInsertStudents {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "Root@123"
            );

            Statement stmt = con.createStatement();

            // Create Table
            String createTable =
                    "CREATE TABLE IF NOT EXISTS Student (" +
                    "id INT ," +
                    "name VARCHAR(50)," +
                    "branch VARCHAR(20)," +
                    "semester INT," +
                    "percentage DOUBLE," +
                    "year_of_passing INT)";

            stmt.executeUpdate(createTable);

            // Insert Records
            String insert =
                    "INSERT INTO Students VALUES " +
                    "(1,'Anil','CSE',7,78.5,2024)," +
                    "(2,'Sunita','Civil',6,72.0,2024)," +
                    "(3,'Ravi','EC',7,81.2,2025)," +
                    "(4,'Meena','CSE',5,69.4,2026)";

            stmt.executeUpdate(insert);

            System.out.println("Table created and records inserted successfully");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

