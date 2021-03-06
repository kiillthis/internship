import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/hello")
public class JspServlet extends HttpServlet {

    private final String URL = "jdbc:mysql://127.0.0.1:3306/db";
    private final String USER = "root";
    private final String PASSWORD = "12345678";
    private final String SQL_DRIVER = "com.mysql.jdbc.Driver";

    private final String SCRIPT_FOR_INSERT = "INSERT INTO user VALUES(?, ?, ?)";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JDBCAccess jdbcAccess = new JDBCAccess();
        try {
            jdbcAccess.insert(
                    req.getParameter("name"),
                    req.getParameter("surname"),
                    Integer.parseInt(req.getParameter("age")));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JDBCAccess jdbcAccess = new JDBCAccess();
        List<User> users = null;

        try {
            users = jdbcAccess.getAll();
        } catch (SQLException e) {
            System.out.println(e);
        }

        req.setAttribute("users", users);

        getServletContext().getRequestDispatcher("/table.jsp").forward(req, resp);
    }
}
