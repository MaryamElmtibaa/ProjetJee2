<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <% String alertMessage = (String) request.getAttribute("alertMessage");
       if (alertMessage != null) {
           out.println("<script>alert('" + alertMessage + "');</script>");
       }
    %>

</body>
</html>