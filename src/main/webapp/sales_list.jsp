<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="sales.Sales"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sales List</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
/* Optional custom styles */
</style>
</head>
<body class="">
	<nav class="navbar navbar-expand-lg ">
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
				<li class="nav-item"><a class="nav-link active" href="sales">Sales</a></li>
				<li class="nav-item"><a class="nav-link" href="products">Product</a></li>
				<li class="nav-item"><a class="nav-link" href="list">Inventory</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="customer">Customer</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container my-5">
		<h2 class="mb-4">Sales List</h2>
		<!-- Add New Sales Button -->
		<a href="sales_new.jsp" class="btn btn-primary mb-4">Add New Sales</a>
		<div class="table-responsive">
			<table class="table table-bordered table-striped">
				<thead class="thead-dark">
					<tr>
						<th>Sales ID</th>
						<th>Salesperson Name</th>
						<th>Target</th>
						<th>Number of Units</th>
						<th>Number of Units Sold</th>
						<th>Completion Status</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Sales> salesList = (List<Sales>) request.getAttribute("salesList");
					for (Sales sales : salesList) {
					%>
					<tr>
						<td><%=sales.getSalesID()%></td>
						<td><%=sales.getSalespersonName()%></td>
						<td><%=sales.getTarget()%></td>
						<td><%=sales.getNumberOfUnits()%></td>
						<td><%=sales.getNumberOfUnitsSold()%></td>
						<td><%=sales.getCompletionStatus()%></td>
						<td>
							<!-- Update Button --> <a
							href="update_sales?id=<%=sales.getSalesID()%>"
							class="btn btn-sm btn-info">Edit</a> <!-- Delete Button --> <a
							href="delete_sales?id=<%=sales.getSalesID()%>"
							class="btn btn-sm btn-danger">Delete</a>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>

