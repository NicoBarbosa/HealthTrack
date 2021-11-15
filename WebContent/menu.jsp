<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-dark bg-success fixed-top">
  <div class="container-flex">
    <a class="navbar-brand position-absolute start-50" href="index.jsp">HEALTH TRACK</a>
    <button class="navbar-toggler navbar-start" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-start bg-success" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">MENU</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <a class="nav-link" href="perfil.jsp">Perfil</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="peso.jsp">Peso</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="exercicios.jsp">Exercicios</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="alimentos.jsp">Alimentos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="imc.jsp">IMC</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</nav>