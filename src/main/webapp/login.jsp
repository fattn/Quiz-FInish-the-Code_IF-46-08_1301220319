<%-- 
    Document   : login
    Created on : 26 Nov 2024, 10.58.49
    Author     : helmy
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
--%>

<html>
<head>
    <title>Halaman Login</title>
</head>
<body>
    <h2>Login</h2>
    
    <form action="login" method="POST">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <button type="submit">Login</button>
    </form>

    <!-- Tampilkan pesan error jika login gagal -->
	<%
		if (request.getAttribute("errorMessage") != null) {
	%>
        <p style="color:red;"><%= request.getAttribute("errorMessage") %></p>
	<%
		}
	%>

    <!-- Cek apakah pengguna sudah login, jika sudah, redirect ke welcome.jsp -->
	<%
		if (session.getAttribute("user") != null) {
	%>
        <p>You are already logged in. <a href="/welcome.jsp">Go to Welcome Page</a></p>
	<%
		}
	%>
</body>
</html>
