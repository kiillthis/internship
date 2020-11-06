import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        JdbcClass bd = new JdbcClass();

        List<Student> students = null;

        try {
            bd.dropTable();
            bd.createTable();

            bd.insert("Andrew", "Kompaniets", 20);
            bd.insert("Alisa", "Ivanova", 20);
            bd.insert("Bob", "Ukalov", 20);
            bd.insert("Kek", "Lol", 25);
            bd.update("Ivanova", 22);
            bd.delete("Lol");

            students = bd.getAll();


        } catch (SQLException e) {
            System.out.println(e);
        }
        if (students != null) {
            for (Student s: students) {
                System.out.println("\n================\n");
                System.out.println("Name: " + s.getName());
                System.out.println("Surname: " + s.getSurname());
                System.out.println("Age: " + s.getAge());
            }
        }
    }
}
