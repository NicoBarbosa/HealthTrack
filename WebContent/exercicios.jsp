<%@ include file="header.jsp" %>

<body>
  <%@ include file="menu.jsp" %>
  
  	<c:if test="${not empty msg }">
      	<div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${not empty erro }">
      	<div class="alert alert-danger">${erro}</div>
    </c:if>
    
  <div class="mt-5">&nbsp; </div>
 
  <div class="container mt-2">
    <div class="col-12 text-center mb-2">
      <label>Cadastrar novo registro</label>
    </div>

    <form method="post" action="atividades">
    
      <h1 class="h3 mb-3 fw-normal">Cadastrar Atividade Física</h1>
      <div class="row">
        <div class="col-12 mb-2">
          <input type="text" name="atividade" class="form-control" placeholder="Tipo de atividade" aria-label="TipoAtiv" step="0.1"
            min=0>
        </div>
        
        <div class="col">
          <label>Calorias gastas</label>
          <input type="number" name="calorias" class="form-control" placeholder="Kcal" aria-label="calorias" step="0.1" min=0>
        </div>
        
        <div class="col-12 text-center mt-2">
          <button id="botao_peso" type="submit" class="btn btn-success  btn-block">Cadastrar</button>
        </div>
      </div>
    </form>
    
    <table class="table table-striped">
        	<tr>
				<th>Nome Atividade</th>
				<th>Calorias</th>
				<th>Data</th>		
				<th></th>	
			</tr>
			<c:forEach items="${atividades}" var="a">
				<tr>
					<td>${a.tipoAtividade}</td>
					<td>${a.calorias}</td>
					<td>
						<fmt:formatDate value="${a.tempo.time}" pattern="dd/MM/yyyy"/>
					</td>
					<td>
					<button type="button" class="btn btn-danger btn-xs" data-bs-toggle="modal" data-bs-target="#excluirModal" onclick="codigoExcluir.value = ${a.codigo}">
  						Excluir
					</button>
					</td>
				</tr>
			</c:forEach>
        </table>

  </div>
  <%@ include file="footer.jsp" %>
  
<!-- Modal -->
<div class="modal fade" id="excluirModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Deseja realmente excluir o produto?
      </div>
      <div class="modal-footer">
      <form action="produto" method="post">
      	<input type="hidden" name="codigo" id="codigoExcluir">
      	<input type="hidden" name="acao" value="excluir">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-danger">Excluir</button>
      </form>
      </div>
    </div>
  </div>
</div>

</body>

</html>