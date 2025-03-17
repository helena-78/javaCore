package database.resources;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/lab4";
    private static final String USER = "ushenko_lab6";
    private static final String PASSWORD = "password";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static List<String> getStudentsByMonth(int month) {
        List<String> students = new ArrayList<>();
        String query = "SELECT first_name, last_name, middle_name, birth_date FROM students WHERE EXTRACT(MONTH FROM birth_date) = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, month);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                students.add(rs.getString("last_name") + " " +
                        rs.getString("first_name") + " " +
                        rs.getString("middle_name") + " - " +
                        rs.getDate("birth_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
