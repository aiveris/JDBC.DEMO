package Mindaugas.JDBC.DEMO;
import java.sql.*;

public class HelloWorldMySQL2 {
        public static void main(String[] args) {


            String url = "jdbc:mysql://127.0.0.1:3306/jdbcdemo";
            String user = "root";
            String pass = "staind0323";

            try (Connection conn = DriverManager.getConnection(url, user, pass);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT id, name, email, country FROM user")) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String country = rs.getString("country");
                    System.out.println(id + "," + name + "," + email + "," + country);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
