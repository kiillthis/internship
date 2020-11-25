import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCAccess {
    private final String URL = "jdbc:mysql://127.0.0.1:3306/db";
    private final String USER = "root";
    private final String PASSWORD = "12345678";
    private final String SQL_DRIVER = "com.mysql.jdbc.Driver";

    private final String SCRIPT_FOR_INSERT = "INSERT INTO user VALUES(?, ?, ?)";
    private final String GET_ALL = "SELECT * FROM user";

    public JDBCAccess() {
        try {
            Class.forName(SQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void insert(String name, String surname, int age) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(SCRIPT_FOR_INSERT);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setInt(3, age);

            int rows = preparedStatement.executeUpdate();
        }
    }

    public List<User> getAll() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(GET_ALL);

            List<User> students = new ArrayList<>();

            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");

                students.add(new User(name, surname, age));
            }

            return students;
        }
    }
}
