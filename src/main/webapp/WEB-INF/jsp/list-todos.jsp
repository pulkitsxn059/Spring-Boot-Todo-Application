<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
<title>Yahoo!!</title>
</head>
<body>
<div class="container">
<table class="table table-striped">
<caption>Your Todos Are: </caption>
<thead>
<tr>
    <th>Description</th>
    <th>Target Date</th>
    <th>Is it Done?</th>
    <th>Delete</th>
    <th>Update</th>
</tr>
</thead>
<tbody>
<c:forEach items="${todos}" var="item">
<tr>
    <th>${item.desc}</th>
    <th><fmt:formatDate value="${item.desiredDate}" pattern="dd/MM/yyyy"/></th>
    <th>Date</th>
    <th><a type="button" class="btn btn-warning" href="/delete-todos?id=${item.id}">Delete</a></th>
    <th><a type="button" class="btn btn-success" href="/update-todos?id=${item.id}">Update</a></th>
</tr>
</c:forEach>
</tbody>
</table>
</br>
Hey, Your name is: ${name}
</br>
<div ><a class="btn btn-primary" href="/add-todo">Add a Todo</a></div>
<div ><a class="btn btn-primary" href="/logout">Logout</a></div>
</div>
</body>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</html>