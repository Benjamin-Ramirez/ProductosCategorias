<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>${productos.name}</h1>
		
		<div class="row">
			<div class="col-6">
			<h2>Categories: </h2>
				<ul>
					<c:forEach items="${productos.categories }" var="cat">
						<li>${cat.name }</li>
					</c:forEach>
				</ul>
			</div>
			
			<div class="col-6">
				<h3>Add Category</h3>
				<form action="/assign_category" method="post">
						<select name="category_id">
							<c:forEach items="${categorias }" var="categoria">
								<option value="${categoria.id }">${ categoria.name}</option>
								
							</c:forEach>		
						</select>
						<input type="hidden" name="product_id" value="${productos.id }"/>
						<input type="submit" value="Add" class="btn btn-success"/>
				</form>
			</div>
			
			
		</div>
		
		
		
	</div>
</body>
</html>