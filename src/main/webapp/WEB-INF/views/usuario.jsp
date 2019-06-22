<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Nuevo Usuario</title>
</head>
<body>

	<h2>Usuarios:</h2>
	<form:form  method="POST" action="crearUsuario" modelAttribute="usuario">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><form:input path="nombre" /></td>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><form:input path="apellido" /></td>
			</tr>
			<tr>
				<td>Fecha de nacimiento:</td>
				<td><form:input type="date" path="fechaNac" /></td>
			</tr>

			<tr>
				<td>Roles:</td>
				<td><form:select path="idRoles">
						<c:forEach items="${role}" var="r">
						<option value="${r.id}">${r.rol}</option>
						</c:forEach>  
				</form:select></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>