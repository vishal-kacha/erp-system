<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Delete Product</title>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
		<h2>Delete Product</h2>
		<p>Are you sure you want to delete this product?</p>
		<form action="deleteproduct" method="get">
			<input type="hidden" name="id"
				value="<%= request.getParameter("id") %>">
			<button type="submit" class="btn btn-danger">Delete</button>
			<a href="productlist" class="btn btn-secondary">Cancel</a>
		</form>
	</div>
	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
</body>
</html>