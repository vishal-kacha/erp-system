<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Error</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.container {
	max-width: 600px;
	margin-top: 50px;
}

.alert {
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="alert alert-danger text-center" role="alert">
			<h4 class="alert-heading">Login Failed</h4>
			<p>Invalid email or password. Please try again.</p>
			<hr>
			<a href="signin.jsp" class="btn btn-danger">Go to Login Page</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
