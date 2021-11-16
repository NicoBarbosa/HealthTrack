<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Exercicios</title>
	<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="mt-5">&nbsp; </div>
<div  id="apresentacao" class="container text-center mt-1" >
  <table class="table">
  	<thead>
	    <tr>
	      <th scope="col">DATA</th>
	      <th scope="col">TEMPO</th>
	      <th scope="col">ATIVIDADE</th>
	      <th scope="col">CALORIAS</th>
	      <th scope="col">AÇÕES</th>
	    </tr>
	</thead>
	<tbody>
		<tr>
			<td>19/12/2020</td>
			<td>20 min</td>
			<td>corrida</td>
			<td>300 kcal</td>
			<td>
				<div class="col">
			   	  <div class="row">
			   	  	<div class="col-6 d-flex justify-content-end">
			   	  	  <div class="col-2 icone_pg ">
			   	  	    <a href="">
			   	  	      <%@ include file="./img/lapis.jsp" %>
			   	  	    </a>
				        
			          </div>
			   	  	</div>
			   	    <div class="col-6 ">
			 	      <div class="col-2 icone_pg ">
			 	        <a href="">
			 	          <%@ include file="./img/lixo.jsp" %>
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
  
  <form method="post" action="exercicios.jsp">
    <div class="row">
  	  <div class="col-12 mb-2">
	    <input type="text" class="form-control" placeholder="Tipo de atividade" aria-label="TipoAtiv" step="0.1" min=0>
	  </div>
	  <div class="col">
	    <label>Tempo de Atividade</label>
	    <input type="time" class="form-control" placeholder="Tempo" aria-label="Tempo" step="1" min=0>
	  </div>
	  <div class="col">
	  	<label>Data Atividade</label>
	    <input type="date" class="form-control" placeholder="Last name" aria-label="Data pesagem">
	  </div>
	  <div class="col">
	  	<label>Calorias gastas</label>
	    <input type="number" class="form-control" placeholder="Kcal" aria-label="calorias" step="0.1" min=0>
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