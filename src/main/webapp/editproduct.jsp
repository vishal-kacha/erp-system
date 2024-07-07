<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Product</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<style type="text/css">
input {
	margin: 0.6rem 0;
}
</style>
</head>
<body class="">
	<div class="container">
		<h2 class="mt-5">Edit Product</h2>
		<form action="products_update" method="post" class="mt-3">
			<input type="hidden" name="productId" value="${product.productId}">
			<div class="form-group">
				<label for="productName">Product Name:</label> <input type="text"
					class="form-control" id="productName" name="productName"
					value="${product.productName}" required>
			</div>
			<div class="form-group">
				<label for="description">Description:</label>
				<textarea class="form-control" id="description" name="description"
					required>${product.description}</textarea>
			</div>
			<div class="form-group">
				<label for="category">Category:</label> <input type="text"
					class="form-control" id="category" name="category"
					value="${product.category}">
			</div>
			<div class="form-group">
				<label for="price">Price:</label> <input type="number" step="0.01"
					class="form-control" id="price" name="price"
					value="${product.price}" required>
			</div>
			<div class="form-group">
				<label for="stockLevel">Stock Level:</label> <input type="number"
					class="form-control" id="stockLevel" name="stockLevel"
					value="${product.stockLevel}" required>
			</div>
			<button type="submit" class="btn btn-primary">Update Product</button>
		</form>
	</div>
	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

