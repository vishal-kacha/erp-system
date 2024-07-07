<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Sales</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
input {
	margin: 0.6rem 0;
}
</style>
</head>
<body class="">
	<div class="container my-5">
		<h2 class="mb-4">Edit Sales</h2>
		<form action="update_sales" method="post">
			<input type="hidden" name="id"
				value="<%= request.getParameter("id") %>">
			<div class="form-group">
				<label for="salespersonName">Salesperson Name:</label> <input
					type="text" class="form-control" id="salespersonName"
					name="salespersonName" value="${sales.salespersonName}" required>
			</div>
			<div class="form-group">
				<label for="target">Target:</label> <input type="number"
					class="form-control" id="target" name="target"
					value="${sales.target}" required>
			</div>
			<div class="form-group">
				<label for="numberOfUnits">Number of Units:</label> <input
					type="number" class="form-control" id="numberOfUnits"
					name="numberOfUnits" value="${sales.numberOfUnits}" required>
			</div>
			<div class="form-group">
				<label for="numberOfUnitsSold">Number of Units Sold:</label> <input
					type="number" class="form-control" id="numberOfUnitsSold"
					name="numberOfUnitsSold" value="${sales.numberOfUnitsSold}"
					required>
			</div>
			<div class="form-group">
				<label for="completionStatus">Completion Status:</label> <input
					type="text" class="form-control" id="completionStatus"
					name="completionStatus" value="${sales.completionStatus}" required>
			</div>
			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>
</body>
</html>
