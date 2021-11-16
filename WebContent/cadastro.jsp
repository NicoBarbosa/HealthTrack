<%@ include file="header_auth.jsp" %>

<body class="text-center">
  <%@ include file="menu.jsp" %>

  <main class="form-signin">
    <form>
      <h1 class="h3 mb-3 fw-normal">Cadastrar</h1>

      <div class="form-floating">
        <input type="text" class="form-control" id="name" placeholder="Insira seu nome">
        <label for="name">Nome</label>
      </div>
      <div class="form-floating">
        <input type="email" class="form-control" id="email" placeholder="Insira seu email">
        <label for="email">Email</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="senha" placeholder="Insira sua senha">
        <label for="senha">Senha</label>
      </div>

      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Lembre de mim
        </label>
      </div>
      <a class="w-100 btn btn-lg btn-succes" href="index.jsp">Entrar</a>
      <a class="w-100 btn btn-lg btn-primary" href="cadastro.jsp">Cadastrar</a>
      <p class="mt-5 mb-3 text-muted">&copy; 2021 <strong>Time 9</strong></p>
    </form>
  </main>

  <%@ include file="footer.jsp" %>
</body>

</html>