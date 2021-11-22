<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="ISO-8859-1">
  <title>Health Track</title>
  <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="resources/css/signin.css">
  <style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }
  </style>
</head>

<body class="text-center">
<%@ include file="menu.jsp" %>
  <%@ include file="menu.jsp" %>

  <main class="form-signin">
    <form method="post">
      <h1 class="h3 mb-3 fw-normal">Cadastrar</h1>
      <c:if test="${not empty msg })">
      	<div class="alert alert-success">${msg}</div>
      </c:if>
      <c:if test="${not empty erro })">
      	<div class="alert alert-danger">${erro}</div>
      </c:if>
      <div class="form-floating mb-3">
        <input type="text" class="form-control" id="name" placeholder="Insira seu nome">
        <label for="name">Nome</label>
      </div>
      <div class="form-floating mb-3">
        <input type="email" class="form-control" id="email" placeholder="Insira seu email">
        <label for="email">Email</label>
      </div>
      <div class="form-floating mb-3">
        <input type="password" class="form-control" id="senha" placeholder="Insira sua senha">
        <label for="senha">Senha</label>
      </div>

      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Lembre de mim
        </label>
      </div>
      <div class="checkbox mb-3">
        <a class="w-100 btn btn-lg btn-success" href="index.jsp">Entrar</a>
        <a class="w-100 btn btn-lg btn-primary" href="cadastro.jsp">Cadastrar</a>
      </div>
      <p class="mt-5 mb-3 text-muted">&copy; 2021 <strong>Time 9</strong></p>
    </form>
  </main>

  <%@ include file="footer.jsp" %>
</body>

</html>