package customer;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO = new CustomerDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/addCustomer":
				insertCustomer(request, response);
				break;

			case "/updateCustomer":
				updateCustomer(request, response);
				break;
				
			case "/deleteCustomer":
				deleteCustomer(request, response);
				break;
			default:
				listCustomers(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

				try {
					listCustomers(req, resp);
				} catch (SQLException | IOException | ServletException e) {
					e.printStackTrace();
				}
	}
	

	protected void insertCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customerName = request.getParameter("customerName");
		String totalLifetimeValue = request.getParameter("totalLifetimeValue");
		String averageOrderValue = request.getParameter("averageOrderValue");
		String customerSegment = request.getParameter("customerSegment");

		CustomerPojo newCustomer = new CustomerPojo();
		newCustomer.setCustomerName(customerName);
		newCustomer.setTotalLifetimeValue(Double.parseDouble(totalLifetimeValue));
		newCustomer.setAverageOrderValue(Double.parseDouble(averageOrderValue));
		newCustomer.setCustomerSegment(customerSegment);

		try {
			customerDAO.insertCustomer(newCustomer);
		} catch (SQLException e) {
			throw new ServletException(e);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
		dispatcher.forward(request, response);
	}

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException, ServletException {
	    int customerId = Integer.parseInt(request.getParameter("customerId"));
	    String customerName = request.getParameter("customerName");
	    double totalLifetimeValue = Double.parseDouble(request.getParameter("totalLifetimeValue"));
	    double averageOrderValue = Double.parseDouble(request.getParameter("averageOrderValue"));
	    String customerSegment = request.getParameter("customerSegment");

	    CustomerPojo customer = new CustomerPojo();
	    customer.setCustomerId(customerId);
	    customer.setCustomerName(customerName);
	    customer.setTotalLifetimeValue(totalLifetimeValue);
	    customer.setAverageOrderValue(averageOrderValue);
	    customer.setCustomerSegment(customerSegment);

	    try {
	        customerDAO.updateCustomer(customer);
			RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
			dispatcher.forward(request, response);
	    } catch (SQLException e) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Fail.jsp");
	        dispatcher.forward(request, response);
	    }
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
        String customerName = request.getParameter("customerName");

        try {
            if (customerDAO.customerExists(customerId, customerName)) {
                customerDAO.deleteCustomer(customerId, customerName);
        		RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
        		dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("Fail.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
	}
	private void listCustomers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
        List<CustomerPojo> customersList = customerDAO.getAllCustomers();
        request.setAttribute("customersList", customersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer.jsp");
        dispatcher.forward(request, response);	
        }

}
