<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Usuario::</title>
</head>

<body>
<jsp:include page="templates/navbar.jsp"/>
	<div class="container-fluid">
		<form:form method="post" action="" modelAttribute="celular">
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre"/>
			<br>
			<form:label path="apellido">Apellido:</form:label>
			<form:input type="text" path="apellido"/>
			<br>
			<form:label path="celular">Celular:</form:label>
			<form:input type="text" path="celular"/>
			<br>
			<form:label path="marca">Marca:</form:label>
			<form:input type="text" path="marca"/>
			<br>
		</form:form>
		
		<table>
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Numero</th>
					<th scope="col">Marca</th>
					<th scope="col">Usuario</th>
					<th scope="col-2">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaCelulares}" var="celular">
					<tr>
						<th scope="row">${celular.getId()}</th>
						<td>${usuario.getCelular()}</td>
                        <td>${usuario.getMarca()}</td>
                        <td>${usuario.getUsuario().getNombre()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

</html>