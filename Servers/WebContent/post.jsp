<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<form name="frm" method="post" action="rest/countries">
	Enter Country id: <input type="text" name="txtId" required pattern="[1-9]{1,3}"/><br>
	Enter Country name: <input type="text" name="txtName" required pattern="[A-Za-z]+"/><br>
	Enter Country Population: <input type="text" name="txtPopulation" required pattern="[1-9]{1}[0-9]{5,}"/><br>
	
	<input type="submit" value="Add Country" />
</form>
</body>
</html>