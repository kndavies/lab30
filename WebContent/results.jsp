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
<h1>Results!</h1>
<ul>
<c:forEach items="${movies}" var="movie">
    <li><c:out value="${movie}"/></li>
</c:forEach>
</ul>
<input type="button" onclick="history.back()" value="Go back" />
</section>
</body>
</html>