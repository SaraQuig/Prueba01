<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.productos.negocio.*" import=" com.productos.datos.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Colocar Oferta</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <h1>Colocar Oferta</h1>
    <form action="colocarOferta.jsp" method="post">
        <label for="producto">Producto:</label>
            <%
            Categoria cat = new Categoria();
            out.print(cat.mostrarCategoria());
       
            %>
        
        <br>
        <label for="precioOferta">Precio de oferta:</label>
        <input type="text" name="precioOferta" id="precioOferta">
        <br>
        <button type="submit"></button>
    </form>
</body>
</html>
