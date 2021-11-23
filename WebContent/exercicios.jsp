<%@ include file="header.jsp" %>

<body>
  <%@ include file="menu.jsp" %>
  	<br>
  	<br>
  	<c:if test="${not empty msg }">
      	<div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${not empty erro }">
      	<div class="alert alert-danger">${erro}</div>
    </c:if>
    
  <div class="mt-5">&nbsp; </div>
 
  <div class="container mt-2">

    <form method="post" action="exercicios">
    
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
          <button id="botao_peso" value="cadastrar" type="submit" class="btn btn-success  btn-block">Cadastrar</button>
        </div>
      </div>
    </form>
    
    <table class="table table-striped">
        	<tr>
				<th>Nome Atividade</th>
				<th>Calorias</th>
				<th>Data</th>		
			</tr>
			<c:forEach items="${atividades}" var="a">
				<tr>
					<td>${a.tipoAtividade}</td>
					<td>${a.calorias}</td>
					<td>
						<fmt:formatDate value="${a.tempo.time}" pattern="dd/MM/yyyy"/>
					</td>
				</tr>
			</c:forEach>
        </table>

  </div>
  <%@ include file="footer.jsp" %>

</body>

</html>