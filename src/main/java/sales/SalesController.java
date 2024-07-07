package sales;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sales")
public class SalesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SalesDAO salesDAO = new SalesDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		try {
			switch (action) {
			case "/insert_sales":
				insertSales(req, resp);
				break;
			case "/update_sales":
				updateSales(req, resp);
				break;
			default:
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/delete_sales":
				deleteSales(request, response);
				break;
			case "/update_sales":
				showEditForm(request, response);
				break;
			default:
				listSales(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listSales(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Sales> salesList = salesDAO.getAllSales();
		request.setAttribute("salesList", salesList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sales_list.jsp");
		dispatcher.forward(request, response);
	}


	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Sales existingSales = salesDAO.getSales(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sales_edit.jsp");
		request.setAttribute("sales", existingSales);
		dispatcher.forward(request, response);
	}

	private void insertSales(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String salespersonName = request.getParameter("salespersonName");
		int target = Integer.parseInt(request.getParameter("target"));
		int numberOfUnits = Integer.parseInt(request.getParameter("numberOfUnits"));
		int numberOfUnitsSold = Integer.parseInt(request.getParameter("numberOfUnitsSold"));
		String completionStatus = request.getParameter("completionStatus");

		Sales newSales = new Sales(salespersonName, target, numberOfUnits, numberOfUnitsSold, completionStatus);
		salesDAO.insertSales(newSales);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
		dispatcher.forward(request, response);
	}

	private void updateSales(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String salespersonName = request.getParameter("salespersonName");
		int target = Integer.parseInt(request.getParameter("target"));
		int numberOfUnits = Integer.parseInt(request.getParameter("numberOfUnits"));
		int numberOfUnitsSold = Integer.parseInt(request.getParameter("numberOfUnitsSold"));
		String completionStatus = request.getParameter("completionStatus");

		Sales sales = new Sales(id, salespersonName, target, numberOfUnits, numberOfUnitsSold, completionStatus);
		salesDAO.updateSales(sales);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteSales(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		salesDAO.deleteSales(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
		dispatcher.forward(request, response);
	}
}
