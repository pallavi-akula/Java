<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="rest/countries/delete" method="post">
Enter Country Id: <input type="text" name="txtId" required pattern="[1-9]{1,3}"/>
<input type="submit" value="Delete">
</form>
</body>
</html>