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
      <tbody>
        <tr>
          <td>19/12/2020</td>
          <td>70 kg</td>
          <td>
            <div class="col">
              <div class="row">
                <div class="col-6 d-flex justify-content-end">
                  <div class="col-2 icone_pg ">
                    <a href="">
                      <%@ include file="../img/lapis.jsp" %>
                    </a>

                  </div>
                </div>
                <div class="col-6 ">
                  <div class="col-2 icone_pg ">
                    <a href="">
                      <%@ include file="../img/lixo.jsp" %>
                    </a>

                  </div>
                </div>
              </div>
            </div>
          </td>
        </tr>
      </tbody>
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
</body>

</html>