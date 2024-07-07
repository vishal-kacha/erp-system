<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Customer</title>
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
	<div class="container my-5">
		<h2>Update Customer</h2>
		<form id="updateCustomerForm" action="updateCustomer" method="POST">
			<div class="form-group">
				<label for="customerId">Customer ID</label> <input type="number"
					class="form-control" id="customerId" name="customerId"
					placeholder="Enter customer ID" required>
			</div>
			<div class="form-group">
				<label for="customerName">Customer Name</label> <input type="text"
					class="form-control" id="customerName" name="customerName"
					placeholder="Enter customer name" required>
			</div>
			<div class="form-group">
				<label for="totalLifetimeValue">Total Lifetime Value</label> <input
					type="number" step="0.01" class="form-control"
					id="totalLifetimeValue" name="totalLifetimeValue"
					placeholder="Enter total lifetime value" required>
			</div>
			<div class="form-group">
				<label for="averageOrderValue">Average Order Value</label> <input
					type="number" step="0.01" class="form-control"
					id="averageOrderValue" name="averageOrderValue"
					placeholder="Enter average order value" required>
			</div>
			<div class="form-group">
				<label for="customerSegment">Customer Segment</label> <select
					class="form-control" id="customerSegment" name="customerSegment"
					required>
					<option value="loyal">Loyal</option>
					<option value="new">New</option>
					<option value="at-risk">At-Risk</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary my-5">Update</button>
			<a href="Home.jsp" class="btn btn-secondary my-5">Back to Home
				Page</a>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>