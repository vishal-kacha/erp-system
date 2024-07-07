<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="customer.CustomerPojo"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Data</title>
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
				<li class="nav-item"><a class="nav-link" href="products">Product</a></li>
				<li class="nav-item"><a class="nav-link" href="list">Inventory</a>
				</li>
				<li class="nav-item"><a class="nav-link active" href="customer">Customer</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container mt-5">
		<h2 class="mb-4">Customer Data</h2>
		<div class="mb-4">
			<a href="AddCustomer.jsp" class="btn btn-primary">Add New
				Customer</a>
		</div>
		<table class="table table-bordered table-striped">
			<thead class="thead-light">
				<tr>
					<th scope="col">User ID</th>
					<th scope="col">Customer Name</th>
					<th scope="col">Total Lifetime Value</th>
					<th scope="col">Average Order Value</th>
					<th scope="col">Customer Segment</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<!-- Iterate over customer data -->
				<%
				List<CustomerPojo> customersList = (List<CustomerPojo>) request.getAttribute("customersList");
				DecimalFormat df = new DecimalFormat("#,###.00");

				if (customersList != null && !customersList.isEmpty()) {
					for (CustomerPojo customer : customersList) {
				%>
				<tr>
					<td><%=customer.getCustomerId()%></td>
					<td><%=customer.getCustomerName()%></td>
					<td>$<%=df.format(customer.getTotalLifetimeValue())%></td>
					<td>$<%=df.format(customer.getAverageOrderValue())%></td>
					<td><%=customer.getCustomerSegment()%></td>
					<td><a href="UpdateCustomer.jsp" class="btn btn-info btn-sm">Edit</a>
						<a href="DeleteCustomer.jsp" class="btn btn-danger btn-sm">Delete</a>
					</td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="5">No customers found</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<!-- Bootstrap JS (optional) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
