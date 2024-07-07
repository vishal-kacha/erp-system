package inventory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class InventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/invent":
				insertInventory(request, response);
				break;
			case "/update":
				updateInventory(request, response);
				break;
			case "/delete":
				deleteItemInventory(request, response);
				break;
			default:
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

			switch (action) {
			case "/invent":
				insertInventory(req, resp);
				break;
			case "/update":
				showEditForm(req, resp);
				break;
			case "/delete":
				showDeleteConfirmation(req, resp);
				break;
			default:
				listInventory(req, resp);
				break;
			}
		} catch (SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}

	private void insertInventory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String itemName = request.getParameter("itemName");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int availableQuantity = Integer.parseInt(request.getParameter("availableQuantity"));
		int daysOfSupply = Integer.parseInt(request.getParameter("daysOfSupply"));
		String recentSalesTrend = request.getParameter("recentSalesTrend");
		int minimumStockLevel = Integer.parseInt(request.getParameter("minimumStockLevel"));

		Inventory newInventory = new Inventory();
		newInventory.setItemName(itemName);
		newInventory.setQuantity(quantity);
		newInventory.setAvailableQuantity(availableQuantity);
		newInventory.setDaysOfSupply(daysOfSupply);
		newInventory.setRecentSalesTrend(recentSalesTrend);
		newInventory.setMinimumStockLevel(minimumStockLevel);

		InventoryDAO inventoryDAO = new InventoryDAO();

		try {
			inventoryDAO.insertInventory(newInventory);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
		dispatcher.forward(request, response);
	}

	private void updateInventory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("itemId"));
		String itemName = request.getParameter("itemName");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int availableQuantity = Integer.parseInt(request.getParameter("availableQuantity"));
		int daysOfSupply = Integer.parseInt(request.getParameter("daysOfSupply"));
		String recentSalesTrend = request.getParameter("recentSalesTrend");
		int minimumStockLevel = Integer.parseInt(request.getParameter("minimumStockLevel"));

		Inventory inventory = new Inventory(id, itemName, quantity, availableQuantity, daysOfSupply, recentSalesTrend,
				minimumStockLevel);
		InventoryDAO inventoryDAO = new InventoryDAO();
		inventoryDAO.updateInventory(inventory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		InventoryDAO inventoryDAO = new InventoryDAO();
		Inventory existingInventory = inventoryDAO.selectInventory(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("inventory_update.jsp");
		request.setAttribute("inventory", existingInventory);
		dispatcher.forward(request, response);
	}

	private void listInventory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		InventoryDAO inventoryDAO = new InventoryDAO();
		List<Inventory> inventoryList = inventoryDAO.selectAllInventories();
		request.setAttribute("inventoryList", inventoryList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("inventory_list.jsp");
		dispatcher.forward(request, response);
	}

	private void showDeleteConfirmation(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		InventoryDAO inventoryDAO = new InventoryDAO();
		Inventory existingInventory = inventoryDAO.selectInventory(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("inventory_delete.jsp");
		request.setAttribute("inventory", existingInventory);
		dispatcher.forward(request, response);
	}

	private void deleteItemInventory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		InventoryDAO inventoryDAO = new InventoryDAO();
		boolean existingInventory = inventoryDAO.deleteInventory(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
		dispatcher.forward(request, response);
	}

}
