package Mindaugas.JDBC.DEMO;
import java.sql.*;

public class HelloWorldMySQL {
    public static void main(String[] args) {

        // CREATE DATABASE jdbcdemo;
        // USE    jdbcdemo;
        // CREATE TABLE `user` (
        //     `id` bigint(20) NOT NULL AUTO_INCREMENT,
        //     `birthdate` date DEFAULT NULL,
        //     `height` int(11) NOT NULL,
        //     `name` varchar(255) DEFAULT NULL,
        //     `email` varchar(255) DEFAULT NULL,
        //     `country` varchar(255) DEFAULT NULL,
        //     PRIMARY KEY (`id`)
        // ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_lithuanian_ci;

        // Showcase data generation with online tools: http://filldb.info

        String url = "jdbc:mysql://127.0.0.1:3306/jdbcdemo";
        String user = "root";
        String pass = "staind0323";

        // OLD WAY: see the other file

        // NEW WAY - using try with resources
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

