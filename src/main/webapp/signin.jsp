<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Sign In</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style type="text/css">
body {
	background-color: #f8f9fa;
}

.signin-container {
	max-width: 400px;
	margin: auto;
	padding: 2rem;
	background-color: white;
	border-radius: 0.5rem;
	box-shadow: 0 0.125rem 0.25rem rgba(0, 0, 0, 0.075);
	margin-top: 5rem;
}

.error-message {
	color: red;
	font-size: 0.875rem;
	margin-top: 0.25rem;
}

input {
	margin: 0.6rem 0;
}
</style>
</head>
<body>
	<div class="container signin-container">
		<h2 class="text-center">User Sign In</h2>
		<form id="signinForm" action="signin" method="post"
			onsubmit="return validateForm()">
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					class="form-control" id="username" name="username" required>
				<div id="usernameError" class="error-message"></div>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" name="password" required>
				<div id="passwordError" class="error-message"></div>
			</div>
			<button type="submit" class="btn btn-primary btn-block">Sign
				In</button>
		</form>
		Dont have an account <a href="signup.jsp">Sign up</a>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script>
        function validateForm() {
            var valid = true;
            var username = document.getElementById('username').value.trim();
            var password = document.getElementById('password').value.trim();
            var usernameError = document.getElementById('usernameError');
            var passwordError = document.getElementById('passwordError');

            // Reset error messages
            usernameError.innerHTML = '';
            passwordError.innerHTML = '';

            // Validate username
            if (username === '') {
                usernameError.innerHTML = 'Username is required';
                valid = false;
            }

            // Validate password
            if (password === '') {
                passwordError.innerHTML = 'Password is required';
                valid = false;
            }

            return valid;
        }
    </script>
</body>
</html>
