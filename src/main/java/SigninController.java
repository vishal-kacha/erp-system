import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SigninController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create a Login object
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);

        // Create a LoginDAO object
        LoginDAO loginDAO = new LoginDAO();

        // Validate the login credentials
		if (loginDAO.validate(login)) {
		    // Forward to success page
		    RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
		    dispatcher.forward(request, response);
		} else {
		    // Forward to error page
		    RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		    dispatcher.forward(request, response);
		}
    }
}

