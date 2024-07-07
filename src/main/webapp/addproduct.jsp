<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Product</title>
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
	<div class="container mt-4">
		<h2>Add Product</h2>
		<form action="products_insert" method="post">
			<div class="form-group">
				<label for="productName">Product Name:</label> <input type="text"
					class="form-control" id="productName" name="productName" required>
			</div>
			<div class="form-group">
				<label for="description">Description:</label>
				<textarea class="form-control" id="description" name="description"></textarea>
			</div>
			<div class="form-group">
				<label for="category">Category:</label> <input type="text"
					class="form-control" id="category" name="category">
			</div>
			<div class="form-group">
				<label for="price">Price:</label> <input type="number" step="0.01"
					class="form-control" id="price" name="price" required>
			</div>
			<div class="form-group">
				<label for="stockLevel">Stock Level:</label> <input type="number"
					class="form-control" id="stockLevel" name="stockLevel" required>
			</div>
			<button type="submit" class="btn btn-primary">Add Product</button>
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