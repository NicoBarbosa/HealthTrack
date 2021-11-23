<%@ include file="header.jsp" %>

<body>
	
  <%@ include file="menu.jsp" %>
  <div class="mt-5">&nbsp; </div>
  <div id="apresentacao" class="container text-center mt-1">
    <table class="table">
      <thead>
        <tr>
          <th scope="col">DATA</th>
          <th scope="col">PESO (KG)</th>
          <th scope="col">AÇÕES</th>
        </tr>
      </thead>
      <c:forEach items="${peso}" var="p">
      <tbody>
        <tr>
          <td><fmt:formatDate value="${p.data.time}" pattern="dd/MM/yyyy"/></td>
          <td>${p.data.vlPeso}</td>
          <td>
            <div class="col">
              <div class="row">
                <div class="col-6 d-flex justify-content-end">
                  <div class="col-2 icone_pg ">
                  <c:url value="peso" var="link">
	                  		<c:param name="acao" value="abrir-form-edicao"/>
	                  		<c:param name="codigo" value="${p.codigo}"/>
	                  	</c:url>
                    <a href="">
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

    <form method="post" action="peso.jsp">
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
  <%@ include file="footer.jsp" %>
  <!-- Modal -->
<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
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
