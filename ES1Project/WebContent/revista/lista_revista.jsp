<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sistema Revistas - lista de revista</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
	<link href="css/lightbox.css" rel="stylesheet">
		
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
                <li><a href="http://localhost:8080/ES1Project/revista/listaRevista"><i class="fa fa-table"></i> Exibir revistas cadastradas</a></li>
                <li><a href="http://localhost:8080/ES1Project/revista/formularioRevista"><i class="fa fa-edit"></i> Cadastrar nova revista</a></li>
              </ul>
            </li>
          </ul>

          <ul class="nav navbar-nav navbar-right navbar-user">
            <li class="dropdown user-dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${usuario.nome} <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="http://localhost:8080/ES1Project/logout"><i class="fa fa-power-off"></i> Log Out</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>

      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <h1>Lista de Revistas</h1>
          </div>
        </div><!-- /.row -->
        
        <c:if test="${mensagemErro != null}">
			<div class="errormsgbox">${mensagemErro}</div>
		</c:if>
		
		<c:if test="${mensagemSucesso != null}">
			<div class="successbox">${mensagemSucesso}</div>
		</c:if>
     
          <div class="col-lg-6">
            <div class="table-responsive">
            
             <c:if test="${revistas == null || fn:length(revistas) eq 0}"> 
               <h4 class="no_magazines">Não há revistas cadastradas.</h4>	
             </c:if>
             
             <c:if test="${revistas != null && fn:length(revistas) gt 0}"> 
            
	              <table class="table table-hover table-striped tablesorter">
	                <thead>
	                  <tr>
	                    <th>id <i class="fa fa-sort"></i></th>
	                    <th>Nome <i class="fa fa-sort"></i></th>
	                    <th>Tipo <i class="fa fa-sort"></i></th>
	                    <th>Descrição <i class="fa fa-sort"></i></th>
	                    <th>Formato Digital <i class="fa fa-sort"></i></th>
	                    <th>Preço De <i class="fa fa-sort"></i></th>
	                    <th>Preço Por <i class="fa fa-sort"></i></th>
	                    <th>Gerenciar</th>
	                  </tr>
	                </thead>
	                <tbody>
	                  <c:forEach items="${revistas}" var="revista" varStatus="status">
	                    <tr>
	                      <td>${revista.id}</td>
	                      <td>${revista.nome}</td>
	                      <td>${revista.tipo}</td>
	                      <td>${revista.descricao}</td>      
	                      <c:if test="${revista.temDigital == true}">
	                        <td>Sim</td>	
	                      </c:if>
	                      <c:if test="${revista.temDigital != true}">
	                        <td>Não</td>	
	                      </c:if>
	                      <td>${revista.precoDeFormatado}</td>
	                      <td>${revista.precoPorFormatado}</td>
	                      <td><a class="manage-magazine" href="http://localhost:8080/ES1Project/revista/editaRevista?id=${revista.id}">editar</a>   
	                      <a href="javascript:void(0)" class="manage-magazine" onclick = "summonLightBox('http://localhost:8080/ES1Project/revista/deletaRevista?id=${revista.id}')">excluir</a></td>
	                  </tr>
	                  </c:forEach>
	                </tbody>
	              </table>
	              
	           </c:if>
            </div>
          </div>

      </div><!-- /#page-wrapper -->


    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/showhidemenu.js"></script>
    
    <!-- Page Specific Plugins -->
    <script src="js/tablesorter/jquery.tablesorter.js"></script>
    <script src="js/tablesorter/tables.js"></script>
    <script src="js/lightbox.js"></script>
  
 		<div id="light" class="white_content hidden"></div>
		<div id="fade" class="black_overlay hidden"></div>
  </body>
</html>