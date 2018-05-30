<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h4>Vagas disponíveis</h4>
			<a class="orange darken-3 btn" href="mailto:gerente@faculdade.com?Subject=Novo%20Colaborador" target="_top">Notificar Contratação por e-email</a>

			<a class="orange darken-3 btn btnvoltar" href="index.html">Voltar</a>
		</div>
	</main>

	<c:forEach items="${result}" var="result">

		idvaga: ${result.get("idvaga")}<br>
		titulo: ${result.get("titulo")}<br>
		departamento: ${result.get("departamento")}<br>
		descricao: ${result.get("descricao")}<br>
		local: ${result.get("local")}<br>
		bday: ${result.get("bday")}<br>
		escolaridade: ${result.get("escolaridade")}<br>
		linguas: ${result.get("linguas")}<br>
		experienciaminima: ${result.get("experienciaminima")}<br>
		outrasexigencias: ${result.get("outrasexigencias")}<br>
		benecicios1: ${result.get("benecicios1")}<br>
		pretensaosalarial: ${result.get("pretensaosalarial")}<br>
		email: ${result.get("email")}<br>
		tel: ${result.get("tel")}<br>
		benecicios3: ${result.get("benecicios3")}<br>
		benecicios2: ${result.get("benecicios2")}<br>

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