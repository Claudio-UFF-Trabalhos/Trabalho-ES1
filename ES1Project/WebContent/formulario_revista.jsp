<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SIstema Revistas - cadastrar revista</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
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
                <li><a href="#"><i class="fa fa-edit"></i> Exibir revistas cadastradas</a></li>
                <li><a href="#"><i class="fa fa-edit"></i> Cadastrar nova revista</a></li>
              </ul>
            </li>
          </ul>

          <ul class="nav navbar-nav navbar-right navbar-user">
            <li class="dropdown user-dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Administrador <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#"><i class="fa fa-user"></i> Perfil</a></li>
                <li class="divider"></li>
                <li><a href="#"><i class="fa fa-power-off"></i> Log Out</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>

      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <h1>Cadastrar Revista <small> Entre com os dados</small></h1>
          </div>
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-6">

            <form role="form">

              <div class="form-group">
                <label>Nome da revista:</label>
                <input class="form-control">
              </div>
              
              <div class="form-group">
                <label>Preço De:</label>
                <input class="form-control">
              </div>

              <div class="form-group">
                <label>Preço Por:</label>
                <input class="form-control">
              </div>

              <div class="form-group">
                <label>Tem formato digital:</label>
                <label class="radio-inline">
                  <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline1" value="option1" checked> Sim
                </label>
                <label class="radio-inline">
                  <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline2" value="option2">Não
                </label>
              </div>
              
              <button type="submit" class="btn btn-default">Cadastrar revista</button>
              <button type="reset" class="btn btn-default">Resetar formulário</button>  

            </form>         

          </div>
        </div><!-- /.row -->

      </div><!-- /#page-wrapper -->

    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/showhidemenu.js"></script>

  </body>
</html>