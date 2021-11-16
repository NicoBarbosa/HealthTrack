<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Perfil</title>
	<%@ include file="header.jsp" %>
	<link rel="stylesheet" href="css/perfil.css">
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="container">
		<div class="foto-perfil">
	      <img src="img/tanjiro.jpg" alt="Tanjiro">
	      <p>Tanjiro Kamado</p>
	      <p>tanjiro@gmail.com</p>
	    </div>
    </div>
      <!-- Botão sair  -->
      <a href="login.html"><button type="button" class="btn btn-outline-danger"><img class="power" src="img/power.svg"> Sair</button></a>
	<%@ include file="footer.jsp" %>
</body>
</html>