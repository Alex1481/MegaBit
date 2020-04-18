<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Detalles de la Pelicula</title>
	    <spring:url value="/resources" var="urlPublic"></spring:url>
		<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

	</head>

	<body>

		<jsp:include page="includes/menu.jsp" />

		<div class="container theme-showcase" role="main">

			<!-- Marketing messaging -->
			<div class="container marketing">

				<div class="page-header">
					<h2 align="center">${pelicula.titulo }</h2>
				</div>
				<div class="row">
					<div class="col-sm-5">
						<p class="text-center">
							<img class="img-rounded" src="${urlPublic}/images/${pelicula.imagen}" alt="Generic placeholder image" width="355" height="440">            
						</p>
					</div>
					<div class="col-sm-7">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">DETALLES</h3>
							</div>
							<div class="panel-body">                           
								<p>
									Título Original : ${pelicula.titulo } <br>
									Actores :  <br>
									Director:  <br>                  
									Género: ${pelicula.genero } <br>                  
									Fecha Estreno: ${pelicula.fechaEstreno }                  
								</p> 

							</div>
						</div>                          
					</div>
				</div>

						<h3 align="center"><span >¡PREGUNTA POR LAS PROMOCIONES!</span></h3>


				<div class="container">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 align="center" class="panel-title">Trailer</h3>
							</div>
							<div class="panel-body">
								<p align="center"><iframe width="640" height="400" 
												src="https://www.youtube.com/embed/HwDr7ff5GD4" >                          
								</iframe><p>
							</div>
						</div>            
				</div>

			</div><!-- /.container -->

			<hr class="featurette-divider">

			<jsp:include page="includes/footer.jsp" />

		</div> <!-- /container -->

		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
		<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script> 
	</body>
</html>