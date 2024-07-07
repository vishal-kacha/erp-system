import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Create a User object
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        
        // Create a UserDAO object
        UserDAO userDAO = new UserDAO();
        
        try {
            // Add the user to the database
            userDAO.addUser(user);
            // Redirect to success page
			RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp");
			dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Handle database errors
            e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
        }
    }
}
