package Mindaugas.JDBC.DEMO;

import java.sql.*;

public class TestMySQLConnection {

    static String username = "root";
    static String password = "staind0323";
    // static String dbUrl = "jdbc:mysql://localhost:3306/world";
    static String dbUrl = "jdbc:mysql://127.0.0.1:3306/jdbcdemo";

    public static void main(String[] args) throws SQLException, InterruptedException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, username, password);

            System.out.println("Connection Established to MYSQL Database");

            // PreparedStatement stmt = conn.prepareStatement("SELECT table_name FROM information_schema.tables WHERE table_schema='jdbcdemo'");
            PreparedStatement stmt = conn.prepareStatement("select table_schema, table_name from information_schema.tables;");
            ResultSet rslt = stmt.executeQuery();

            while (rslt.next()) {
                System.out.print(rslt.getString(1) + "\t\t| ");
                System.out.println(rslt.getString(2)); // Column Index out of range, 2 > 1.
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Error Code: " + e.getErrorCode());
        } finally{
            conn.close();
        }
    }
}