<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.productos.negocio.*" import=" com.productos.datos.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eliminar producto</title>
<link rel="stylesheet" href="css/estilo.css">
</head>
<body>
	<%
	int cod = Integer.parseInt(request.getParameter("cod"));
	Producto cp = new Producto();
	boolean f = cp.EliminarProducto(cod);
	if(f==true){
		response.sendRedirect("categoria.jsp");
	}
	%>
</body>
</html>