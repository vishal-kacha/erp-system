<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Success</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style type="text/css">
body {
	background-color: #f8f9fa;
}

.success-container {
	max-width: 600px;
	margin: auto;
	padding: 2rem;
	background-color: white;
	border-radius: 0.5rem;
	box-shadow: 0 0.125rem 0.25rem rgba(0, 0, 0, 0.075);
}

.btn-home {
	width: 100%;
}

.check-icon {
	font-size: 3rem;
	color: #28a745;
}
</style>
</head>
<body>

	<div class="container my-5">
		<div class="success-container text-center">
			<div class="mb-4">
				<i class="bi bi-check-circle-fill check-icon"></i>
			</div>
			<h1 class="display-5 text-success">Success</h1>
			<p class="lead">Your operation has been successfully performed.</p>
			<a href="home.jsp" class="btn btn-success btn-home my-3">Back to
				Home Page</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.js"></script>
</body>
</html>

