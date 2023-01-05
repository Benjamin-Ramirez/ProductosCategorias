<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categoria</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		
		
		<h1>${categorias.name}</h1>
		
		<div class="row">
			<div class="col-6">
			<h2>Productos: </h2>
				<ul>
					<c:forEach items="${categorias.products }" var="pro">
						<li>${pro.name }</li>
					</c:forEach>
				</ul>
			</div>
			
			<div class="col-6">
				<h3>Add Product</h3>
				<form action="/assign_product" method="post">
						<select name="product_id">
							<c:forEach items="${productos }" var="producto">
								<option value="${producto.id }">${ producto.name}</option>
								
							</c:forEach>		
						</select>
						<input type="hidden" name="category_id" value="${categorias.id }"/>
						<input type="submit" value="Add" class="btn btn-success"/>
				</form>
			</div>
			
			
		</div>
		
		
	</div>
</body>
</html>