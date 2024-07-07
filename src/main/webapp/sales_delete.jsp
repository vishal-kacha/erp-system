<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Sales</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h2 class="mb-4">Delete Sales</h2>
		<p>Are you sure you want to delete this sales record?</p>
		<form action="delete" method="post">
			<input type="hidden" name="id"
				value="<%= request.getParameter("id") %>">
			<button type="submit" class="btn btn-danger">Delete</button>
			<a href="sales" class="btn btn-secondary">Cancel</a>
		</form>
	</div>
</body>
</html>
