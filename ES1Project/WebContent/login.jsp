<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Sistema revistas - login</title>
  <link rel="stylesheet" href="css/style.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
  <div class="title-container">
  	<h1 class="title">Sistema Revistas</h1>
  </div>
  <div class="login-form">
	  
	  <c:if test="${mensagem != null && mensagem.tipo eq 'mensagemErro'}">
	  	<div class="errormsgbox">${mensagem.texto}</div>
	  </c:if>
	  
	  <form method="post" action="login" class="login">
	    <p>
	      <label for="login">Usuário:</label>
	      <input type="text" name="nome" id="login">
	    </p>
	
	    <p>
	      <label for="password">Senha:</label>
	      <input type="password" name="senha" id="password">
	    </p>
	
	    <p class="login-submit">
	      <button type="submit" class="login-button">Login</button>
	    </p>
	
	  </form>
	</div>
</body>
</html>