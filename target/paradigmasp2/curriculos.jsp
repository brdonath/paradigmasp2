<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Trabalho Paradigmas P2</title>

	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">

	<link rel="stylesheet" type="text/css" href="style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
	<script type="text/javascript" src="script.js"></script>
</head>
<body>
	<header class="blue darken-2 center-align">
		<a href="index.html">Trabalho Paradigmas P2</a>
	</header>
	<main class="center-align">
		<div class="row">
			<h4>Currículos Cadastrados</h4>
			<a class="orange darken-3 btn" href="mailto:gerente@faculdade.com?Subject=Novo%20Colaborador" target="_top">Notificar Contratação por e-email</a>

			<a class="orange darken-3 btn btnvoltar" href="index.html">Voltar</a>
		</div>
	</main>

	<c:forEach items="${result}" var="result">
		${result.get("nome")}<br>

		idcurriculo: ${result.get("idcurriculo")}  <br>
		nome: ${result.get("nome")}  <br>
		bday: ${result.get("bday")}  <br>
		cpf: ${result.get("cpf")}  <br>
		ecivil: ${result.get("ecivil")}  <br>
		genero: ${result.get("genero")}  <br>
		email: ${result.get("email")}  <br>
		tel: ${result.get("tel")}  <br>
		formacao: ${result.get("formacao")}  <br>
		experiencia1: ${result.get("experiencia1")}  <br>
		experiencia2: ${result.get("experiencia2")}  <br>
		experiencia3: ${result.get("experiencia3")}  <br>
		idioma1: ${result.get("idioma1")}  <br>
		idioma2: ${result.get("idioma2")}  <br>
		pretensaosalarial: ${result.get("pretensaosalarial")}  <br>
		maisinfo: ${result.get("maisinfo")}  <br>

	</c:forEach>


	<footer class="page-footer blue darken-2">
		<div class="footer-copyright">
			<div class="container">
				Criadores: Ana, Edson, Jean, Juliana, Wilson
			</div>
		</div>
	</footer>
</body>
</html>