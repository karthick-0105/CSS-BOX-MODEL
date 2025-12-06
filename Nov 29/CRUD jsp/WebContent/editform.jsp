<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.javatpoint.dao.UserDao, com.javatpoint.bean.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Edit Form</title>
</head>
<body>

<%
    String id = request.getParameter("id");
    if (id == null) {
        response.sendRedirect("viewusers.jsp");
        return;
    }
    User u = UserDao.getRecordById(Integer.parseInt(id));
    if (u == null) {
        response.sendRedirect("viewusers.jsp");
        return;
    }
%>

<h1>Edit Form</h1>
<form action="edituser.jsp" method="post">
  <input type="hidden" name="id" value="<%= u.getId() %>"/>
  <table>
    <tr>
      <td>Name:</td>
      <td><input type="text" name="name" value="<%= u.getName() %>" required/></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type="password" name="password" value="<%= u.getPassword() %>" required/></td>
    </tr>
    <tr>
      <td>Email:</td>
      <td><input type="email" name="email" value="<%= u.getEmail() %>" required/></td>
    </tr>
    <tr>
      <td>Sex:</td>
      <td>
        <input type="radio" name="sex" value="male" <%= "male".equalsIgnoreCase(u.getSex()) ? "checked" : "" %>/>Male
        <input type="radio" name="sex" value="female" <%= "female".equalsIgnoreCase(u.getSex()) ? "checked" : "" %>/>Female
      </td>
    </tr>
    <tr>
      <td>Country:</td>
      <td>
        <select name="country">
          <option <%= "India".equals(u.getCountry()) ? "selected" : "" %>>India</option>
          <option <%= "Pakistan".equals(u.getCountry()) ? "selected" : "" %>>Pakistan</option>
          <option <%= "Afghanistan".equals(u.getCountry()) ? "selected" : "" %>>Afghanistan</option>
          <option <%= "Burma".equals(u.getCountry()) ? "selected" : "" %>>Burma</option>
          <option <%= "Other".equals(u.getCountry()) ? "selected" : "" %>>Other</option>
        </select>
      </td>
    </tr>
    <tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>
  </table>
</form>

</body>
</html>