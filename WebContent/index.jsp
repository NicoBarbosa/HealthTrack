<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Health Track</title>
	<%@ include file="header.jsp" %>
	<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<%@ include file="menu.jsp" %>
	
	<%-- Mostra os bpm / segundo --%>
	<div class="container_bpm">
        <div class="bpm">
            <p class="b89">89</p>
            <span>kcal</span>
        </div>
    </div>
    
    <%-- Mostra as sistolicas --%>
	<div class="container_sistolicas">
        <div class="sistolicas">
            <p class="s12">12</p>
            <span>Sistolica</span>
        </div>
    </div>
    
    <%-- Mostra as diastolicas --%>
    <div class="container_diastolica">
        <div class="diastolica">
            <p class="d9">9</p>
            <span>Diastolica</span>
        </div>
    </div>
    
	<%@ include file="footer.jsp" %>
</body>
</html>