import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcClass {


    private final String URL = "jdbc:mysql://127.0.0.1:3306/db";
    private final String USER = "root";
    private final String PASSWORD = "12345678";
    private final String SQL_DRIVER = "com.mysql.jdbc.Driver";

    private final String SCRIPT_FOR_TABLE = "CREATE TABLE students (name VARCHAR(10), surname VARCHAR(10), age INT)";

    private final String SCRIPT_FOR_INSERT = "INSERT INTO students VALUES(?, ?, ?)";

    private final String UPDATE_AGE = "UPDATE students SET age = ? WHERE surname = ? ";

    private final String DELETE_STUDENT = "DELETE FROM students WHERE surname = ?";

    private final String GET_ALL = "SELECT * FROM students";

    private final String DROP_TABLE = "DROP TABLE students";

    public JdbcClass() {
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

    public void update(String surname, int age) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AGE);

            preparedStatement.setString(2, surname);
            preparedStatement.setInt(1, age);

            preparedStatement.execute();
        }
    }

    public List<Student> getAll() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(GET_ALL);

            List<Student> students = new ArrayList<>();

            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");

                students.add(new Student(name, surname, age));
            }

            return students;
        }
    }

    public void delete(String surname) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);

            preparedStatement.setString(1, surname);

            preparedStatement.execute();
        }
    }

    public void createTable() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

        Statement statement = connection.createStatement();

        statement.execute(SCRIPT_FOR_TABLE);

        }
    }

    public void dropTable() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();

            statement.execute(DROP_TABLE);
        }
    }
}
