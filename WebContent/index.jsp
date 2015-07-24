<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results of Future Value!</title>
<link rel="stylesheet" href="styles/main.css">
</head>
<body>
<section>
<h1>Movie App!</h1>
<img src="cinema.jpg" height="600px" width="600px"/>
<form action="MovieServlet" method="post">
<p>
<select name = "selectGenre">
<c:forEach items="${genres}" var="genre">
    <option value = <c:out value="${genre}"/>><c:out value="${genre}"/></option>
</c:forEach>
</select>
</p>
<input type="submit" value="Submit" />
</form>
</section>
</body>
</html>