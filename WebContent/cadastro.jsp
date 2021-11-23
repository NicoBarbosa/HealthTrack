<%@ include file="header.jsp" %>

<body class="text-center">
<%@ include file="menu.jsp" %>

  <main class="container mt-5">
	<h1 class="h3 mb-3 fw-normal">Cadastrar</h1>
	<form method="post" action="usuario">
	      <c:if test="${not empty msg })">
	      	<div class="alert alert-success">${msg}</div>
	      </c:if>
	      <c:if test="${not empty erro })">
	      	<div class="alert alert-danger">${erro}</div>
	      </c:if>
		<div class="form-floating mb-3">
		  <input type="text" class="form-control" id="nome" name="nome" placeholder="Insira seu nome">
		  <label for="nome">Nome</label>
		</div>
		<div class="row">
			<div class="col form-floating mb-3">
			  <input type="email" class="form-control" name="email" id="email" placeholder="Insira seu email">
			  <label for="email">Email</label>
			</div>
			<div class="col form-floating mb-3">
			  <input type="password" class="form-control" name="senha" id="senha" placeholder="Insira sua senha">
			  <label for="senha">Senha</label>
			</div>
		</div>
		<div class="row">
			<div class="col form-floating mb-3">
			  <input type="text" class="form-control" id="dtNascimento" name="dtNascimento" placeholder="Insira seu nome">
			  <label for="dtNascimento">Data de Nascimento</label>
			</div>
			<div class="col form-floating mb-3">
			  <input type="text" class="form-control" id="sexo" name="sexo" placeholder="Insira seu nome">
			  <label for="sexo">Sexo</label>
			</div>
			<div class="col form-floating mb-3">
			  <input type="text" class="form-control" id="altura" name="altura" placeholder="Insira seu nome">
			  <label for="altura">Altura</label>
			</div>
		</div>
		 <div class="checkbox mb-3">
		  <label>
		    <input type="checkbox" value="remember-me"> Lembre de mim
		  </label>
		</div>
		<div class="checkbox mb-3">
		  <button class="w-100 btn btn-lg btn-success" type="submit">Cadastrar</button>
		</div>
		<p class="mt-5 mb-3 text-muted">Já possui conta? <a href="login.jsp" class="text-success">Clique aqui para entrar</a>.</p>
		<p class="mt-5 mb-3 text-muted">&copy; 2021 <strong>Time 9</strong></p>
	</form>
  </main>

  <%@ include file="footer.jsp" %>
</body>

</html>