package product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/product")
public class ProductControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/products_new":
			showAddForm(request, response);
			break;
		case "/products_edit":
			showEditForm(request, response);
			break;
		case "/products_delete":
			deleteProduct(request, response);
			break;
		default:
			listProducts(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/products_insert":
			insertProduct(request, response);
			break;
		case "/products_update":
			updateProduct(request, response);
			break;
		default:
			listProducts(request, response);
			break;
		}
	}

	private void listProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> productList = productDAO.selectAllProducts();
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
	}

	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("addproduct.jsp").forward(request, response);
	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productName = request.getParameter("productName");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		double price = Double.parseDouble(request.getParameter("price"));
		int stockLevel = Integer.parseInt(request.getParameter("stockLevel"));

		Product newProduct = new Product(productName, description, category, price, stockLevel);

		try {
			productDAO.insertProduct(newProduct);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		Product existingProduct = productDAO.selectProduct(productId);
		request.setAttribute("product", existingProduct);
		request.getRequestDispatcher("editproduct.jsp").forward(request, response);
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		double price = Double.parseDouble(request.getParameter("price"));
		int stockLevel = Integer.parseInt(request.getParameter("stockLevel"));

		Product updatedProduct = new Product(productId, productName, description, category, price, stockLevel);

		try {
			productDAO.updateProduct(updatedProduct);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));

		try {
			productDAO.deleteProduct(productId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("sucess.jsp");
		dispatcher.forward(request, response);
	}
}
