<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Inventory</title>
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
				<li class="nav-item"><a class="nav-link" href="sales">Sales</a></li>
				<li class="nav-item"><a class="nav-link" href="products">Product</a></li>
				<li class="nav-item"><a class="nav-link active" href="list">Inventory</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="customer">Customer</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h2 class="mt-5">Update Inventory</h2>
		<form action="update" method="post" class="mt-3">
			<input type="hidden" name="itemId" value="${inventory.itemId}">
			<div class="form-group">
				<label for="itemName">Item Name:</label> <input type="text"
					class="form-control" id="itemName" name="itemName"
					value="${inventory.itemName}" required>
			</div>
			<div class="form-group">
				<label for="quantity">Quantity:</label> <input type="number"
					class="form-control" id="quantity" name="quantity"
					value="${inventory.quantity}" required>
			</div>
			<div class="form-group">
				<label for="availableQuantity">Available Quantity:</label> <input
					type="number" class="form-control" id="availableQuantity"
					name="availableQuantity" value="${inventory.availableQuantity}"
					required>
			</div>
			<div class="form-group">
				<label for="daysOfSupply">Days of Supply:</label> <input
					type="number" class="form-control" id="daysOfSupply"
					name="daysOfSupply" value="${inventory.daysOfSupply}" required>
			</div>
			<div class="form-group">
				<label for="recentSalesTrend">Recent Sales Trend:</label> <input
					type="text" class="form-control" id="recentSalesTrend"
					name="recentSalesTrend" value="${inventory.recentSalesTrend}">
			</div>
			<div class="form-group">
				<label for="minimumStockLevel">Minimum Stock Level:</label> <input
					type="number" class="form-control" id="minimumStockLevel"
					name="minimumStockLevel" value="${inventory.minimumStockLevel}"
					required>
			</div>
			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
