<%@ page language="java" %>
<html>
<head>
<title>Register</title>
</head>
<body>

<h2>User Registration</h2>

<form action="/auth/register" method="post">
    Name: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Password: <input type="password" name="password"><br><br>
    Role: <input type="text" name="role"><br><br>
    <button type="submit">Register</button>
</form>

</body>
</html>
