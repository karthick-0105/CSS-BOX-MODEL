<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html><head><title>Login</title></head>
<body>
  <form method="post" action="login.jsp">
    <table>
      <tr><td>Username</td><td><input name="uname" /></td></tr>
      <tr><td>Password</td><td><input type="password" name="pass" /></td></tr>
      <tr><td colspan="2"><input type="submit" value="Login" /></td></tr>
    </table>
    <p>Not registered? <a href="reg.jsp">Register here</a></p>
  </form>
</body>
</html>
