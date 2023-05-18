<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" import="com.productos.seguridad.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
 <link rel="stylesheet" href="css/estilo.css">
 <link rel="stylesheet" href="css/menu.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
</head>
<body>
<DIv class="container_">
        <header class="header_">
            <img class="img-logo" src="img/logo-obscuro.png" alt="logo">
           
                <ul class="navigation">
                	<li><a href="categoria.jsp">Categorias</a></li>
                 
                  </ul>
           
           
        </header>
    </DIv>
	<%
String usuario;
HttpSession sesion = request.getSession();
 if (sesion.getAttribute("usuario") == null) //Se verifica si existe la variable
 {
 %>
	<jsp:forward page="login.jsp">
		<jsp:param name="error" value="Debe registrarse en el sistema." />
	</jsp:forward>
	<%
 }
 else
 {
 usuario=(String)sesion.getAttribute("usuario"); //Se devuelve los valores de atributos
 int perfil=(Integer)sesion.getAttribute("perfil");
 %>
	<h1>Sitio Privado de Productos</h1>
	<h4>
		Bienvenido
		<%
out.println(usuario);
%>
	</h4>


	<%
			
			Pagina pag=new Pagina();
			String menu=pag.mostrarMenu(perfil);
			out.print(menu);
			%>
	<%} %>
<footer class="footer">

            <div class="item">
                <div class="cont">
                    <br>
                    <p>Creado por: Sara Quiguango</p>
                    <p>&COPY 2023 GAMA CARS | Todos los derechos reservados</p>
                </div>
            </div>
            
    </footer>
</body>
</html>