<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
.cards {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	gap: 1rem;
	margin: 2rem 0;
}

.card {
	width: 18rem;
}
</style>
</head>
<body class="">
	<nav class="navbar navbar-expand-lg ">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto">
				<li class="nav-item active"><a class="nav-link active"
					href="home.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="sales">Sales</a></li>
				<li class="nav-item"><a class="nav-link" href="products">Product</a></li>
				<li class="nav-item"><a class="nav-link" href="list">Inventory</a></li>
				<li class="nav-item"><a class="nav-link" href="customer">Customer</a></li>
			</ul>
		</div>
	</nav>

	<div class="cards">
		<div class="card bg-dark text-white">
			<div class="card-body">
				<h5 class="card-title">Sales</h5>
				<p class="card-text">Manage and view sales details.</p>
				<a href="sales" class="btn btn-primary">Go to Sales</a>
			</div>
		</div>
		<div class="card bg-dark text-white">
			<div class="card-body">
				<h5 class="card-title">Products</h5>
				<p class="card-text">View and manage products.</p>
				<a href="products" class="btn btn-primary">Go to Products</a>
			</div>
		</div>
		<div class="card bg-dark text-white">
			<div class="card-body">
				<h5 class="card-title">Inventory</h5>
				<p class="card-text">Check inventory status.</p>
				<a href="list" class="btn btn-primary">Go to Inventory</a>
			</div>
		</div>
		<div class="card bg-dark text-white">
			<div class="card-body">
				<h5 class="card-title">Customers</h5>
				<p class="card-text">Manage customer information.</p>
				<a href="customer" class="btn btn-primary">Go to Customers</a>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
