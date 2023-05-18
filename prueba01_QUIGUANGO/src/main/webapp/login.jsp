<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/estilo.css">
</head>
<body>
	<form action="verificarLogin.jsp" method="POST">

				<div class="section-inputs">
					<!--El FOR hace referencia al id del input-->
					<!--Esta parte correspone al name-->
					<label for="name"> <span>Name</span> <input type="text"
						name="usuario" id="usuario">
					</label>
				</div>

				<!--Esta parte correspone al password-->
				<label for="password"> <span>password</span> <input
					id="clave" type="password" name="clave" placeholder="6+caracteres">
				</label>
				<!--Esta parte correspone al checkbox de aceptar terminos-->
				
				<!--Este es el boton de crear cuenta-->
				<button type="submit" class="submit-btn">Entrar</button>
			</form>
			<br> <a href="registrarse.jsp">Crear cuenta</a> <a href="">Cambiar
				clave</a>
</body>
</html>