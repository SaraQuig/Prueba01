<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.productos.negocio.*" import=" com.productos.datos.*" import= "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// Obtener el producto seleccionado

	String producto = request.getParameter("producto");

	// Obtener el precio de la oferta ingresado
	String precioOferta = request.getParameter("precioOferta");
%>

</body>
</html>