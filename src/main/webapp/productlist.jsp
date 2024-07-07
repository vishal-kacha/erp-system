<%@ page import="java.util.List"%>
<%@ page import="product.Product"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Product List</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body class="">
	<nav class="navbar navbar-expand-lg">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="home.jsp">Home
				</a></li>
				<li class="nav-item"><a class="nav-link" href="sales">Sales</a></li>
				<li class="nav-item"><a class="nav-link active" href="products">Product</a></li>
				<li class="nav-item"><a class="nav-link" href="list">Inventory</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="customer">Customer</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container my-5">
		<h2 class="mb-4">Product List</h2>
		<div class="mb-3">
			<a href="addproduct.jsp" class="btn btn-primary">Add Product</a>
		</div>
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Product ID</th>
					<th scope="col">Product Name</th>
					<th scope="col">Description</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Stock Level</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Product> productList = (List<Product>) request.getAttribute("productList");
				if (productList != null && !productList.isEmpty()) {
					for (Product product : productList) {
				%>
				<tr>
					<td><%=product.getProductId()%></td>
					<td><%=product.getProductName()%></td>
					<td><%=product.getDescription()%></td>
					<td><%=product.getCategory()%></td>
					<td><%=product.getPrice()%></td>
					<td><%=product.getStockLevel()%></td>
					<td><a href="products_edit?id=<%=product.getProductId()%>"
						class="btn btn-sm btn-info">Edit</a> <a
						href="products_delete?id=<%=product.getProductId()%>"
						class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="7" class="text-center">No products available</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<!-- Bootstrap JS and dependencies -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>

