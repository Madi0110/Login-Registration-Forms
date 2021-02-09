<%@ include file="header.jsp"  %>
<form action="login" method="post">
    <input type="text" name="login" placeholder="Login" /><hr>
    <input type="password" name="password" placeholder="Password" /><hr>
    <input type="submit" name="submit" value="Submit" />
</form>
<div class="output">
<%
    if (request.getMethod().equals("POST")) {
        if (!request.getParameter("login").equals("")) {
            out.print("<p>Login: " + request.getParameter("login") + "</p>");
        }
        if (!request.getParameter("password").equals("")) {
            out.print("<p>Password: " + request.getParameter("password") + "</p>");
        }

    }
%>
</div>
