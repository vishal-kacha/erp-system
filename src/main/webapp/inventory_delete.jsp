<!-- delete_inventory.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Inventory</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
body {
	background-color: #f8f9fa;
}

.delete-container {
	max-width: 600px;
	margin: auto;
	padding: 2rem;
	background-color: white;
	border-radius: 0.5rem;
	box-shadow: 0 0.125rem 0.25rem rgba(0, 0, 0, 0.075);
	text-align: center;
}

.btn-block {
	width: 100%;
}

.warning-icon {
	font-size: 3rem;
	color: #dc3545;
}
</style>
</head>
<body>

	<div class="container my-5">
		<div class="delete-container">
			<div class="mb-4">
				<i class="bi bi-exclamation-triangle-fill warning-icon"></i>
			</div>
			<h2 class="text-danger">Delete Inventory</h2>
			<p class="lead">Are you sure you want to delete this inventory
				item?</p>
			<form action="delete" method="post">
				<input type="hidden" name="id" value="${inventory.itemId}">
				<button type="submit" class="btn btn-danger btn-block mb-3">Delete</button>
				<a href="list" class="btn btn-secondary btn-block">Cancel</a>
			</form>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.js"></script>
</body>
</html>
