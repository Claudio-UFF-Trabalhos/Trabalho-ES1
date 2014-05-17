<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sistema Revistas - editar revista</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/validationEngine.jquery.css">
    <link rel="stylesheet" href="css/jquery-ui.css">    
    
  </head>

  <body>

    <div id="wrapper">

      <!-- Sidebar -->
      <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="">Sistema Revistas</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav side-nav">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" id="menu-top" data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i> Gerenciar revistas <b class="caret"></b></a>
              <ul id="dropdown-menu-items" class="dropdown-menu">
                <li><a href="http://localhost:8080/ES1Project/listaRevista"><i class="fa fa-table"></i> Exibir revistas cadastradas</a></li>
                <li><a href="http://localhost:8080/ES1Project/formularioRevista"><i class="fa fa-edit"></i> Cadastrar nova revista</a></li>
              </ul>
            </li>
          </ul>

          <ul class="nav navbar-nav navbar-right navbar-user">
            <li class="dropdown user-dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Administrador <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#"><i class="fa fa-power-off"></i> Log Out</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>

      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <h1>Editar Revista <small> Entre com os dados</small></h1>
          </div>
        </div><!-- /.row -->
		<div class="form-magazine">
		
			<c:if test="${mensagemErro != null}">
				<div class="errormsgbox">${mensagemErro}</div>
			</c:if>
			
			<c:if test="${mensagemSucesso != null}">
				<div class="successbox">${mensagemSucesso}</div>
			</c:if>
		
	        <div class="row">
	          <div class="col-lg-6">
				
	            <form class="form" method="post" action="editaRevista" role="form">
				  
				  <input type="hidden" name="id" value="${revista.id}" class="form-control" maxlength="100">
				  <input type="hidden" name="estaDeletado" value="${revista.estaDeletado}" class="form-control" maxlength="100">
				  
	              <div class="form-group">
	                <label class="non-radio-label">Nome da revista: <span class="required-field">* </span></label>
	                <input name="nome" value="${revista.nome}" class="form-control nome" maxlength="100">
	              </div>
	              
	              <div class="form-group">
	                <label class="non-radio-label">Preço De: <span class="required-field">* </span></label>
	                <input name="precoDe" value="${revista.precoDe}" class="form-control precoDe" maxlength="10">
	              </div>
	
	              <div class="form-group">
	                <label class="non-radio-label">Preço Por: <span class="required-field">* </span></label>
	                <input name="precoPor" value="${revista.precoPor}" class="form-control precoPor" maxlength="10">
	              </div>
	
				  <c:if test="${revista.temDigital == true}">
		              <div class="form-group">
		                <label class="radio-label">Tem formato digital: <span class="required-field">* </span></label>
		                <label class="radio-inline">
		                  <input type="radio" name="temDigital" id="optionsRadiosInline1" value="true" checked> Sim
		                </label>
		                <label class="radio-inline">
		                  <input type="radio" name="temDigital" id="optionsRadiosInline2" value="false">Não
		                </label>
		              </div>
		          </c:if>

				  <c:if test="${revista.temDigital != true}">
		              <div class="form-group">
		                <label class="radio-label">Tem formato digital: <span class="required-field">* </span></label>
		                <label class="radio-inline">
		                  <input type="radio" name="temDigital" id="optionsRadiosInline1" value="true"> Sim
		                </label>
		                <label class="radio-inline">
		                  <input type="radio" name="temDigital" id="optionsRadiosInline2" value="false"  checked> Não
		                </label>
		              </div>
		          </c:if>
         			
         		  <c:if test="${revista != null}">	
	              	<button type="submit" class="btn btn-default">Editar revista</button>
				  </c:if>	
	            </form>         
				
				<br />
				<br />
				<br />
				<a class="back_button" href="http://localhost:8080/ES1Project/listaRevista">voltar para lista de revistas</a>
	          </div>
	        </div><!-- /.row -->
		</div>
      </div><!-- /#page-wrapper -->

    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/showhidemenu.js"></script>
    <script src="js/jquery.mask.min.js"></script>
 	<script src="js/jquery.validate.min.js"></script>
 	<script src="js/jquery.validationEngine-pt_BR.js"></script>
 	<script src="js/jquery.validationEngine.js"></script>
    <script src="js/validate.revista.js"></script>

  </body>
</html>