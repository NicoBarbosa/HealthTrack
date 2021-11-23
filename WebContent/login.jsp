<%@ include file="header.jsp" %>

<body class="text-center">
  <%@ include file="menu.jsp" %>

  <main class="form-signin">
    <form>
    	<c:if test="${not empty msg })">
	      	<div class="alert alert-success">${msg}</div>
	      </c:if>
	      <c:if test="${not empty erro })">
	      	<div class="alert alert-danger">${erro}</div>
	      </c:if>
      <h1 class="h3 mb-3 fw-normal">Entrar</h1>

      <div class="form-floating">
        <input type="email" class="form-control" name="email" id="email" placeholder="name@example.com">
        <label for="email">Email</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" name="senha" id="senha" placeholder="Senha">
        <label for="senha">Senha</label>
      </div>

      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Lembre de mim
        </label>
      </div>
      <button class="w-100 btn btn-lg btn-success" type="submit">Entrar</button>
      <a class="w-100 mt-2 btn btn-lg btn-primary" href="cadastro.jsp">Cadastrar</a>
      <p class="mt-5 mb-3 text-muted">&copy; 2021 <strong>Time 9</strong></p>
    </form>
  </main>

  <%@ include file="footer.jsp" %>
</body>

</html>