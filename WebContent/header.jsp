<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://javav.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://javav.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="ISO-8859-1">
  <title>Health Track</title>
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" 
  integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" 
  crossorigin="anonymous"
  />
  <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/style.css">
  <script>
  	const perfil = "http://"+window.location.host+"/HealthTrack/perfil.jsp"
  	const login = "http://"+window.location.host+"/HealthTrack/login.jsp"
  	const cadastro = "http://"+window.location.host+"/HealthTrack/cadastro.jsp"
  	const url = window.location.href
  	
  	function perfilCss(){
  		return document.write("<link rel='stylesheet' href='css/perfil.css'>")
  	}
  	function signinCss(){
  		return document.write("<link rel='stylesheet' href='css/signin.css'>")
  	}  	
  	
  	if(url === perfil) {
  		perfilCss()
	}
  	
  	if(url === login || url === cadastro) {
  		signinCss()
	}
  </script>
  <link rel="stylesheet" href="css/index.css">
</head>