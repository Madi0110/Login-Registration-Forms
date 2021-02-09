<%@ include file="header.jsp"  %>
<form action="register" method="post">
    <input type="text" name="fname" placeholder="First Name" /><hr>
    <input type="text" name="lname" placeholder="Last Name" /><hr>
    <input type="text" name="login" placeholder="Login" /><hr>
    <input type="password" name="password" placeholder="Password" /><hr>
    <input type="submit" name="submit" value="Submit" />
</form>
<div class="output">
<%
    if (request.getMethod().equals("POST")) {
        if (!request.getParameter("fname").equals("")) {
            out.print("<p>Login: " + request.getParameter("fname") + "</p>");
        }
        if (!request.getParameter("lname").equals("")) {
            out.print("<p>Login: " + request.getParameter("lname") + "</p>");
        }
        if (!request.getParameter("login").equals("")) {
            out.print("<p>Login: " + request.getParameter("login") + "</p>");
        }
        if (!request.getParameter("password").equals("")) {
            out.print("<p>Password: " + request.getParameter("password") + "</p>");
        }
    }
%>
</div>
