<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.productos.negocio.*" import=" com.productos.datos.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Productos en Oferta</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <h1>Productos en Oferta</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio Original</th>
            <th>Precio de Oferta</th>
        </tr>
        <%
        // Obtener la lista de productos en oferta desde la base de datos
        Producto p = new Producto();
			out.print(p.consultarTodoVendedor());
        %>
    </table>
</body>
</html>
