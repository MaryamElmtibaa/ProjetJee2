<%
String username1=request.getParameter("username");
String password1=request.getParameter("password");

if(username1.equalsIgnoreCase("admin")&&password1.equalsIgnoreCase("admin"))
{
	response.sendRedirect("header.jsp");
	}
else 
	response.sendRedirect("errorAdminLogin.html");
	%>