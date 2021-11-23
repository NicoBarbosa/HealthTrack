<%@ include file="header.jsp" %>

<body>
  <%@ include file="menu.jsp" %>
  <div class="mt-5">&nbsp; </div>
  <div id="apresentacao" class="container text-center mt-1">
    <table class="table">
      <thead>
        <tr>
          <th scope="col">DATA</th>
          <th scope="col">TIPO ALIMENTO</th>
          <th scope="col">QUANTIDADE</th>
          <th scope="col">CALORIAS</th>
          <th scope="col"></th>
        </tr>
      </thead>
      <c:forEach items="${alimento}" var="p">
	      <tbody>
	        <tr>
	          <td>
	          	<fmt:formatDate value="${p.data.time}" pattern="dd/MM/yyyy"/>
	          </td>
	          <td>${p.tipo}</td>
	          <td>${p.quantidade}</td>
	          <td>${p.caloria}</td>
	          <td>
	            <div class="col">
	              <div class="row">
	                <div class="col-6 d-flex justify-content-end">
	                  <div class="col-2 icone_pg ">
	                  	<c:url value="alimento" var="link">
	                  		<c:param name="acao" value="abrir-form-edicao"/>
	                  		<c:param name="codigo" value="${p.codigo}"/>
	                  	</c:url>
	                    <a href="${link}">
	                      <%@ include file="../img/lapis.jsp" %>
	                    </a>
	
	                  </div>
	                </div>
	                <div class="col-6 ">
	                  <div class="col-2 icone_pg ">
	                    <a href="" data-target="#excluirModal" onclick="codigoExcluir.value = ${p.codigo}">
	                      <%@ include file="../img/lixo.jsp" %>
	                    </a>
	
	                  </div>
	                </div>
	              </div>
	            </div>
	          </td>
	        </tr>
	      </tbody>
      </c:forEach>
    </table>
  </div>
  <div class="container mt-2">
    <div class="col-12 text-center mb-2">
      <label>Cadastrar novo registro</label>
    </div>

    <form method="post" action="alimento">
      <div class="row">
        <div class="col-12 mb-2">
          <input name="tipo-ali" type="text" class="form-control" placeholder="Tipo de alimento" aria-label="alimento" step="0.1" min=0>
        </div>
        <div class="col">
          <label for="quantidade-ali">Quantidade</label>
          <input name="quantidade-ali" type="number" class="form-control" placeholder="" aria-label="quantidade" step="1" min=0>
        </div>
        <div class="col">
          <label for="caloria-ali">Calorias</label>
          <input name="caloria-ali" type="number" class="form-control" placeholder="unit" aria-label="calorias" step="0.1" min=0>
        </div>

        <div class="col-12 text-center mt-2">
          <button name="acao" value="cadastrar" id="botao_peso" type="submit" class="btn btn-success  btn-block">Cadastrar</button>
        </div>
      </div>
    </form>

  </div>
  <%@ include file="footer.jsp" %>
  <!-- Modal -->
<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmção</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        		Deseja realmente excluir o produto?
      </div>
      <div class="modal-footer">
      	<form action="produto" method="post">
      		<input type="hidden" name="acao" value="excluir">
      		<input type="hidden" name="codigo" id="codigoExcluir">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-danger">Excluir</button>
        </form>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script type="text/javascript" src="resources/js/bootstrap.min"></script>
</body>

</html>
