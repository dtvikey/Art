<html>
	<head>
		<title>Login</title>
		<link rel="stylesheet" href="../../../css/login.css">
	</head>
	<body>
		<div class="login">
			<div class="header">
				<h1>
					<a href="/login.do">Login</a>
				</h1>
				<button></button>
			</div>
			<form action="/login.do" method="post">
				<div class="name">
					<input type="text" id="name" name="username">
					<p></p>
				</div>
				<div class="pwd">
					<input type="password" id="pwd" name="password">
					<p></p>
				</div>
				<div class="btn-red">
					<input type="submit" value="Login" id="login-btn">
				</div>
			</form>
		</div>
	</body>
</html>