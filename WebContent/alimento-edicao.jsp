<%@ include file="header.jsp" %>

<body>
  <%@ include file="menu.jsp" %>
  <div class="mt-5">&nbsp; </div>
	
	<div class="container mt-2">
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
	    <div class="col-12 text-center mb-2">
	      <label>Cadastrar novo registro</label>
	    </div>
		
	    <form method="post" action="alimento">
	      <div class="row">
	      	<input type="hidden" value="editar" name="acao">
			<input type="hidden" value="${alimento.codigo}" name="codigo">
	        <div class="col-12 mb-2">
	          <input id="tipo-ali" type="text" class="form-control" placeholder="Tipo de alimento" value="${alimento.tipo-ali}" aria-label="alimento" step="0.1" min=0>
	        </div>
	        <div class="col">
	          <label for="quantidade-ali">Quantidade</label>
	          <input id="quantidade-ali" type="number" class="form-control" placeholder="" value="${alimento.quantidade-ali }" aria-label="quantidade" step="1" min=0>
	        </div>
	        <div class="col">
	          <label for="caloria-ali">Calorias</label>
	          <input id="caloria-ali" type="number" class="form-control" placeholder="unit" value="${alimento.caloria-ali }" aria-label="calorias" step="0.1" min=0>
	        </div>
	        <div class="col">
	          <label for="data-ali">Data Atividade</label>
	          <input id="data-ali" type="date" class="form-control" placeholder="Last name" value="${alimento.data-ali }" aria-label="Data pesagem">
	        </div>
	
	        <div class="col-12 text-center mt-2">
	          <button id="botao_peso" type="submit" class="btn btn-success  btn-block">Cadastrar</button>
	          <a href="alimento?acao=listar" class="btn btn-danger"></a>
	        </div>
	      </div>
	    </form>
	
	  </div>
<%@ include file="footer.jsp" %>
</body>

</html>
