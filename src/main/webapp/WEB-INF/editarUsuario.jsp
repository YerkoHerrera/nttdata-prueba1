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
    <title>Editar Usuario::</title>
</head>

<body>
	<div class="container-fluid">
		<form:form method="post" action="/usuario/update/${usuario.id}" modelAttribute="usuario">
			<input type="hidden" name="_method" value="put">
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre"/>
			<br>
			<form:label path="apellido">Apellido:</form:label>
			<form:input type="text" path="apellido"/>
			<br>
			<form:label path="limite">Limite:</form:label>
			<form:input type="text" path="limite"/>
			<br>
			<form:label path="codigoPostal">C�digo Postal:</form:label>
			<form:input type="text" path="codigoPostal"/>
			<br>
			<form:label path="email">Email:</form:label>
			<form:input type="text" path="email"/>
			<br>
			<input type="button" value="Limpiar">
			<input type="submit" value="Submit">


		</form:form>
		
	</div>
</body>

</html>