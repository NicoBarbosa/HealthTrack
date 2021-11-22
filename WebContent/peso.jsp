<%@ include file="header.jsp" %>
</head>

<body>
  <%@ include file="menu.jsp" %>
  <div class="mt-5">&nbsp; </div>
  <div id="apresentacao" class="container text-center mt-1">
  
  <div class="container mt-2">
    <div class="col-12 text-center mb-2">
      <label>Cadastrar novo registro</label>
    </div>
    
    <c:if test="${not empty msg }">
	<div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${not empty erro }">
	    <div class="alert alert-danger">${erro}</div>
    </c:if>

    <form method="post" action="peso.jsp">
    <input type="hidden" value="cadastrar" name="acao">
      <div class="row">
        <div class="col">
          <input type="number" class="form-control" placeholder="Peso" aria-label="Peso" step="0.1" min=0>
        </div>
        <div class="col">
          <input type="date" class="form-control" placeholder="Last name" aria-label="Data pesagem">
        </div>
        <div class="col-12 text-center mt-2">
          <button id="botao_peso" type="submit" class="btn btn-success  btn-block">Cadastrar</button>
        </div>
      </div>
    </form>
    
  </div>
  </div>
  <%@ include file="footer.jsp" %>
</body>

</html>